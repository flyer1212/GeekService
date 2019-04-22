package com.geek.controller;


import com.geek.entity.Response;
import com.geek.entity.ResponseResult;
import com.geek.entity.User;
import com.geek.entity.UserTask;
import com.geek.redis.RedisClient;
import com.geek.service.UserService;
import com.geek.util.CookieUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@Api("user controller")
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    public static final int COOKIE_EXPIRED = 21600;


    @Autowired
    UserService userService;

    @Autowired
    RedisClient redisClient;

    @GetMapping("/test")
    public void testUser() {
        System.out.println("goods=-----");
    }

    @PostMapping(value = "/login")
    public ResponseResult<User> login(String qqNumber, String password, HttpServletResponse response) {


//        String qqNumber = map.get("qqNumber")+"";
//        String password = map.get("password")+"";
        System.out.println(qqNumber + "------"+  password);
        // 验证用户名密码
        User user = userService.getUserByQqNumber(qqNumber);
        if (user == null) {
            return new ResponseResult<User>(false, "没有该账户", null);
        }
        if (!user.getPassword().equalsIgnoreCase(password)) {
            return new ResponseResult<User>(false, "账户密码错误", null);
        }
        // 生成token
        String token = genToken();
        // 缓存用户 和 token, 用户再请求的时候，从缓存里面验证
        redisClient.set(token, user, 3600);
        List<User> users = new ArrayList<>();
        users.add(user);
        CookieUtil.addCookie(response, "token", token, COOKIE_EXPIRED );
        return new ResponseResult<>(true, token, users);
    }

    @PostMapping(value = "/register")
    public Response register(@RequestBody Map map) {

        String qqNumber = map.get("qqNumber") + "";
        String password = map.get("password") + "";
        User user = new User();
        user.setU_id(UUID.randomUUID() + "");
        user.setQqNumber(qqNumber);
        user.setPassword(password);
        int addResultNum = userService.addUser(user);
        if (addResultNum == 1) {
            return new Response(true, "register success");
        }
        return new Response(false, "register failed");
    }


    private String genToken() {
        return randomCode("0123456789abcdefghijklmnopqrstuvwxyz", 32);
    }

    private String randomCode(String s, int size) {
        StringBuilder result = new StringBuilder(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            // 每次取一个
            int loc = random.nextInt(s.length());
            result.append(s.charAt(loc));
        }
        return result.toString();
    }


    private String md5(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(password.getBytes("utf-8"));
            return HexUtils.toHexString(md5Bytes); // 转成16进制串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @ApiOperation("通过用户名查询")
    @GetMapping(value = "/{userName}")
    public User getUserByName(@PathVariable("userName") String userName) {
        System.out.println(userName);
        return userService.getUserByName(userName);
    }

    @ApiOperation("添加用户")
    @PostMapping(value = "/addUser")
    public ResponseResult<User> addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        List<User> users = new ArrayList<>();
        users.add(user);
        ResponseResult<User> responseResult
                = new ResponseResult<>(true, "插入结果为：" + result, users);
        return responseResult;
    }
}

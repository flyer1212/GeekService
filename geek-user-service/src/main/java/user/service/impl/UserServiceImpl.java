package user.service.impl;

import common.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;
import user.dto.AuthDto;
import user.dto.UserDto;
import user.entity.User;
import user.repository.UserRepository;
import user.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//     final String USER_AUTH_SERVICE = "http://localhost:18000/auth/auth";

    final String USER_AUTH_SERVICE = "http://geek-auth-service:18000/auth/auth";

    public Response saveUser(UserDto userDto) {
        log.info("Save User QQ id：" + userDto.getQqNumber());
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .sex(userDto.getSex())
                .major(userDto.getMajor())
                .idCard(userDto.getIdCard())
                .mobilePhone(userDto.getMobilePhone())
                .wechat(userDto.getWechat())
                .qqNumber(userDto.getQqNumber())
                .registerTime(userDto.getRegisterTime()).build();

        // avoid same user name   qq  is username
        User user1 = userRepository.findByUserName(userDto.getQqNumber());
        if (user1 == null) {
            User userSaveResult = userRepository.save(user);
            log.info("Send authorization message to ts-auth-service....");
            createDefaultAuthUser(AuthDto.builder().userId(user.getUserId())
                    .userName(user.getQqNumber())
                    .password(user.getPassword())
                    .build());
            return new Response(1, "REGISTER SUCCESS", userSaveResult);
        } else {
            return new Response(0, "USER ALREADY EXISTS", null);
        }
    }

    public Response getAllUsers() {
        return new Response(1, "SUCCESS", userRepository.findAll());
    }


    public Response findByUserName(String userName) {
        return new Response(1, "Success", userRepository.findByUserName(userName));
    }

    @Override
    public Response findByUserIdIn(List<String> userIds) {
        log.info("User Ids  size: " + userIds.size() + userIds.toString());
        List<User> userList = new ArrayList<>();

        for (String id : userIds) {

            User rtw = userRepository.findByUserId(id);
            User rtw1 = userRepository.findByUserId("4d2a46c7-71c4-4cf1-b5bb-b68406d9da6f");

            log.info(rtw + " __" + " _ " + rtw1);
            // 4d2a46c7-71c4-4cf1-b5bb-b68406d9da6f
            log.info("USER ID " + id);
            User users = userRepository.findByUserId(id);
            if (users != null)
                userList.add(users);
        }
        // List<User> userList = userIds.stream().map(id  ->  userRepository.findByUserId(id) ).collect(Collectors.toList());
//        List<User> users = userRepository.findByUserIdIn(userIds);
        log.info(userList.size() + " ___  " + userList.toString());
        return new Response(1, "Success", userList);
    }

    private void createDefaultAuthUser(AuthDto dto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthDto> httpEntity = new HttpEntity<AuthDto>(dto, httpHeaders);
        restTemplate.exchange(USER_AUTH_SERVICE,
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }
}
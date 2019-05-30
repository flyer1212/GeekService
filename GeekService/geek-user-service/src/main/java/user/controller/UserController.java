package user.controller;

import common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.dto.UserDto;
import user.entity.User;
import user.service.UserService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String testHello() {
        return "Hello";
    }

    @GetMapping
    public ResponseEntity<Response> getAllUser() {
        return ok(userService.getAllUsers());
    }

    @GetMapping("/{userName}")
    public ResponseEntity getUserByUserName(@PathVariable String userName) {
        return ok(userService.findByUserName(userName));
    }

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDto));
    }

    @PostMapping("/ids")
    public HttpEntity getFoodStoresByStationIds(@RequestBody List<String> userIds) {
        return ok(userService.findByUserIdIn(userIds));
    }
}

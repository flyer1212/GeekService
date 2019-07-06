package auth.controller;

import auth.dto.AuthDto;
import auth.dto.BasicAuthDto;
import auth.dto.TokenDto;
import auth.service.TokenService;
import auth.service.UserService;
import common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public Object getHello() {
        return "Hello";
    }

    @PostMapping("/login")
    public ResponseEntity<Response> getToken(@RequestBody BasicAuthDto dao) {
        return ResponseEntity.ok(tokenService.getToken(dao));
    }

    @GetMapping
    public ResponseEntity<Response> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    /**
     * only while  user register, this method will be called by ts-user-service
     * to create a default role user
     *
     * @param dto uuid id , username  password
     * @return
     */
    @PostMapping("/auth")
    public ResponseEntity<Void> createDefaultUser(@RequestBody AuthDto dto) {
        userService.createDefaultAuthUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}


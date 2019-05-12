package user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.dto.AuthDto;
import user.dto.UserDto;
import user.entity.User;
import user.repository.UserRepository;
import user.service.UserService;

import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(UserDto userDto) {
        log.info("Save User Name id：" + userDto.getUserName());
        User user = User.builder()
                .userId(UUID.randomUUID())
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .sex(userDto.getSex())
                .major(userDto.getMajor())
                .idCard(userDto.getIdCard())
                .mobilePhone(userDto.getMobilePhone())
                .wechat(userDto.getWechat())
                .qqNumber(userDto.getQqNumber())
                .registerTime(userDto.getRegisterTime()).build();

        // avoid same user name
        User user1 = userRepository.findByUserName(userDto.getUserName());
        if (user1 == null) {
            User userSaveResult = userRepository.save(user);
            log.info("Send authorization message to ts-auth-service....");
            createDefaultAuthUser(AuthDto.builder().userId(user.getUserId())
                    .userName(user.getUserName())
                    .password(user.getPassword()).build());
            return userSaveResult;
        } else {
            return null;
        }
    }

    private void createDefaultAuthUser(AuthDto dto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthDto> httpEntity = new HttpEntity<AuthDto>(dto, httpHeaders);
        restTemplate.exchange("http://localhost:18000/user/auth",
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


}

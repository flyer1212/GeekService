package user.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import user.entity.User;
import user.repository.UserRepository;
import user.service.UserService;


import java.util.Date;
import java.util.UUID;

@Component
public class InitUser implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        User whetherExistUser = userRepository.findByUserName("user");
        User user = User.builder()
                .userId("4d2a46c7-71c4-4cf1-b5bb-b68406d9da6f")
                .userName("user")
                .password("123456")
                .sex(1)
                .major("软件工程")
                .idCard("2135488099312X")
                .mobilePhone("12354665666")
                .wechat("wxcccxxxx")
                .qqNumber("309877323")
                .registerTime(new Date().toString()).build();
        if (whetherExistUser == null) {
            userRepository.save(user);
        }
    }
}

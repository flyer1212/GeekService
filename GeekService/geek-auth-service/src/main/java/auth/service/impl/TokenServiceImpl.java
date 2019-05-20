package auth.service.impl;

import auth.constant.InfoConstant;
import auth.dto.BasicAuthDto;
import auth.dto.TokenDto;
import auth.entity.User;
import auth.exception.UserOperationException;
import auth.repository.UserRepository;
import auth.security.jwt.JWTProvider;
import auth.service.TokenService;
import common.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public Response getToken(BasicAuthDto dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        log.info(username + "___" + password);
        // verify username and password
        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(upat);

        log.info("verify  success");
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserOperationException(MessageFormat.format(
                        InfoConstant.USER_NAME_NOT_FOUND_1, username
                )));
        log.info(user.toString());
        String token = jwtProvider.createToken(user);
        return new Response(1, "GET TOKEN SUCCESS", new TokenDto(user.getUserId() + "", username, token));
    }
}

package auth.service;

import auth.dto.AuthDto;
import auth.entity.User;
import common.util.Response;

import java.util.List;

public interface UserService {

    Response saveUser(User user);

    Response getAllUser();


    Response createDefaultAuthUser(AuthDto dto);

}

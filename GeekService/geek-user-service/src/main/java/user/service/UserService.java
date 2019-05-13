package user.service;

import common.util.Response;
import user.dto.UserDto;
import user.entity.User;

import java.util.List;


public interface UserService {
    Response saveUser(UserDto user);

    Response getAllUsers();

    Response findByUserName(String userName);
}

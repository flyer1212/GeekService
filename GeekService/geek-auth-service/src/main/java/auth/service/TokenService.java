package auth.service;

import auth.dto.BasicAuthDto;
import auth.dto.TokenDto;
import common.util.Response;

public interface TokenService {
    Response getToken(BasicAuthDto dto);
}

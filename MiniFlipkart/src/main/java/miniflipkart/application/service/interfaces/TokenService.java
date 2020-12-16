package miniflipkart.application.service.interfaces;

import miniflipkart.application.rdos.TokenRdo;

// TokenService interface provides funtionalities for token
public interface TokenService {

    boolean validateToken(String token);

    TokenRdo generateToken(String userName);

    void deleteToken(String token);
}

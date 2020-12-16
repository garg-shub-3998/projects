package miniflipkart.application.service.interfaces;

import miniflipkart.application.qdos.LoginQdo;
import miniflipkart.application.rdos.TokenRdo;

// LoginService interface provices functionalities for logini
public interface LoginService {

    boolean authenticateUser(LoginQdo loginBody);

    TokenRdo generateToken(String userName);
}

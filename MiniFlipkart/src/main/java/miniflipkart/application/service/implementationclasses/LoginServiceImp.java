package miniflipkart.application.service.implementationclasses;

import miniflipkart.application.qdos.LoginQdo;
import miniflipkart.application.rdos.TokenRdo;
import miniflipkart.application.service.interfaces.LoginService;
import miniflipkart.application.service.interfaces.TokenService;
import miniflipkart.application.validator.Validator;
import org.springframework.stereotype.Service;

/**
 * @author  Shubham Garg
 */
@Service
public class LoginServiceImp implements LoginService {

    // Validator object
    private Validator validator;

    // TokenService object
    private TokenService tokenService;

    @Override
    public boolean authenticateUser(LoginQdo loginBody) {
        // authentiacte the user credentials
        boolean ans = validator.validateLogin(loginBody.getUsername(), loginBody.getPassword());
        return ans;
    }

    @Override
    public TokenRdo generateToken(String userName) {
        // generate token
        TokenRdo tokenRdo = tokenService.generateToken(userName);
        return tokenRdo;
    }
}

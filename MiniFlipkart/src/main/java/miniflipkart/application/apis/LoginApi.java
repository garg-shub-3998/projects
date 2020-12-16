
package miniflipkart.application.apis;

import miniflipkart.application.rdos.TokenRdo;
import miniflipkart.application.service.interfaces.LoginService;
import miniflipkart.application.qdos.LoginQdo;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * Login Apis
 *
 * validateLogin -> authenticate user and generate token
 */
@RestController
@RequestMapping("/api")
public class LoginApi {

    // LoginService object
    private LoginService loginService;

    /**
     * authenticate the user
     */
    @PostMapping("/login")
    public TokenRdo validateLogin(@RequestBody LoginQdo loginBody, HttpServletResponse response) throws Exception {
        // Authenticate the user
        loginService.authenticateUser(loginBody);

        // Generate Token
        TokenRdo tokenRdo = loginService.generateToken(loginBody.getUsername());

        // set the response status
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        // return the token
        return tokenRdo;
    }

}

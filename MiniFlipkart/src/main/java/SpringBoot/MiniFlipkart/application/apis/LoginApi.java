
package SpringBoot.MiniFlipkart.application.apis;

import SpringBoot.MiniFlipkart.application.config.token.TokenRdo;
import SpringBoot.MiniFlipkart.application.config.token.service.TokenService;
import SpringBoot.MiniFlipkart.application.qdos.LoginQdo;
import SpringBoot.MiniFlipkart.application.service.UserService;
import SpringBoot.MiniFlipkart.application.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api")
public class LoginApi {

    // Validator object
    @Autowired
    private Validator validator;

    // UserService object
    @Autowired
    private UserService userService;

    // TokenService object
    @Autowired
    private TokenService tokenService;


    /**
     * authenticate the user
     */
    @PostMapping("/login")
    public TokenRdo validateLogin(@RequestBody LoginQdo lb) throws Exception {

        // authentiacte the user credentials
        boolean ans = validator.validateLogin(lb.getUsername(), lb.getPassword());
        if (ans) {
            // loging in if user authentication passed

            TokenRdo tokenRdo = tokenService.generateToken(lb.getUsername());

            return tokenRdo;

        } else {
            return new TokenRdo();
        }


    }

}

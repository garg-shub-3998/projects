
package miniflipkart.application.apis;


import miniflipkart.application.service.interfaces.SignupService;
import miniflipkart.application.qdos.SignupQdo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * Signup Apis
 *
 * signup -> registers a new user in database
 */
@RestController
@RequestMapping("/api")
public class SignupApi {

    // SignupService Object
    @Autowired
    private SignupService signupService;


    /**
     * Add new User into database
     */
    @PostMapping("/signup")
    public void signup(@RequestBody SignupQdo signupBody, HttpServletResponse response) {
        // register a new user in database
        signupService.registerUser(signupBody);

        // set the response status
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

}

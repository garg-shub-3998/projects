package miniflipkart.application.apis;

import miniflipkart.application.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Validator Apis
 *
 * validateUsername -> check is username is already present or not
 * validateEmail -> check if email is already present or not
 * validatePhonenumber -> check if phonenumber is already present or not
 *
 */
@RestController
@RequestMapping("/api/validate")
public class ValidatorApi {

    // Validator object
    @Autowired
    private Validator validator;


    /**
     * Validate username
     */
    @GetMapping("/username")
    public void validateUsername(@RequestParam String userName, HttpServletResponse response) {
        // validate username for availablity
        boolean ans = validator.validateUsername(userName);
        if(ans) {
            // set the response status
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else{
            // set the response status
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    /**
     * Validate email
     */
    @GetMapping("/email")
    public void validateEmail(@RequestParam String email, HttpServletResponse response) {
        // check the availability of eamil
        boolean ans = validator.validateEmail(email);
        if(ans) {
            // set the response status
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else{
            // set the response status
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    /**
     * Validate phonenumber
     */
    @GetMapping("/phonenumber")
    public void validatePhonenumber(@RequestParam String phoneNumber, HttpServletResponse response) {
        // check the availablity of phonenumber
        boolean ans = validator.validatePhonenumber(phoneNumber);
        if(ans) {
            // set the response status
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else{
            // set the response status
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}

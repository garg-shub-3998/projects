
package SpringBoot.MiniFlipkart.application.apis;

import SpringBoot.MiniFlipkart.model.entity.Address;
import SpringBoot.MiniFlipkart.model.entity.User;
import SpringBoot.MiniFlipkart.application.service.UserService;
import SpringBoot.MiniFlipkart.application.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SpringBoot.MiniFlipkart.application.qdos.SignupQdo;


/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api/signup")
public class SignupApi {

    // Validator object
    @Autowired
    private Validator validator;

    // UserService object
    @Autowired
    private UserService userService;


    /**
     * Add new User into database
     */
    @PostMapping("/register")
    public boolean register(@RequestBody SignupQdo sb) {

        User user = new User(sb.getFirstname(), sb.getLastname(), sb.getUsername(), sb.getAge()
                , sb.getPhonenumber(), sb.getEmail(), sb.getUsertype(), sb.getPassword(), sb.getGender());
        Address address = new Address(sb.getHousenumber(), sb.getLocality(), sb.getState()
                , sb.getCountry(), sb.getPincode());

        // save the new user
        userService.saveUser(user, address);

        return true;
    }

    /**
     * Validate username
     */
    @GetMapping("/validate/username")
    public boolean validateUsername(@RequestParam String username) {

        boolean ans = validator.validateUsername(username);

        return ans;
    }

    /**
     * Validate email
     */
    @GetMapping("/validate/email")
    public boolean validateEmail(@RequestParam String email) {

        boolean ans = validator.validateEmail(email);

        return ans;
    }

    /**
     * Validate phonenumber
     */
    @GetMapping("/validate/phonenumber")
    public boolean validatePhonenumber(@RequestParam String phonenumber) {

        boolean ans = validator.validatePhonenumber(phonenumber);

        return ans;
    }


}

package miniflipkart.application.service.implementationclasses;

import miniflipkart.application.entities.models.Address;
import miniflipkart.application.entities.models.User;
import miniflipkart.application.qdos.SignupQdo;
import miniflipkart.application.service.interfaces.SignupService;
import miniflipkart.application.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Shubham Garg
 */
@Service
public class SignupServiceImp implements SignupService {

    // UserService object
    @Autowired
    protected UserService userService;


    // registers a new user in databaes
    @Override
    public boolean registerUser(SignupQdo signupBody) {
        // Generate User object
        User user = new User(signupBody.getFirstname(), signupBody.getLastname(), signupBody.getUsername(),
                signupBody.getAge(), signupBody.getPhonenumber(), signupBody.getEmail(), signupBody.getUsertype(),
                signupBody.getPassword(), signupBody.getGender());

        // Generate Address object
        Address address = new Address(signupBody.getHousenumber(), signupBody.getLocality(),
                signupBody.getState(), signupBody.getCountry(), signupBody.getPincode());

        // save the new user
        userService.saveUser(user, address);

        return true;
    }
}

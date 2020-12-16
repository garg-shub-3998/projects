
package miniflipkart.application.validator;



import miniflipkart.application.entities.models.User;
import miniflipkart.application.entities.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Shubham Garg
 */
@Service
public class ValidatorImp implements Validator {

    // UserRepository object
    @Autowired
    private UserRepository userRepository;




    // authenticate the user
    @Override
    @Transactional
    public boolean validateLogin(String username, String password) {

        // extract user from database based on username and password
        User user = userRepository.getByUsernamePassword(username, password);
        if (user != null)
            return true;
        else
            return false;
    }

    // validate username for new user
    @Override
    @Transactional
    public boolean validateUsername(String username) {
        boolean ans = false;
        // extract user by username
        User user = userRepository.findByUsername(username);
        if (user == null)
            ans = true;
        return ans;
    }

    // validate email for user
    @Override
    @Transactional
    public boolean validateEmail(String email) {
        boolean ans = false;
        // extract user by email
        User user = userRepository.findByEmail(email);
        if (user == null)
            ans = true;
        return ans;
    }

    // validate phonenumber for user
    @Override
    @Transactional
    public boolean validatePhonenumber(String phonenumber) {
        boolean ans = false;
        // extract user by phonenumber
        User user = userRepository.findByPhoneNumber(phonenumber);
        if (user == null)
            ans = true;
        return ans;
    }




}

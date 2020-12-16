
package miniflipkart.application.validator;


// validator interface provides function for different validation
public interface Validator {

    boolean validateLogin(String username, String password);

    boolean validateUsername(String userName);

    boolean validateEmail(String email);

    boolean validatePhonenumber(String phoneNumber);

}

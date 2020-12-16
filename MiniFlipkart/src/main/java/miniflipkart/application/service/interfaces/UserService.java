

package miniflipkart.application.service.interfaces;


import miniflipkart.application.entities.models.Address;
import miniflipkart.application.entities.models.User;

// UserService interface provides funtions for user, Address , customerAddress , vendorAddrsss entity
public interface UserService {

    void saveUser(User user, Address address);

    User getUserByUsernamePassword(String userName, String password);

    User getUserById(int vendorid);

}

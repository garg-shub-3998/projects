

package SpringBoot.MiniFlipkart.application.service;


import SpringBoot.MiniFlipkart.model.entity.Address;
import SpringBoot.MiniFlipkart.model.entity.User;

// UserService interface provides funtions for user, Address , customerAddress , vendorAddrsss entity
public interface UserService {

    public void saveUser(User user, Address address);

    public User getUserByUsernamePassword(String username, String password);

    public User getUserById(int vendorid);

}

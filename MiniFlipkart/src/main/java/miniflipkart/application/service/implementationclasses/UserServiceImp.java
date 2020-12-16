
package miniflipkart.application.service.implementationclasses;




import miniflipkart.application.entities.repository.*;
import miniflipkart.application.service.interfaces.UserService;
import miniflipkart.application.entities.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Shubham Garg
 */
@Service
public class UserServiceImp implements UserService {

    // UserRepository object
    @Autowired
    private UserRepository userRepository;

    // AddressRepository object
    @Autowired
    private AddressRepository addressRepository;

    // CustomerAddressRepository object
    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    // VendorAddressRepository object
    @Autowired
    private VendorAddressRepository vendorAddressRepository;

    // CartRepository object
    @Autowired
    private CartRepository cartRepository;


    // save a new user
    @Override
    @Transactional
    public void saveUser(User user, Address address) {
        // save user
        userRepository.save(user);

        // Save address
        addressRepository.save(address);

        // saving user address relation
        if (user.getUserType().equals("customer")) {
            CustomerAddress customerAddress = new CustomerAddress(user, address);
            customerAddressRepository.save(customerAddress);

            // generate a new cart if user is a customer
            Cart cart = new Cart(0, 0, user);
            cartRepository.save(cart);
        } else {
            VendorAddress vendorAddress = new VendorAddress(user, address);
            vendorAddressRepository.save(vendorAddress);
        }
    }

    // returs the user
    @Override
    @Transactional
    public User getUserByUsernamePassword(String userName, String password) {

        // extract user from database
        User user = userRepository.getByUsernamePassword(userName, password);

        return user;
    }


    // return user by id
    @Override
    @Transactional
    public User getUserById(int userid) {
        // extract user by id
        return userRepository.getOne(userid);
    }

}


package SpringBoot.MiniFlipkart.application.service;

import SpringBoot.MiniFlipkart.model.entity.*;
import SpringBoot.MiniFlipkart.model.repository.*;

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
            CustomerAddress ca = new CustomerAddress(user, address);
            customerAddressRepository.save(ca);
            Cart c = new Cart(0, 0, user);
            cartRepository.save(c);
        } else {
            VendorAddress va = new VendorAddress(user, address);
            vendorAddressRepository.save(va);
        }
    }

    // returs the user
    @Override
    @Transactional
    public User getUserByUsernamePassword(String username, String password) {

        String type = "customer";

        // extract user from database
        User user = userRepository.getByUsernamePassword(username, password);

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


package SpringBoot.MiniFlipkart.application.validator;

import java.util.List;

import SpringBoot.MiniFlipkart.model.entity.*;
import SpringBoot.MiniFlipkart.model.repository.*;

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

    // BrandRepository object
    @Autowired
    private BrandRepository brandRepository;

    // ProductRepository object
    @Autowired
    private ProductRepository productRepository;

    // CartRepository object
    @Autowired
    private CartRepository cartRepository;

    // CartRepository object
    @Autowired
    private CartItemsRepository cartItemsRepository;

    // OrderRepository object
    @Autowired
    private OrderRepository orderRepository;

    // CartRepository object
    @Autowired
    private OrderItemsRepository orderItemsRepository;


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
        User user = userRepository.findByPhoneNumber(phonenumber);
        if (user == null)
            ans = true;
        return ans;
    }

    // check brand exist or not
    @Override
    @Transactional
    public boolean validateBrand(String brand) {
        boolean ans = true;

        // extract list of brands from database
        List<Brand> b = brandRepository.findAll();

        // conpares name of brands
        for (int i = 0; i < b.size(); i++) {
            if (brand.toLowerCase().equals(b.get(i).getName().toLowerCase())) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    // check product exist or not
    @Override
    @Transactional
    public boolean validateProduct(Product product, int vendorid) {

        boolean ans = true;

        // extract list of products from database
        List<Product> p = productRepository.getByVendorId(vendorid);

        // conpares name of products
        for (int i = 0; i < p.size(); i++) {
            if (product.getName().toLowerCase().equals(p.get(i).getName().toLowerCase())) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    // validate product for deletion
    @Override
    @Transactional
    public boolean validateProductDelete(int productid) {
        List<CartItems> ci = cartItemsRepository.getCartItemByProductId(productid);
        List<OrderItems> o = orderItemsRepository.getOrderItemByProductId(productid);
        if (ci.size() == 0 && o.size() == 0)
            return true;
        else
            return false;
    }

    // validate brand for deletion
    @Override
    @Transactional
    public boolean validateBrandDelete(int brandid) {
        List<Product> p = productRepository.getProductByBrandId(brandid);
        if (p.size() == 0)
            return true;
        else
            return false;
    }

}

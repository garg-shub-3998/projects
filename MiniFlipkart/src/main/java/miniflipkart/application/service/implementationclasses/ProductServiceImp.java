
package miniflipkart.application.service.implementationclasses;

import java.util.ArrayList;
import java.util.List;

import miniflipkart.application.entities.repository.CartItemsRepository;
import miniflipkart.application.entities.repository.OrderItemsRepository;
import miniflipkart.application.qdos.NewProductQdo;
import miniflipkart.application.rdos.ProductRdo;
import miniflipkart.application.entities.repository.ProductRepository;
import miniflipkart.application.service.interfaces.BrandService;
import miniflipkart.application.service.interfaces.ProductService;
import miniflipkart.application.service.interfaces.UserService;
import miniflipkart.application.entities.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Shubham Garg
 */
@Service
public class ProductServiceImp implements ProductService {

    // ProductRepository object
    @Autowired
    private ProductRepository productRepository;

    // CartItemsRepository object
    @Autowired
    private CartItemsRepository cartItemsRepository;

    // OrderItemsRepository object
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    // UserService Object
    @Autowired
    private UserService userService;

    // BrandService Object
    @Autowired
    private BrandService brandService;


    @Override
    @Transactional
    public Product generateProduct(NewProductQdo newProductBody) {
        // get the user/vendor object
        User user = userService.getUserById(newProductBody.getVendorid());

        // get the brand object
        Brand brand = brandService.getBrand(newProductBody.getBrandid());

        // generate the product object
        Product product = new Product(newProductBody.getProductName(), newProductBody.getPrice(), brand, user);

        // return the product object
        return product;
    }

    // list of products by vendorid
    @Override
    @Transactional
    public List<ProductRdo> getProducts(int vendorid) {
        // return list of product by each vendor
        List<Product> products = productRepository.getByVendorId(vendorid);

        // generate ProductRdo list from products
        List<ProductRdo> productRdos = new ArrayList<ProductRdo>();
        for (Product p : products) {
            ProductRdo productRdo = new ProductRdo();
            productRdo.setId(p.getId());
            productRdo.setName(p.getName());
            productRdo.setPrice(p.getPrice());
            productRdo.setVendorid(p.getUser().getId());
            productRdo.setBrandName(p.getBrand().getName());
            productRdos.add(productRdo);
        }

        // return productRdos object
        return productRdos;
    }

    // save new product
    @Override
    @Transactional
    public void save(Product product) {
        // save a product
        productRepository.save(product);
    }

    // delete product by id
    @Override
    @Transactional
    public void delete(int id) {
        // delete product by id
        productRepository.deleteById(id);
    }

    // get the list of all available products
    @Override
    @Transactional
    public List<ProductRdo> getProducts() {
        // return list of all available products
        List<Product> products = productRepository.findAll();

        // generate ProductRdo list from products
        List<ProductRdo> productRdos = new ArrayList<ProductRdo>();
        for (Product p : products) {
            ProductRdo productRdo = new ProductRdo();
            productRdo.setId(p.getId());
            productRdo.setName(p.getName());
            productRdo.setPrice(p.getPrice());
            productRdo.setVendorid(p.getUser().getId());
            productRdo.setBrandName(p.getBrand().getName());
            productRdos.add(productRdo);
        }

        // return the productRdo list
        return productRdos;
    }

    // validate brand for deletion
    @Override
    @Transactional
    public boolean validateBrandDelete(int brandid) {
        List<Product> products = productRepository.getProductByBrandId(brandid);
        if (products.size() == 0)
            return true;
        else
            return false;
    }

    // check product exist or not
    @Override
    @Transactional
    public boolean validateProduct(Product product, int vendorid) {
        boolean ans = true;

        // extract list of products from database
        List<Product> products = productRepository.getByVendorId(vendorid);

        // conpares name of products
        for (int i = 0; i < products.size(); i++) {
            if (product.getName().toLowerCase().equals(products.get(i).getName().toLowerCase())) {
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
        List<CartItems> cartItems = cartItemsRepository.getCartItemByProductId(productid);
        List<OrderItems> orderItems = orderItemsRepository.getOrderItemByProductId(productid);
        if (cartItems.size() == 0 && orderItems.size() == 0)
            return true;
        else
            return false;
    }

}

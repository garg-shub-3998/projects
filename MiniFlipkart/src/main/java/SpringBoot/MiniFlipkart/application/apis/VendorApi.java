
package SpringBoot.MiniFlipkart.application.apis;

import java.util.List;

import SpringBoot.MiniFlipkart.application.qdos.NewProductQdo;
import SpringBoot.MiniFlipkart.application.rdos.ProductRdo;
import SpringBoot.MiniFlipkart.model.entity.Brand;
import SpringBoot.MiniFlipkart.model.entity.Product;
import SpringBoot.MiniFlipkart.model.entity.User;
import SpringBoot.MiniFlipkart.application.service.BrandService;
import SpringBoot.MiniFlipkart.application.service.ProductService;
import SpringBoot.MiniFlipkart.application.service.UserService;
import SpringBoot.MiniFlipkart.application.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api/vendor")
public class VendorApi {
    // UserService object
    @Autowired
    private UserService userService;

    // BrandService object
    @Autowired
    private BrandService brandService;

    // Validator object
    @Autowired
    private Validator validator;

    // Product Service object
    @Autowired
    private ProductService productService;

    /**
     * Display the list of products of particular vendor
     */
    @GetMapping("/getProducts")
    public List<ProductRdo> getProducts(@RequestParam int vendorid) {

        // extract list of products
        List<ProductRdo> products = productService.getProducts(vendorid);

        return products;

    }


    /**
     * Adds a new product in to databse
     */
    @PostMapping("addProduct")
    public boolean addProduct(@RequestBody NewProductQdo npb) {
        // generating the user/vendor object
        User user = userService.getUserById(npb.getVendorid());
        // generate the brand object
        Brand brand = brandService.getBrand(npb.getBrandid());
        Product product = new Product(npb.getProductName(), npb.getPrice(), brand, user);


        // validating the new product
        boolean ans = validator.validateProduct(product, npb.getVendorid());
        if (ans) {
            // save new product
            productService.save(product);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Delete product
     */
    @DeleteMapping("/deleteProduct")
    public boolean deleteProduct(@RequestParam int id) {

        if (validator.validateProductDelete(id)) {
            productService.delete(id);
            return true;
        } else {
            return false;
        }
    }

}


package SpringBoot.MiniFlipkart.application.apis;

import java.util.List;


import SpringBoot.MiniFlipkart.application.rdos.ProductRdo;
import SpringBoot.MiniFlipkart.model.entity.Product;
import SpringBoot.MiniFlipkart.application.service.CartService;
import SpringBoot.MiniFlipkart.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerApi {

    // ProductService Object
    @Autowired
    private ProductService productService;

    // CartService Object
    @Autowired
    private CartService cartService;

    /**
     * display list of products
     */
    @GetMapping("/showProducts")
    public List<ProductRdo> showProducts() {
        // Extract list of products from database
        List<ProductRdo> products = productService.getProducts();

        return products;
    }


}

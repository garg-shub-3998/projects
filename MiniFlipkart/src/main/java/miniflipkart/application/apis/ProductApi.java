
package miniflipkart.application.apis;

import java.util.List;

import miniflipkart.application.qdos.NewProductQdo;
import miniflipkart.application.rdos.ProductRdo;
import miniflipkart.application.entities.models.Product;
import miniflipkart.application.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * Product Apis
 *
 * getProducts -> returs list of products by a particular vendor
 * showProducts -> return List of all available products
 * addProduct -> adds a new Product
 * deleteProduct -> delete product
 */
@RestController
@RequestMapping("/api")
public class ProductApi {

    // Product Service object
    @Autowired
    private ProductService productService;

    /**
     * Display the list of products of particular vendor
     */
    @GetMapping("/products/{vendorid}")
    public List<ProductRdo> getProducts(@PathVariable int vendorid, HttpServletResponse response) {
        // extract list of products
        List<ProductRdo> productRdos = productService.getProducts(vendorid);

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return the list of products
        return productRdos;
    }

    /**
     * display list of products
     */
    @GetMapping("/products")
    public List<ProductRdo> showProducts(HttpServletResponse response) {
        // Extract list of products from database
        List<ProductRdo> productRdos = productService.getProducts();

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return the list of products
        return productRdos;
    }


    /**
     * Adds a new product in to databse
     */
    @PostMapping("/products")
    public void addProduct(@RequestBody NewProductQdo newProductBody, HttpServletResponse response) {

        // generate Product
        Product product = productService.generateProduct(newProductBody);

        // validating the new product
        boolean ans = productService.validateProduct(product, newProductBody.getVendorid());
        if (ans) {
            // save new product
            productService.save(product);

            // set the response status
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            // set the response status
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }

    }

    /**
     * Delete product
     */
    @DeleteMapping("/products")
    public void deleteProduct(@RequestParam int productid, HttpServletResponse response) {
        // validate products for refrential interigity in orderitems and cartitems
        if (productService.validateProductDelete(productid)) {
            // delete product
            productService.delete(productid);

            // set the response status
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // set the response status
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

}

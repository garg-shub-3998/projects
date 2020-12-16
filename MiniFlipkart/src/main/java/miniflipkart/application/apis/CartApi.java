
package miniflipkart.application.apis;

import java.util.List;

import miniflipkart.application.qdos.CartQdo;
import miniflipkart.application.qdos.CheckoutQdo;
import miniflipkart.application.rdos.CartItemsRdo;
import miniflipkart.application.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * Brand Apis
 *
 * showCart -> return the list of items in the customer cart
 * addToCart -> add a new product to the cart
 * deleteCartItem -> remove a product from cart
 * UpdateCartItem -> update the quantity of product in cart
 * getCartCount -> return the count of different products
 * checkout -> performs checkout
 */
@RestController
@RequestMapping("/api")
public class CartApi {

    // CartService object
    @Autowired
    private CartService cartService;

    /**
     * return the list of products into cart
     */
    @GetMapping("/cart/{customerid}")
    public List<CartItemsRdo> showCart(@PathVariable int customerid, HttpServletResponse response) {
        // extract list of cart items
        List<CartItemsRdo> cartItems = cartService.getCartItems(customerid);

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return the list of cart items
        return cartItems;
    }

    /**
     * add a new product to the cart
     */
    @PostMapping("/cart")
    public void addToCart(@RequestBody CartQdo cartBody, HttpServletResponse response) {
        // add a new product
        cartService.addNewProduct(cartBody.getProductid(),cartBody.getCustomerid());

        // set the response status
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    /**
     * remove product from cart
     */
    @DeleteMapping("/cart/{itemid}")
    public void deleteCartItem(@PathVariable int itemid, HttpServletResponse response) {
        // remove the product
        cartService.deleteItem(itemid);

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);
    }

    /**
     * update the quantity of product
     */
    @PutMapping("/cart/{itemid}")
    public void UpdateCartItem(@RequestParam int sign, @PathVariable int itemid, HttpServletResponse response) {
        // check if quantity needs to be increased by 1 or decreased by 1
        if(sign == 1) {
            // quatity increased
            cartService.addToItem(itemid);

            // set response status
            response.setStatus(HttpServletResponse.SC_OK);
        } else if(sign == -1) {
            // quantity decreased
            cartService.deleteFromItem(itemid);

            // set respose status
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    /**
     * return the count of different products
     */
    @GetMapping("/getcount/{customerid}")
    public int getCartCount(@PathVariable int customerid, HttpServletResponse response) {
        // get cart count
        int cartcount = cartService.getCartCount(customerid);

        // set response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return cartcount
        return cartcount;
    }

    /**
     * performs checkout
     */
    @PostMapping("/checkout")
    public void checkout(@RequestBody CheckoutQdo checkoutBody, HttpServletResponse response) {
        // perform checkout and save order
        cartService.saveOrder(checkoutBody.getPtype(), checkoutBody.getCustomerid());

        // set the response status
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

}

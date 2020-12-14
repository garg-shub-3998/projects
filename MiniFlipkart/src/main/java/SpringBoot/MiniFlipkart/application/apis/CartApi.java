
package SpringBoot.MiniFlipkart.application.apis;

import java.util.List;

import SpringBoot.MiniFlipkart.application.qdos.CheckoutQdo;
import SpringBoot.MiniFlipkart.application.rdos.CartItemsRdo;
import SpringBoot.MiniFlipkart.application.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api/cart")
public class CartApi {

    // CartService object
    @Autowired
    private CartService cartService;

    @GetMapping("/showCart")
    public List<CartItemsRdo> showCart(@RequestParam int customerid) {
        // extract list of cart items
        List<CartItemsRdo> items = cartService.getCartItems(customerid);
        return items;
    }

    @PutMapping("/addToCart")
    public boolean addToCart(@RequestParam int productid, @RequestParam int customerid) {
        cartService.addNewProduct(productid, customerid);
        return true;
    }

    @PutMapping("/deleteCartItem")
    public boolean deleteCartItem(@RequestParam int itemid) {
        cartService.deleteItem(itemid);
        return true;
    }

    @PutMapping("/deleteFromCartItem")
    public boolean deleteFromCartItem(@RequestParam int itemid) {
        cartService.deleteFromItem(itemid);
        return true;
    }

    @PutMapping("/addToCartItem")
    public boolean addToCartItem(@RequestParam int itemid) {
        cartService.addToItem(itemid);
        return true;
    }

    @GetMapping("/getCartCount")
    public int getCartCount(@RequestParam int customerid) {
        int cartcount = cartService.getCartCount(customerid);

        return cartcount;
    }

    @PostMapping("/performCheckout")
    public boolean checkout(@RequestBody CheckoutQdo cb) {

        cartService.saveOrder(cb.getPtype(), cb.getCustomerid());
        return true;
    }

}

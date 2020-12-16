
package miniflipkart.application.service.interfaces;

import miniflipkart.application.rdos.CartItemsRdo;

import java.util.List;


// CartService interface provides all funtionalites of Cart and CartItems entity
public interface CartService {

    int getCartCount(int customerid);

    void addNewProduct(int productid, int customerid);

    List<CartItemsRdo> getCartItems(int customerid);

    void deleteItem(int itemid);

    void deleteFromItem(int itemid);

    void addToItem(int itemid);

    void saveOrder(String paymentType, int customerid);


}

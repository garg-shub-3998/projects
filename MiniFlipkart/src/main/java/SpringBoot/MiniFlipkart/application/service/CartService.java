
package SpringBoot.MiniFlipkart.application.service;

import SpringBoot.MiniFlipkart.application.rdos.CartItemsRdo;
import SpringBoot.MiniFlipkart.model.entity.CartItems;

import java.util.List;


// CartService interface provides all funtionalites of Cart and CartItems entity
public interface CartService {

    public int getCartCount(int customerid);

    public void addNewProduct(int productid, int customerid);

    public List<CartItemsRdo> getCartItems(int customerid);

    public void deleteItem(int id);

    public void deleteFromItem(int id);

    public void addToItem(int id);

    public void saveOrder(String ptype, int customerid);


}

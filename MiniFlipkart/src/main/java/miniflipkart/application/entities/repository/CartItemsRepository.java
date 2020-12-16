package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {

    // Find the CartItems that contains the particular product in a specific Cart
    @Query(value = "SELECT ci FROM CartItems ci WHERE ci.cart.id = :cartid and ci.product.id = :productid")
    CartItems findByCartProductId(@Param("cartid") int cartid, @Param("productid") int productid);

    // Find the List of CartItems in a particular Cart
    @Query(value = "SELECT ci FROM CartItems ci WHERE ci.cart.id = :cartid")
    List<CartItems> findByCartId(@Param("cartid") int cartid);

    // Find the List of CartItems that contains a particular product
    @Query(value = "SELECT ci FROM CartItems ci WHERE ci.product.id = :productid")
    public List<CartItems> getCartItemByProductId(@Param("productid") int productid);
}

package SpringBoot.MiniFlipkart.model.repository;

import SpringBoot.MiniFlipkart.model.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {

    @Query(value = "SELECT ci FROM CartItems ci WHERE ci.cart.id = :cartid and ci.product.id = :productid")
    CartItems findByCartProductId(@Param("cartid") int cartid, @Param("productid") int productid);

    @Query(value = "SELECT ci FROM CartItems ci WHERE ci.cart.id = :cartid")
    List<CartItems> findByCartId(@Param("cartid") int cartid);

    @Query(value = "SELECT ci FROM CartItems ci WHERE ci.product.id = :id")
    public List<CartItems> getCartItemByProductId(@Param("id") int productid);
}

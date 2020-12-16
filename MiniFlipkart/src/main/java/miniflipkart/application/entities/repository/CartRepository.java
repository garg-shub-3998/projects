package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    // Find the Cart of the customer
    @Query(value = "SELECT c FROM Cart c WHERE c.user.id = :customerid")
    public Cart findByCustomerId(@Param("customerid") int customerid);

}

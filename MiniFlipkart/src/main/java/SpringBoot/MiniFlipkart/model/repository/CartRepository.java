package SpringBoot.MiniFlipkart.model.repository;

import SpringBoot.MiniFlipkart.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT c FROM Cart c WHERE c.user.id = :id")
    public Cart findByCustomerId(@Param("id") int id);

}

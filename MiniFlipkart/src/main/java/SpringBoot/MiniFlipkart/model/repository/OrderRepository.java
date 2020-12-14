package SpringBoot.MiniFlipkart.model.repository;

import SpringBoot.MiniFlipkart.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o FROM Order o WHERE o.user.id = :id")
    public List<Order> findByCustomerId(@Param("id") int customerid);


}

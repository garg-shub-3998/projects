package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find the List the Orders from a customer
    @Query(value = "SELECT o FROM Order o WHERE o.user.id = :customerid")
    public List<Order> findByCustomerId(@Param("customerid") int customerid);


}

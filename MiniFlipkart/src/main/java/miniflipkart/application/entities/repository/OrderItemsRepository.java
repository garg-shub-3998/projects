package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

    // Find the List of OrderItems in particular Order
    @Query(value = "SELECT oi FROM OrderItems oi WHERE oi.order.id = :orderid")
    public List<OrderItems> getByOrderId(@Param("orderid") int orderid);

    // Find the List of OrderItems that contains a particular product
    @Query(value = "SELECT oi FROM OrderItems oi WHERE oi.product.id = :productid")
    public List<OrderItems> getOrderItemByProductId(@Param("productid") int productid);
}

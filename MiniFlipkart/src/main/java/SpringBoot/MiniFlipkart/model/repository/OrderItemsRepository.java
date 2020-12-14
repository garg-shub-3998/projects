package SpringBoot.MiniFlipkart.model.repository;

import SpringBoot.MiniFlipkart.model.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

    @Query(value = "SELECT oi FROM OrderItems oi WHERE oi.order.id = :id")
    public List<OrderItems> getByOrderId(@Param("id") int orderid);

    @Query(value = "SELECT oi FROM OrderItems oi WHERE oi.product.id = :pid")
    public List<OrderItems> getOrderItemByProductId(@Param("pid") int productid);
}

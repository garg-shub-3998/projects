
package SpringBoot.MiniFlipkart.application.service;

import SpringBoot.MiniFlipkart.application.rdos.OrderItemsRdo;
import SpringBoot.MiniFlipkart.application.rdos.OrderRdo;
import SpringBoot.MiniFlipkart.model.entity.OrderItems;

import java.util.List;


// orderservice interface providing funtions of order and orderitems entity
public interface OrderService {


    List<OrderRdo> getOrders(int customerid);


    List<OrderItemsRdo> getOrderItems(int id);

}

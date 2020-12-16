
package miniflipkart.application.service.interfaces;

import miniflipkart.application.rdos.OrderItemsRdo;
import miniflipkart.application.rdos.OrderRdo;

import java.util.List;


// orderservice interface providing funtions of order and orderitems entity
public interface OrderService {


    List<OrderRdo> getOrders(int customerid);


    List<OrderItemsRdo> getOrderItems(int orderid);

}

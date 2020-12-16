
package miniflipkart.application.service.implementationclasses;

import java.util.ArrayList;
import java.util.List;

import miniflipkart.application.rdos.OrderItemsRdo;
import miniflipkart.application.rdos.OrderRdo;
import miniflipkart.application.entities.models.Order;
import miniflipkart.application.entities.models.OrderItems;
import miniflipkart.application.entities.repository.OrderItemsRepository;
import miniflipkart.application.entities.repository.OrderRepository;
import miniflipkart.application.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Shubham Garg
 */
@Service
public class OrderServiceImp implements OrderService {

    // OrderRepository object
    @Autowired
    private OrderRepository orderRepository;

    // OrderItemsRepository object
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    // return list of orders by customer
    @Override
    @Transactional
    public List<OrderRdo> getOrders(int customerid) {
        // get the list of orders of a customer
        List<Order> orders = orderRepository.findByCustomerId(customerid);

        // generate orderRdos obejct from list of orders
        List<OrderRdo> orderRdos = new ArrayList<OrderRdo>();
        for (Order o : orders) {
            OrderRdo orderRdo = new OrderRdo();
            orderRdo.setId(o.getId());
            orderRdo.setAmount(o.getAmount());
            orderRdo.setPtype(o.getPaymentType());
            orderRdos.add(orderRdo);
        }

        // return orderRdos
        return orderRdos;
    }

    // return list of order items
    @Override
    @Transactional
    public List<OrderItemsRdo> getOrderItems(int orderid) {
        // get list of OrderItems of a particular order
        List<OrderItems> ordersItems = orderItemsRepository.getByOrderId(orderid);

        // generate list of OrderItemsRdo from orderitems
        List<OrderItemsRdo> orderItemsRdos = new ArrayList<OrderItemsRdo>();
        for (OrderItems oi : ordersItems) {
            OrderItemsRdo orderItemsRdo = new OrderItemsRdo();
            orderItemsRdo.setId(oi.getId());
            orderItemsRdo.setProductname(oi.getProduct().getName());
            orderItemsRdo.setQuantity(oi.getQuantity());
            orderItemsRdo.setUnitprice(oi.getUnitPrice());
            orderItemsRdo.setTotalprice(oi.getTotalPrice());
            orderItemsRdos.add(orderItemsRdo);
        }

        // return orderItemsRdos object
        return orderItemsRdos;
    }

}


package SpringBoot.MiniFlipkart.application.service;

import java.util.ArrayList;
import java.util.List;

import SpringBoot.MiniFlipkart.application.rdos.OrderItemsRdo;
import SpringBoot.MiniFlipkart.application.rdos.OrderRdo;
import SpringBoot.MiniFlipkart.model.entity.Order;
import SpringBoot.MiniFlipkart.model.entity.OrderItems;
import SpringBoot.MiniFlipkart.model.repository.OrderItemsRepository;
import SpringBoot.MiniFlipkart.model.repository.OrderRepository;
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
        List<Order> orders = orderRepository.findByCustomerId(customerid);
        List<OrderRdo> orderRdos = new ArrayList<OrderRdo>();
        for (Order o : orders) {
            OrderRdo or = new OrderRdo();
            or.setId(o.getId());
            or.setAmount(o.getAmount());
            or.setPtype(o.getPaymentType());
            orderRdos.add(or);
        }
        return orderRdos;
    }

    // return list of order items
    @Override
    @Transactional
    public List<OrderItemsRdo> getOrderItems(int orderid) {
        List<OrderItems> ordersItems = orderItemsRepository.getByOrderId(orderid);
        List<OrderItemsRdo> orderItemsRdos = new ArrayList<OrderItemsRdo>();
        for (OrderItems oi : ordersItems) {
            OrderItemsRdo or = new OrderItemsRdo();
            or.setId(oi.getId());
            or.setProductname(oi.getProduct().getName());
            or.setQuantity(oi.getQuantity());
            or.setUnitprice(oi.getUnitPrice());
            or.setTotalprice(oi.getTotalPrice());
            orderItemsRdos.add(or);
        }
        return orderItemsRdos;
    }

}

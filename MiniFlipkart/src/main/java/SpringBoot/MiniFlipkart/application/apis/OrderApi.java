
package SpringBoot.MiniFlipkart.application.apis;

import java.util.List;

import SpringBoot.MiniFlipkart.application.rdos.OrderItemsRdo;
import SpringBoot.MiniFlipkart.application.rdos.OrderRdo;
import SpringBoot.MiniFlipkart.model.entity.Order;
import SpringBoot.MiniFlipkart.model.entity.OrderItems;
import SpringBoot.MiniFlipkart.application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api/order")
public class OrderApi {

    // OrderService object
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public List<OrderRdo> orderList(@RequestParam int customerid) {
        // get order
        List<OrderRdo> orders = orderService.getOrders(customerid);

        return orders;
    }

    @GetMapping("/orderItems")
    public List<OrderItemsRdo> orderItems(@RequestParam int orderid) {

        // get order items
        List<OrderItemsRdo> oi = orderService.getOrderItems(orderid);

        return oi;
    }
}

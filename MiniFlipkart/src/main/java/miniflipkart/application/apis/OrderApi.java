
package miniflipkart.application.apis;

import java.util.List;

import miniflipkart.application.rdos.OrderItemsRdo;
import miniflipkart.application.rdos.OrderRdo;
import miniflipkart.application.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Order Apis
 *
 * orderList -> returns the list of order made by a customer
 * orderItems -> return the list of products in each order
 */
@RestController
@RequestMapping("/api")
public class OrderApi {

    // OrderService object
    @Autowired
    private OrderService orderService;

    /**
     * return the list of order made by customer
     */
    @GetMapping("/orders/{customerid}")
    public List<OrderRdo> orderList(@PathVariable int customerid, HttpServletResponse response) {
        // get order
        List<OrderRdo> orderRdos = orderService.getOrders(customerid);

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return the list of orders
        return orderRdos;
    }

    /**
     * return the list of products in each order
     */
    @GetMapping("/orderitems/{orderid}")
    public List<OrderItemsRdo> orderItems(@PathVariable int orderid, HttpServletResponse response) {
        // get order items
        List<OrderItemsRdo> orderItemsRdo = orderService.getOrderItems(orderid);

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return the list of products
        return orderItemsRdo;
    }
}

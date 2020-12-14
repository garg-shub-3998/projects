
package SpringBoot.MiniFlipkart.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "orderitems")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderid")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitprice")
    private int unitPrice;

    @Column(name = "totalprice")
    private int totalPrice;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;


    // No Argument Constructor
    public OrderItems() {

    }

    // Parameterized Constructor
    public OrderItems(Order order, Product product, int quantity, int unitPrice, int totalPrice) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the order object
    public Order getOrder() {
        return order;
    }

    // return the product object
    public Product getProduct() {
        return product;
    }

    // return the quantity
    public int getQuantity() {
        return quantity;
    }

    // return the unitPrice
    public int getUnitPrice() {
        return unitPrice;
    }

    // return the totalPrice
    public int getTotalPrice() {
        return totalPrice;
    }

    // return the createdAt timestamp
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }


    // set the id
    public void setId(int id) {
        this.id = id;
    }

    // set the order object
    public void setOrder(Order order) {
        this.order = order;
    }

    // set the product object
    public void setProduct(Product product) {
        this.product = product;
    }

    // set the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // set the unitPrice
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    // set the totalPrice
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // set the createdAt timestamp
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    // print the orderitems object to console
    @Override
    public String toString() {
        return String.format(
                "OrderItems [id=%s, order=%s, product=%s, quantity=%s, unitPrice=%s, totalPrice=%s, createdAt=%s]", id,
                order, product, quantity, unitPrice, totalPrice, createdAt);
    }

}

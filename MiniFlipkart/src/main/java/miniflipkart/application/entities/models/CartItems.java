
package miniflipkart.application.entities.models;

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
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "cartitems")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartid")
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid")
    private Product product;

    @Column(name = "unitprice")
    private int unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "totalprice")
    private int totalPrice;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedat")
    private java.sql.Timestamp updateddAt;


    // No Argument Constructor
    public CartItems() {

    }

    //Parameterized Constructor
    public CartItems(Cart cart, Product product, int unitPrice, int quantity, int totalPrice) {
        this.cart = cart;
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the cart object
    public Cart getCart() {
        return cart;
    }

    // return the products object
    public Product getProduct() {
        return product;
    }

    // return the unitPrice
    public int getUnitPrice() {
        return unitPrice;
    }

    // return the quantity
    public int getQuantity() {
        return quantity;
    }

    // return the totalPrice
    public int getTotalPrice() {
        return totalPrice;
    }

    // return the createdAt timestamp
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    // return the updatedAt timestamp
    public java.sql.Timestamp getUpdateddAt() {
        return updateddAt;
    }


    // set the id
    public void setId(int id) {
        this.id = id;
    }

    // set the cart object
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // set the product object
    public void setProduct(Product product) {
        this.product = product;
    }

    // set the unitPrice
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    // set the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // set the totalPrice
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // set the createdAt timestamp
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // set the updatedAt timestamp
    public void setUpdateddAt(java.sql.Timestamp updateddAt) {
        this.updateddAt = updateddAt;
    }


    // print the object on console
    @Override
    public String toString() {
        return String.format(
                "CartItems [id=%s, cart=%s, product=%s, unitPrice=%s, quantity=%s, totalPrice=%s, createdAt=%s, updateddAt=%s]",
                id, cart, product, unitPrice, quantity, totalPrice, createdAt, updateddAt);
    }

}

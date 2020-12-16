
package miniflipkart.application.entities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private User user;

    @Column(name = "amount")
    private int amount;

    @Column(name = "paymenttype")
    private String paymentType;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;


    // No Argument Constructor
    public Order() {

    }

    // Parameterized Constructor
    public Order(User user, int amount, String paymentType) {
        this.user = user;
        this.amount = amount;
        this.paymentType = paymentType;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the user object( customer )
    public User getUser() {
        return user;
    }

    // return the amount
    public int getAmount() {
        return amount;
    }

    // return the createdAt timestamp
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    // return the paymentType
    public String getPaymentType() {
        return paymentType;
    }


    // set the id
    public void setId(int id) {
        this.id = id;
    }

    // set the user object( customer )
    public void setUser(User user) {
        this.user = user;
    }

    // set the amount
    public void setAmount(int amount) {
        this.amount = amount;
    }

    // set the createdAt timestamp
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // set the paymentType
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }


    // print the order object on console
    @Override
    public String toString() {
        return String.format("Order [id=%s, user=%s, amount=%s, paymentType=%s, createdAt=%s]", id, user, amount,
                paymentType, createdAt);
    }

}

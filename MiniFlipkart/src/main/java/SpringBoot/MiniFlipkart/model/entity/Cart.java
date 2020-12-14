
package SpringBoot.MiniFlipkart.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "customerid")
    private User user;

    @Column(name = "amount")
    private int amount;

    @Column(name = "numberofitems")
    private int numberOfItems;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedat")
    private java.sql.Timestamp updatedAt;


    // No Argument Constructor
    public Cart() {

    }

    // Parameterized Constructor
    public Cart(int amount, int numberOfItems, User user) {
        this.amount = amount;
        this.numberOfItems = numberOfItems;
        this.user = user;
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

    // return the numberOfItems
    public int getNumberOfItems() {
        return numberOfItems;
    }

    // return the createdAt timestamp
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    // return the updatedAt timestamp
    public java.sql.Timestamp getUpdatedAt() {
        return updatedAt;
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

    // set the numberOfItems
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    // set the createdAt timestamp
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // set the updatedAt timestamp
    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    // to string function to print the object
    @Override
    public String toString() {
        return String.format("Cart [id=%s, user=%s, amount=%s, numberOfItems=%s, createdAt=%s, updatedAt=%s]", id, user,
                amount, numberOfItems, createdAt, updatedAt);
    }


}


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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandid")
    private Brand brand;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedat")
    private java.sql.Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "vendorid")
    private User user;


    // No Argument Constructor
    public Product() {

    }

    // Parameterrized Costructor
    public Product(String name, int price, Brand brand, User user) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.user = user;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the name
    public String getName() {
        return name;
    }

    // return the price
    public int getPrice() {
        return price;
    }

    // return the brand object
    public Brand getBrand() {
        return brand;
    }

    // return the createdAt timestamp
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    // return the updatedAt timestamp
    public java.sql.Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // return the user object( vendor )
    public User getUser() {
        return user;
    }


    // set the id
    public void setId(int id) {
        this.id = id;
    }

    // set the name
    public void setName(String name) {
        this.name = name;
    }

    // set the price
    public void setPrice(int price) {
        this.price = price;
    }

    // set the brand object
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    // set the createdAt timestamp
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // set the updatedAt timestamp
    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    // set the user oject( vendor )
    public void setUser(User user) {
        this.user = user;
    }


    // print the product object to console
    @Override
    public String toString() {
        return String.format("Product [id=%s, name=%s, price=%s, brand=%s, createdAt=%s, updatedAt=%s, user=%s]", id,
                name, price, brand, createdAt, updatedAt, user);
    }

}

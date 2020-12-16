
package miniflipkart.application.entities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customeraddress")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "addressid")
    private Address address;


    // No Argument Constructor
    public CustomerAddress() {

    }

    // Parameterized Constructor
    public CustomerAddress(User user, Address address) {
        this.user = user;
        this.address = address;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the user object( customer )
    public User getUser() {
        return user;
    }

    // return the address object
    public Address getAddress() {
        return address;
    }


    // set the id
    public void setId(int id) {
        this.id = id;
    }

    // set the user object( customer )
    public void setUser(User user) {
        this.user = user;
    }

    // set the address
    public void setAddress(Address address) {
        this.address = address;
    }


    // print the customeraddress obbject on console
    @Override
    public String toString() {
        return String.format("CustomerAddress [id=%s, user=%s, address=%s]", id, user, address);
    }


}

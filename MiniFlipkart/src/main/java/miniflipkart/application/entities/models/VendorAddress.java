
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
@Table(name = "vendoraddress")
public class VendorAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "vendorid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "addressid")
    private Address address;


    // NO-Argument Constructor
    public VendorAddress() {

    }

    // Parameterized Constructor
    public VendorAddress(User user, Address address) {
        this.user = user;
        this.address = address;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the user object( vendor )
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

    // set the user object( vendor )
    public void setUser(User user) {
        this.user = user;
    }

    // set the address object
    public void setAddress(Address address) {
        this.address = address;
    }


    // print vendoraddress object to console
    @Override
    public String toString() {
        return String.format("VendorAddress [id=%s, user=%s, address=%s]", id, user, address);
    }

}


package miniflipkart.application.entities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "housenumber")
    private String houseNumber;

    @Column(name = "locality")
    private String locality;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private String pincode;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedat")
    private java.sql.Timestamp updatedAt;


    // No Argument Constructor
    public Address() {

    }

    // Parameterized Constructor
    public Address(String houseNumber, String locality, String state, String country, String pincode) {
        this.houseNumber = houseNumber;
        this.locality = locality;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the houseNumber
    public String getHouseNumber() {
        return houseNumber;
    }

    // return the locality
    public String getLocality() {
        return locality;
    }

    // return the state
    public String getState() {
        return state;
    }

    // return the country
    public String getCountry() {
        return country;
    }

    // return the pincode
    public String getPincode() {
        return pincode;
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

    // set the houseNumber
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    // set the locaity
    public void setLocality(String locality) {
        this.locality = locality;
    }

    // set the state
    public void setState(String state) {
        this.state = state;
    }

    // set the country
    public void setCountry(String country) {
        this.country = country;
    }

    // set the pincode
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    // set the createdAt timstamp
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // set the updatedAt timestamp
    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    //print the address object to console
    @Override
    public String toString() {
        return String.format(
                "Address [id=%s, houseNumber=%s, locality=%s, state=%s, country=%s, pincode=%s, createdAt=%s, updatedAt=%s]",
                id, houseNumber, locality, state, country, pincode, createdAt, updatedAt);
    }

}


package SpringBoot.MiniFlipkart.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedat")
    private java.sql.Timestamp updatedAt;


    // No-Argument Conostructor
    public Brand() {

    }

    // Parameterized Constructor
    public Brand(String name) {
        this.name = name;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the name
    public String getName() {
        return name;
    }

    // return the cratedAt timestamp
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

    // set the name
    public void setName(String name) {
        this.name = name;
    }

    // set the createdAt timestamp
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // set the updaedAt timestamp
    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    // print brand object to console
    @Override
    public String toString() {
        return String.format("Brand [id=%s, name=%s, createdAt=%s, updatedAt=%s]", id, name, createdAt, updatedAt);
    }

}

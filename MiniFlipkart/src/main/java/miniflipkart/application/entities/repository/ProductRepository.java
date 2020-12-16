package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Find the List of Products by a vendor
    @Query(value = "SELECT p FROM Product p WHERE p.user.id = :vendorid")
    public List<Product> getByVendorId(@Param("vendorid") int vendorid);

    // Find the List of products of a particular Brand
    @Query(value = "SELECT p FROM Product p WHERE p.brand.id = :brandid")
    public List<Product> getProductByBrandId(@Param("brandid") int brandid);
}

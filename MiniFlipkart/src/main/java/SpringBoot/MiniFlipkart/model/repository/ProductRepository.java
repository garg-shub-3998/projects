package SpringBoot.MiniFlipkart.model.repository;

import SpringBoot.MiniFlipkart.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p WHERE p.user.id = :id")
    public List<Product> getByVendorId(@Param("id") int vendorid);

    @Query(value = "SELECT p FROM Product p WHERE p.brand.id = :id")
    public List<Product> getProductByBrandId(@Param("id") int brandid);
}

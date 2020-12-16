package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.VendorAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAddressRepository extends JpaRepository<VendorAddress, Integer> {
}

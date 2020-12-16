package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
}

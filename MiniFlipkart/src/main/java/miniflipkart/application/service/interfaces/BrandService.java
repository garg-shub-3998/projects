
package miniflipkart.application.service.interfaces;

import java.util.List;

import miniflipkart.application.rdos.BrandRdo;
import miniflipkart.application.entities.models.Brand;


// BrandService interface provides all functionalities related to Brand entity
public interface BrandService {


    List<BrandRdo> getBrands();

    void save(Brand brand);

    void deleteById(int brandid);

    boolean validateBrandAdd(String brand);

    boolean validateBrandDelete(int brandid);

    Brand getBrand(int brandid);
}

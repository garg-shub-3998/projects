
package SpringBoot.MiniFlipkart.application.service;

import java.util.List;

import SpringBoot.MiniFlipkart.application.rdos.BrandRdo;
import SpringBoot.MiniFlipkart.model.entity.Brand;


// BrandService interface provides all functionalities related to Brand entity
public interface BrandService {


    public List<BrandRdo> getBrands();

    public void save(String brand);

    public void deleteById(int id);


    public Brand getBrand(int brandid);

}

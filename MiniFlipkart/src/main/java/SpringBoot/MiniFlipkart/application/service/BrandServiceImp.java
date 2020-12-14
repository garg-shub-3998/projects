/**
 *
 */
package SpringBoot.MiniFlipkart.application.service;

import java.util.ArrayList;
import java.util.List;

import SpringBoot.MiniFlipkart.application.rdos.BrandRdo;
import SpringBoot.MiniFlipkart.model.entity.Brand;
import SpringBoot.MiniFlipkart.model.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Shubham Garg
 */
@Service
public class BrandServiceImp implements BrandService {

    // BrandRepository object
    @Autowired
    private BrandRepository brandRepository;

    // Generate the list of available Brands
    @Override
    @Transactional
    public List<BrandRdo> getBrands() {
        // gives the list of brands
        List<Brand> brands = brandRepository.findAll();
        List<BrandRdo> brandRdos = new ArrayList<BrandRdo>();
        for (Brand b : brands) {
            BrandRdo br = new BrandRdo();
            br.setId(b.getId());
            br.setName(b.getName());
            brandRdos.add(br);
        }
        return brandRdos;
    }

    // save the Brand
    @Override
    @Transactional
    public void save(String brand) {
        // Create brand
        Brand b = new Brand(brand);
        // save new brand
        brandRepository.save(b);
    }

    // delete the Brand by id
    @Override
    @Transactional
    public void deleteById(int id) {
        // delete brand by id
        brandRepository.deleteById(id);
    }


    // get brand by id
    @Override
    @Transactional
    public Brand getBrand(int brandid) {
        // gives brand by id
        return brandRepository.getOne(brandid);
    }

}

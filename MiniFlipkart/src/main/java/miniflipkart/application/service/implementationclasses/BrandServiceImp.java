/**
 *
 */
package miniflipkart.application.service.implementationclasses;

import java.util.ArrayList;
import java.util.List;

import miniflipkart.application.rdos.BrandRdo;
import miniflipkart.application.entities.models.Brand;
import miniflipkart.application.entities.repository.BrandRepository;
import miniflipkart.application.service.interfaces.BrandService;
import miniflipkart.application.service.interfaces.ProductService;
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

    // ProductService object
    @Autowired
    private ProductService productService;

    // Generate the list of available Brands
    @Override
    @Transactional
    public List<BrandRdo> getBrands() {
        // gives the list of brands
        List<Brand> brands = brandRepository.findAll();

        // Generate BrandRdos list from the brands
        List<BrandRdo> brandRdos = new ArrayList<BrandRdo>();
        for (Brand b : brands) {
            BrandRdo br = new BrandRdo();
            br.setId(b.getId());
            br.setName(b.getName());
            brandRdos.add(br);
        }

        // return BrandRdos List
        return brandRdos;
    }

    // save the Brand
    @Override
    @Transactional
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    // delete the Brand by id
    @Override
    @Transactional
    public void deleteById(int brandid) {
        // delete brand by id
        brandRepository.deleteById(brandid);
    }

    // get brand by id
    @Override
    @Transactional
    public Brand getBrand(int brandid) {
        // gives brand by id
        return brandRepository.getOne(brandid);
    }

    // check brand exist or not
    @Override
    @Transactional
    public boolean validateBrandAdd(String brand) {
        boolean ans = true;

        // extract list of brands from database
        List<Brand> b = brandRepository.findAll();

        // conpares name of brands
        for (int i = 0; i < b.size(); i++) {
            if (brand.toLowerCase().equals(b.get(i).getName().toLowerCase())) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    @Override
    public boolean validateBrandDelete(int brandid) {
        // validate brand for refrential interity in product table
        return productService.validateBrandDelete(brandid);
    }


}

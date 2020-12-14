
package SpringBoot.MiniFlipkart.application.apis;


import SpringBoot.MiniFlipkart.application.config.token.service.TokenServiceImp;
import SpringBoot.MiniFlipkart.application.rdos.BrandRdo;
import SpringBoot.MiniFlipkart.application.service.BrandService;
import SpringBoot.MiniFlipkart.application.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api/admin")
public class AdminApi {

    @Autowired
    private TokenServiceImp tokenService;

    // BrandService object
    @Autowired
    private BrandService brandService;

    // Validate object
    @Autowired
    private Validator validator;


    /**
     * show the list of brands availabe
     */
    @GetMapping("/getBrands")
    public List<BrandRdo> getBrands() {

            List<BrandRdo> brands = brandService.getBrands();
            return brands;

    }


    /**
     * add new brand to database
     */
    @PostMapping("addBrand")
    public boolean addBrand(@RequestParam String brand) {
        boolean ans = validator.validateBrand(brand);
        if (ans) {
            brandService.save(brand);
            return true;
        } else {
            return false;
        }
    }

    /**
     * delete brand from database
     */
    @DeleteMapping("/deleteBrand")
    public boolean deleteBrand(@RequestParam int brandid) {
        if (validator.validateBrandDelete(brandid)) {
            brandService.deleteById(brandid);
            return true;
        } else {
            return false;
        }
    }
}

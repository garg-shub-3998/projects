
package miniflipkart.application.apis;


import miniflipkart.application.entities.models.Brand;
import miniflipkart.application.rdos.BrandRdo;
import miniflipkart.application.service.interfaces.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Brand Apis
 *
 * getBrands -> returns list or brands
 * getBrand -> returns a particular brand from brand id
 * addBrand -> add a new Brand
 * updateBrand -> update the brand
 * deleteBrand -> delete the brand
 */
@RestController
@RequestMapping("/api")
public class BrandApi {

    // BrandService object
    @Autowired
    private BrandService brandService;


    /**
     * show the list of brands availabe
     */
    @GetMapping("/brands")
    public List<BrandRdo> getBrands(HttpServletResponse response) {
        // Extract list of brands
        List<BrandRdo> brandRdos = brandService.getBrands();

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return the list of BrandRdo objects
        return brandRdos;
    }

    /**
     * show the list of brands availabe
     */
    @GetMapping("/brands/{brandid}")
    public BrandRdo getBrand(@PathVariable int brandid, HttpServletResponse response) {
        // Extract brand
        Brand brand = brandService.getBrand(brandid);

        // Generate BrandRdo
        BrandRdo brandRdo = new BrandRdo();
        brandRdo.setId(brand.getId());
        brandRdo.setName(brand.getName());

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);

        // return the brandRdo object
        return brandRdo;
    }


    /**
     * add new brand to database
     */
    @PostMapping("/brands")
    public void addBrand(@RequestParam String brandName, HttpServletResponse response) {
        // check if brand is already present or not
        boolean ans = brandService.validateBrandAdd(brandName);

        if (ans) {
            // create a new Brand object
            Brand brand = new Brand(brandName);

            // save the brand into database
            brandService.save(brand);

            // set the response status
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            // set the response status
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    /**
     * update brand to database
     */
    @PutMapping("/brands")
    public void updateBrand(@RequestParam int brandid, @RequestParam String brandName, HttpServletResponse response) {
        // Extract brand
        Brand brand = brandService.getBrand(brandid);

        // update name
        brand.setName(brandName);

        // save brand
        brandService.save(brand);

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);
    }

    /**
     * delete brand from database
     */
    @DeleteMapping("/brands")
    public void deleteBrand(@RequestParam int brandid, HttpServletResponse response) {
        // check for refrential integrity in product table
        boolean ans = brandService.validateBrandDelete(brandid);

        if (ans) {
            // delete brand
            brandService.deleteById(brandid);

            // set the response status
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // set the response status
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}


package SpringBoot.MiniFlipkart.application.service;

import java.util.ArrayList;
import java.util.List;

import SpringBoot.MiniFlipkart.application.rdos.ProductRdo;
import SpringBoot.MiniFlipkart.model.entity.Product;
import SpringBoot.MiniFlipkart.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Shubham Garg
 */
@Service
public class ProductServiceImp implements ProductService {

    // ProductRepository object
    @Autowired
    private ProductRepository productRepository;

    // list of products by vendorid
    @Override
    @Transactional
    public List<ProductRdo> getProducts(int vendorid) {
        // return list of product by each vendor
        List<Product> products = productRepository.getByVendorId(vendorid);
        List<ProductRdo> productRdos = new ArrayList<ProductRdo>();
        for (Product p : products) {
            ProductRdo pr = new ProductRdo();
            pr.setId(p.getId());
            pr.setName(p.getName());
            pr.setPrice(p.getPrice());
            pr.setVendorid(p.getUser().getId());
            pr.setBrandName(p.getBrand().getName());
            productRdos.add(pr);
        }
        return productRdos;
    }

    // save new product
    @Override
    @Transactional
    public void save(Product product) {
        // save a product
        productRepository.save(product);
    }

    // delete product by id
    @Override
    @Transactional
    public void delete(int id) {
        // delete product by id
        productRepository.deleteById(id);
    }

    // get the list of all available products
    @Override
    @Transactional
    public List<ProductRdo> getProducts() {
        // return list of all available products
        List<Product> products = productRepository.findAll();
        List<ProductRdo> productRdos = new ArrayList<ProductRdo>();
        for (Product p : products) {
            ProductRdo pr = new ProductRdo();
            pr.setId(p.getId());
            pr.setName(p.getName());
            pr.setPrice(p.getPrice());
            pr.setVendorid(p.getUser().getId());
            pr.setBrandName(p.getBrand().getName());
            productRdos.add(pr);
        }
        return productRdos;
    }

}

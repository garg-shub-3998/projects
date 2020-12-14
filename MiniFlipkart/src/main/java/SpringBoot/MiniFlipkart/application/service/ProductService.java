
package SpringBoot.MiniFlipkart.application.service;

import SpringBoot.MiniFlipkart.application.rdos.ProductRdo;
import SpringBoot.MiniFlipkart.model.entity.Product;

import java.util.List;


// ProductService interface providing functions for Product entity
public interface ProductService {


    public List<ProductRdo> getProducts(int vendorid);


    public void save(Product product);


    public void delete(int id);


    public List<ProductRdo> getProducts();

}

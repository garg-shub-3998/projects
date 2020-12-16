
package miniflipkart.application.service.interfaces;

import miniflipkart.application.qdos.NewProductQdo;
import miniflipkart.application.rdos.ProductRdo;
import miniflipkart.application.entities.models.Product;

import java.util.List;


// ProductService interface providing functions for Product entity
public interface ProductService {

    Product generateProduct(NewProductQdo newProductBody);

    List<ProductRdo> getProducts(int vendorid);

    void save(Product product);

    void delete(int productid);

    List<ProductRdo> getProducts();

    boolean validateProduct(Product product, int vendorid);

    boolean validateBrandDelete(int brandid);

    boolean validateProductDelete(int productid);

}

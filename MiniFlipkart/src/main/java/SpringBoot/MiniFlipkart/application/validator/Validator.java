
package SpringBoot.MiniFlipkart.application.validator;

import SpringBoot.MiniFlipkart.model.entity.Product;


// validator interface provides function for different validation
public interface Validator {

    public boolean validateLogin(String username, String password);


    public boolean validateUsername(String userName);


    public boolean validateEmail(String email);


    public boolean validatePhonenumber(String phoneNumber);

    public boolean validateBrand(String brand);


    public boolean validateProduct(Product product, int vendorid);


    public boolean validateProductDelete(int id);


    public boolean validateBrandDelete(int id);


}

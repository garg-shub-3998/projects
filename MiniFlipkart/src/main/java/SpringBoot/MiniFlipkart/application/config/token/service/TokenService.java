package SpringBoot.MiniFlipkart.application.config.token.service;

import SpringBoot.MiniFlipkart.application.config.token.TokenRdo;

public interface TokenService {
    boolean validateTokenForAdmin(String token);

    boolean validateTokenForCustomer(String token);


    boolean validateTokenForVendor(String token);

    TokenRdo generateToken(String username);

    void deleteToken(String token);
}

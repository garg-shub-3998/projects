package SpringBoot.MiniFlipkart.application.config.token.service;

import SpringBoot.MiniFlipkart.application.config.token.UserToken;
import SpringBoot.MiniFlipkart.application.config.token.TokenRdo;
import SpringBoot.MiniFlipkart.application.config.token.UserTokenRepository;
import SpringBoot.MiniFlipkart.model.entity.User;
import SpringBoot.MiniFlipkart.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class TokenServiceImp implements TokenService {

    @Autowired
    // UserRepository object
    private UserRepository userRepository;

    @Autowired
    // JwtService object
    private UserTokenRepository userTokenRepository;

    @Transactional
    public TokenRdo generateToken(String username) {

        User user = userRepository.findByUsername(username);
        UserToken userToken = new UserToken();
        userToken.setUserid(user.getId());
        userToken.setToken(getRandomString() + user.getUserName() + getRandomString());
        userTokenRepository.save(userToken);
        return (new TokenRdo(userToken.getToken()));
    }

    protected String getRandomString() {
        String AlphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder string = new StringBuilder();
        Random rnd = new Random();
        while (string.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * AlphaNumeric.length());
            string.append(AlphaNumeric.charAt(index));
        }
        String Str = string.toString();
        return Str;

    }

    @Transactional
    public boolean validateTokenForCustomer(String token) {
        boolean ans = false;
        UserToken userToken = null;
        userToken = userTokenRepository.getByToken(token);
        if (userToken != null) {
            User user = userRepository.getOne(userToken.getUserid());
            if (user != null && "customer".equals(user.getUserType())) {
                ans = true;
            }
        }
        return ans;
    }

    @Transactional
    public boolean validateTokenForAdmin(String token) {
        boolean ans = false;
        UserToken userToken = null;
        userToken = userTokenRepository.getByToken(token);
        if (userToken != null) {
            User user = userRepository.getOne(userToken.getUserid());
            if (user!= null && "admin".equals(user.getUserType())) {
                ans = true;
            }
        }
        return ans;
    }

    @Transactional
    public boolean validateTokenForVendor(String token) {
        boolean ans = false;
        UserToken userToken = null;
        userToken = userTokenRepository.getByToken(token);
        if (userToken != null) {
            User user = userRepository.getOne(userToken.getUserid());
            if (user != null && "vendor".equals(user.getUserType())) {
                ans = true;
            }
        }
        return ans;
    }

    @Transactional
    public void deleteToken(String token) {
        UserToken userToken = userTokenRepository.getByToken(token);
        userTokenRepository.delete(userToken);
    }
}

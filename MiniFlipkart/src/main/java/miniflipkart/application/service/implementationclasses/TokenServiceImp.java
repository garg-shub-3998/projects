package miniflipkart.application.service.implementationclasses;

import miniflipkart.application.entities.models.UserToken;
import miniflipkart.application.rdos.TokenRdo;
import miniflipkart.application.entities.repository.UserTokenRepository;
import miniflipkart.application.entities.models.User;
import miniflipkart.application.entities.repository.UserRepository;
import miniflipkart.application.service.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

/**
 * @author Shubham Garg
 */
@Service
public class TokenServiceImp implements TokenService {

    @Autowired
    // UserRepository object
    private UserRepository userRepository;


    @Autowired
    // UserTokenRepository object
    private UserTokenRepository userTokenRepository;



    // generate randon alphanumeric string
    protected String getRandomString() {
        // String contain all alpha numeric characters
        String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder string = new StringBuilder();

        // object of Randon to generate randon numbers
        Random rnd = new Random();

        while (string.length() < 9) {
            // generating a randon index.
            int index = (int) (rnd.nextFloat() * ALPHA_NUMERIC.length());
            // include the character at randon index into stringbuilder
            string.append(ALPHA_NUMERIC.charAt(index));
        }
        // parsing stringbuilder to string
        String Str = string.toString();
        return Str;
    }


    // generate TokenRdo object
    @Override
    @Transactional
    public TokenRdo generateToken(String userName) {
        // extract User
        User user = userRepository.findByUsername(userName);

        // generate UserToken
        UserToken userToken = new UserToken();
        userToken.setUserid(user.getId());
        //token generate by randon strings and username
        userToken.setToken(getRandomString() + user.getUserName() + getRandomString());

        // save UserToken
        userTokenRepository.save(userToken);

        // return a TokenRdo object
        return (new TokenRdo(userToken.getToken()));
    }

    // validate token
    @Override
    @Transactional
    public boolean validateToken(String token) {
        boolean ans = false;
        UserToken userToken = null;

        // get UserToken by token
        userToken = userTokenRepository.getByToken(token);
        if (userToken != null) {
            ans = true;
        }
        return ans;
    }

    // delete UserToken
    @Override
    @Transactional
    public void deleteToken(String token) {
        UserToken userToken = userTokenRepository.getByToken(token);
        userTokenRepository.delete(userToken);
    }
}


package miniflipkart.application.apis;


import miniflipkart.application.service.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api")
public class LogoutApi {

    // TokenService object
    @Autowired
    private TokenService tokenService;

    /**
     * removes user from current session
     */
    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // Extract token from the header
        String token = request.getHeader("Auth");

        // Delete token from database
        tokenService.deleteToken(token);

        // set the response status
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

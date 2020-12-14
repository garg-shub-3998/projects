/**
 *
 */
package SpringBoot.MiniFlipkart.application.apis;


import SpringBoot.MiniFlipkart.application.config.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Shubham Garg
 */
@RestController
@RequestMapping("/api/logout")
public class LogoutApi {

    @Autowired
    private TokenService tokenService;

    /**
     * removes user from current session
     */
    @GetMapping("/removeUser")
    public boolean removeUser(HttpServletRequest request) {
        String token = request.getHeader("Auth");
        tokenService.deleteToken(token);
        System.out.println("Invalidate user token");
        return true;
    }
}

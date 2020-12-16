package miniflipkart.application.filter;

import miniflipkart.application.service.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthorizationFilter checks for id the token present is valid or not
 */
@Component
public class AuthorizationFilter extends GenericFilter {

    // TokenService object
    @Autowired
    private TokenService tokenService;



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest Request = (HttpServletRequest)request;
        HttpServletResponse Response = (HttpServletResponse) response;

        // extract token from the URL header
        String token = Request.getHeader("Auth");

        // validate token
        boolean ans = tokenService.validateToken(token);
        if(ans){
            // forward the request to apis
            chain.doFilter(request, response);
        }else{
            // send the error
            ((HttpServletResponse) response).sendError(401);
        }

    }


    @Override
    public void destroy() {

    }
}

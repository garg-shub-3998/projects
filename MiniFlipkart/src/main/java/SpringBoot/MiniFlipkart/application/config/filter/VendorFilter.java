package SpringBoot.MiniFlipkart.application.config.filter;

import SpringBoot.MiniFlipkart.application.config.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class VendorFilter extends GenericFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest Request = (HttpServletRequest)request;
        HttpServletResponse Response = (HttpServletResponse) response;
        String token = Request.getParameter("Auth");

        boolean ans = tokenService.validateTokenForVendor(token);
        if(ans){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse) response).sendError(401);
        }

    }


    @Override
    public void destroy() {

    }
}

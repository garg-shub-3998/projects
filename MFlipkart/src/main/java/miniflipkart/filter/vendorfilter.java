package miniflipkart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class customerfilter
 */
@WebFilter(value = "*.ve")
public class vendorfilter implements Filter {

    /**
     * Default constructor. 
     */
    public vendorfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest Request = (HttpServletRequest) request;
		// pass the request along the filter chain
		
		if (Request.getSession().getAttribute("usertype") != null && Request.getSession().getAttribute("usertype").equals("vendor")) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/login.all").forward(request,
				response);		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package kuntakyol.aysegul.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kuntakyol.aysegul.mbeans.LoginBean;



/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
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
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("loginBean")==null)
		{
			//Hiç login olmamış demektir
			res.sendRedirect("/"+req.getContextPath()+"/unauthorized.xhtml");
		}
		else
		{
			  LoginBean loginBean = (LoginBean)session.getAttribute("loginBean");
			 
			  if(loginBean.getRole()==null || !loginBean.getRole().getRoleName().equals("admin"))
			  {
				  res.sendRedirect("/"+req.getContextPath()+"/unauthorized.xhtml");
			  }
		}
	  
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

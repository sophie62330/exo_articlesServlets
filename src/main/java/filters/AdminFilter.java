package filters;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebFilter(urlPatterns = "/admin")
public class AdminFilter implements Filter {
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Log filter init !");
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter destroy !!");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req; 
		HttpServletResponse response=(HttpServletResponse) res;
		ServletOutputStream out=res.getOutputStream();

		HttpSession session = request.getSession();
		
		User user=(User) session.getAttribute("USER");
		
		String contextPath = request.getContextPath();
		if (!user.getEstAdmin()) {
			response.sendRedirect(contextPath+"/Accueil");
			return;
		}
		
		filterChain.doFilter(req, res);
	}
}

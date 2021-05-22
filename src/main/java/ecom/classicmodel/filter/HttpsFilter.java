package ecom.classicmodel.filter;

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

@WebFilter("/*")

public class HttpsFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		String uri = httpServletRequest.getRequestURI();
		String getProtocol = httpServletRequest.getScheme();
		String getDomain = httpServletRequest.getServerName();
		String getPort = Integer.toString(httpServletRequest.getServerPort());

		if (getProtocol.toLowerCase().equals("http")) {

			String httpsPath = "https" + "://" + getDomain + ":8443" + uri;

			httpServletResponse.sendRedirect(httpsPath);
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

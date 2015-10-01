package br.com.sgm.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptador extends HandlerInterceptorAdapter {
	
	private static Logger logger = Logger.getLogger(AutorizadorInterceptador.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {
		
		

		String uri = request.getRequestURI();
		logger.info("URI: " + uri);
		
		if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin")
				|| uri.contains("resources")) {
			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}

		response.sendRedirect("loginForm");
		logger.error("erro na autenticação");
		return false;
	}

}

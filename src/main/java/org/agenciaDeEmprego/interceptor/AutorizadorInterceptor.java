package org.agenciaDeEmprego.interceptor;

import org.agenciaDeEmprego.acesso.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	private Hashtable<String, Acesso> acesso = new Hashtable<String, Acesso>();
	
	public AutorizadorInterceptor() {
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		String uri = request.getRequestURI();
		if(acesso.get(uri).autorizar(request.getSession(false))) {
			return true;
		}
		
		response.sendRedirect("loginCandidato");
		return false;
	}

}

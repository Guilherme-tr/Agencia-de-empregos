package org.agenciaDeEmprego.acesso;

import org.agenciaDeEmprego.modelo.Usuario;

import javax.servlet.http.HttpSession;

public class Admin implements Acesso {
	
	@Override
	public boolean autorizar(HttpSession sessao) {
		if(sessao == null) return false;
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		if(usuario != null && usuario.getLogin().equals("admin")) return true;
		return false;
	}

}

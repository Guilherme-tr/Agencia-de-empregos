package org.agenciaDeEmprego.acesso;

import org.agenciaDeEmprego.modelo.Usuario;

import javax.servlet.http.HttpSession;

public class Logado implements Acesso {

	@Override
	public boolean autorizar(HttpSession sessao) {
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		if((sessao != null) && (usuario != null)) return true;
		return false;
	}
	
	

}

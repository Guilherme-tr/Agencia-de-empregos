package org.agenciaDeEmprego.acesso;

import javax.servlet.http.HttpSession;

public class Deslogado implements Acesso {
	
	@Override
	public boolean autorizar(HttpSession sessao) {
		return true;
	}

}

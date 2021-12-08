package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.repositorio.CandidatoRepositorio;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class AutenticadorControle {

	private CandidatoRepositorio repositorioCandidato;
	private EmpresaRepositorio repositorioEmpresa;


	@Autowired //injeção de dependência
	public AutenticadorControle(CandidatoRepositorio repositorio, EmpresaRepositorio repositorioEmpresa) {
		super();
		this.repositorioCandidato = repositorio;
		this.repositorioEmpresa = repositorioEmpresa;
	}
	
	@RequestMapping("loginCandidato")
	public String loginCandidato(@ModelAttribute String msg) {
		return "LoginCandidato";
	}

	@RequestMapping("loginEmpresa")
	public String loginEmpresa(@ModelAttribute String msg) {
		return "LoginEmpresa";
	}

	@RequestMapping(value = "autenticarCandidato", method = RequestMethod.POST)
	public String autenticar( Candidato candidato, HttpSession sessao ) {
		if ( repositorioCandidato.autenticarCandidato( candidato ) ) {
			sessao.setAttribute( "candidato", repositorioCandidato.getCandidatoByLogin(candidato));
			System.out.println(sessao.getAttribute("candidato"));
			if(candidato.getLogin().equals("admin")){
				return "redirect:admin-pagina-inicial";
			}
			else {
				return "redirect:candidato-pagina-inicial";
			}
		}
		return "LoginCandidato";
	}

	@RequestMapping(value = "autenticarEmpresa", method = RequestMethod.POST)
	public String autenticar( Empresa empresa, HttpSession sessao ) {
		if ( repositorioEmpresa.autenticarEmpresa( empresa ) ) {
			 sessao.setAttribute( "empresa", repositorioEmpresa.getEmpresa( empresa.getLogin() ) );
			return "redirect:empresa-pagina-inicial";
		}
		return "LoginEmpresa";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession sessao) {
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		return "LoginCandidato";
	}

}

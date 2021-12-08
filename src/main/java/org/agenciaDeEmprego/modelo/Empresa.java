package org.agenciaDeEmprego.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Empresa extends Usuario {

	private int codigo;
	private String nome;

	@OneToMany
	private List<Oferta> vagas;

	public Empresa() {
	}

	public Empresa( int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Empresa( int codigo, String nome, List<Oferta> vagas ) {
		this.codigo = codigo;
		this.nome = nome;
		this.vagas = vagas;
	}

	public Empresa( String login, String senha, int codigo, String nome, List<Oferta> vagas ) {
		super( login, senha );
		this.codigo = codigo;
		this.nome = nome;
		this.vagas = vagas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Oferta> getVagas() {
		return vagas;
	}

	public void setVagas(List<Oferta> vagas) {
		this.vagas = vagas;
	}
	
	
}

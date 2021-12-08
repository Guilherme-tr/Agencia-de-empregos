package org.agenciaDeEmprego.modelo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Candidato extends Usuario {
	@Column(unique = true)
	private String cpf;

	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNasc;

	private String codigoCS;
	private String nomeCS;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Cargo> experiencia;

	public Candidato() {
	}

	public Candidato( String login, String senha, String cpf, String nome, LocalDate dataNasc, String codigoCS, String nomeCS, List<Cargo> experiencia ) {
		super( login, senha );
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.codigoCS = codigoCS;
		this.nomeCS = nomeCS;
		this.experiencia = experiencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCodigoCS() {
		return codigoCS;
	}

	public void setCodigoCS(String codigoCS) {
		this.codigoCS = codigoCS;
	}

	public String getNomeCS() {
		return nomeCS;
	}

	public void setNomeCS(String nomeCS) {
		this.nomeCS = nomeCS;
	}

	public List<Cargo> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<Cargo> experiencia) {
		this.experiencia = experiencia;
	}

	public void addExperiencia (Cargo cargo) {
		experiencia.add(cargo);
	}

	@Override
	public String toString() {
		return "Candidato{" +
				"cpf='" + cpf + '\'' +
				", nome='" + nome + '\'' +
				", dataNasc=" + dataNasc +
				", codigoCS=" + codigoCS +
				", nomeCS='" + nomeCS + '\'' +
				", experiencia=" + experiencia +
				"} " + super.toString();
	}
}

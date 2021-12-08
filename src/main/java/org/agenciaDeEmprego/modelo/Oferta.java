package org.agenciaDeEmprego.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Oferta {
    @Id
    @GeneratedValue
    int id;

    @Column(unique = true)
    String codigo;

    @ManyToOne
    Cargo cargo;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Candidato> candidatos;

    @ManyToOne
    Empresa empresa;

    private float salario;
    private int horas;

    public Oferta() {
    }

    public Oferta( String codigo, Cargo cargo, Empresa empresa, float salario, int horas ) {
        super();
        this.codigo = codigo;
        this.cargo = cargo;
        this.empresa = empresa;
        this.salario = salario;
        this.horas = horas;
    }

    public Oferta( String codigo, float salario, int horas ) {
        this.codigo = codigo;
        this.salario = salario;
        this.horas = horas;
    }

    public Oferta( String codigo, float salario, int horas, Cargo cargo ) {
        this.codigo = codigo;
        this.salario = salario;
        this.horas = horas;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos( List<Candidato> candidatos ) {
        this.candidatos = candidatos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo( String codigo ) {
        this.codigo = codigo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo( Cargo cargo ) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa( Empresa empresa ) {
        this.empresa = empresa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario( float salario ) {
        this.salario = salario;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras( int horas ) {
        this.horas = horas;
    }

    public void addCandidato( Candidato candidato ) {
        this.candidatos.add(candidato);
    }

    public boolean hasCandidato(Candidato candidato) {
        return candidatos.contains(candidato);
    }
}

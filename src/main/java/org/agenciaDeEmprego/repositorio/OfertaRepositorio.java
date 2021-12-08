package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class OfertaRepositorio {
	@PersistenceContext
	private EntityManager manager;

	public OfertaRepositorio() {
	}

	public void cadastrar(Oferta oferta) {
		manager.merge(oferta);
	}

	public void update(Oferta oferta) {
		manager.merge(oferta);
	}
	
	public Oferta getOferta(int codigo) {
		Query query = manager.createQuery("select u from Oferta u where u.id = ?1");
		query.setParameter(1, codigo);
		try {
			return (Oferta) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Oferta> buscarOfertas( int intEmpresa ) {
		TypedQuery<Oferta> query = manager.createQuery( "SELECT o FROM Oferta o WHERE o.empresa = ?1", Oferta.class );
		query.setParameter( 1, intEmpresa );
		try {
			return query.getResultList();
		} catch ( NoResultException e ) {
			return null;
		}
	}

	public List<Oferta> buscarOfertas(  ) {
		TypedQuery<Oferta> query = manager.createQuery( "SELECT o FROM Oferta o", Oferta.class );
		try {
			return query.getResultList();
		} catch ( NoResultException e ) {
			return null;
		}
	}

	public void excluirOferta( Oferta oferta ) {
		manager.remove( oferta );;
	}
}

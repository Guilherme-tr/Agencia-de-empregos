package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class CargoRepositorio {

    @PersistenceContext
    private EntityManager manager;

    public CargoRepositorio() {
    }

    @Transactional
    public void cadastrar(Cargo cargo ) {
        manager.persist( cargo );
    }

    public CargoRepositorio(EntityManager manager) {
        this.manager = manager;
    }

    public Cargo buscarCargoPorCodigo(int cargoCodigo ) {
        Query query = manager.createQuery( "SELECT c FROM Cargo c WHERE c.codigo = ?1" );
        query.setParameter( 1, cargoCodigo );
        try {
            return ( Cargo ) query.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        }
    }

    public Cargo buscarCargoPorId(int cargoCodigo ) {
        Query query = manager.createQuery( "SELECT c FROM Cargo c WHERE c.id = ?1" );
        query.setParameter( 1, cargoCodigo );
        try {
            return ( Cargo ) query.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        }
    }

    public Cargo buscarCargo( Cargo cargo ) {
        return manager.find( Cargo.class, cargo );
    }

    public void excluirCargo( Cargo cargo ) {
        manager.remove( cargo );
    }

    public void excluirCargoPorId( int codigo ) {
        Cargo c = buscarCargoPorCodigo(codigo);
        manager.remove( c );
    }

    public void atualizarCargo( Cargo cargo ) {
        manager.persist( cargo );
    }

    public List<Cargo> buscarTodosCargos() {
        TypedQuery<Cargo> query = manager.createQuery( "SELECT c FROM Cargo c", Cargo.class);
        try {
            return query.getResultList();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}

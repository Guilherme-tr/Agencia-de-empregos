package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Empresa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class EmpresaRepositorio {

    @PersistenceContext
    private EntityManager manager;

    public EmpresaRepositorio() {
    }

    public EmpresaRepositorio(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    public void cadastrar( Empresa empresa ) {
        manager.persist( empresa );
    }

    public Empresa getEmpresa( Integer codigo ) {
        try {
            return manager.find( Empresa.class, codigo );
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public Empresa getEmpresa( String email ) {
            Query query = manager.createQuery( "select e from Empresa e WHERE e.login = ?1 ");
            query.setParameter( 1, email );
        try {
            return ( Empresa ) query.getSingleResult();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Empresa> getAll() {
        TypedQuery<Empresa> query = manager.createQuery( "select e from Empresa e", Empresa.class );
        try {
            return query.getResultList();
        } catch ( NoResultException e ) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete( Empresa empresa ) {
        try {
            manager.remove( empresa );
            return true;
        } catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean autenticarEmpresa(Empresa empresa) {
            Query query = manager.createQuery("select u from Empresa u where u.login = ?1 and u.senha = ?2");
            query.setParameter(1, empresa.getLogin()).setParameter(2, empresa.getSenha());
            try {
                query.getSingleResult();
                return true;
            } catch (NoResultException e) {
                return false;
            }
        }

    public Empresa getEmpresaComCodigo(Integer codigo) {
        Query query = manager.createQuery( "SELECT c FROM Empresa c WHERE c.codigo = ?1" );
        query.setParameter( 1, codigo );
        try {
            return (Empresa) query.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        }
    }

    @Transactional
    public boolean atualizarEmpresa(Empresa empresa) {
        Query query = manager.createQuery("update Empresa u set u.nome = ?1 where u.codigo = ?2");
        query.setParameter(1, empresa.getNome()).setParameter(2, empresa.getCodigo());
        try {
            query.executeUpdate();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
}


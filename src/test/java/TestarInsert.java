/*
    Use esta classe para inserir dados no banco de dados.
    O intuito dessa inserção é apenas popular o banco para que
    os testes possam ser feitos mais rápidos.
    Esta classe não abrange todos cenários possiveis de teste.
    Criado em: 05/02/2021
 */


import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestarInsert {

    public static void main( String[] args ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();


        Candidato admin = new Candidato("admin", "admin", "000.000.000-00", "Administrador",
                LocalDate.parse( "1995-10-09" ), null, null, null );
        Candidato candidato1 = new Candidato( "candidato1", "candidato1", "111.111.111-11", "Candidato 01",
                LocalDate.parse( "1990-07-10" ), null, null, null );
        Candidato candidato2 = new Candidato( "candidato2", "candidato2", "222.222.222-22", "Candidato 02",
                LocalDate.parse( "1993-02-23" ), null, null, null );
        Candidato candidato3 = new Candidato( "candidato3", "candidato3", "333.333.333-33", "Candidato 03",
                LocalDate.parse( "2001-12-19" ), null, null, null );
        Candidato candidato4 = new Candidato( "candidato4", "candidato4", "444.444.444-44", "Candidato 04",
                LocalDate.parse( "1995-04-30" ), null, null, null );
        Candidato candidato5 = new Candidato( "candidato5", "candidato5", "555.555.555-55", "Candidato 05",
                LocalDate.parse( "2003-02-05" ), null, null, null );

        List<Candidato> candidatos = new ArrayList<>();
        candidatos.addAll( Arrays.asList( admin, candidato1, candidato2, candidato3, candidato4, candidato5 ) );

        Empresa empresa1 = new Empresa( 123, "Amazon" );
        Empresa empresa2 = new Empresa( 345, "Google" );
        Empresa empresa3 = new Empresa( 456, "Apple" );
        Empresa empresa4 = new Empresa( 567, "Netflix" );
        Empresa empresa5 = new Empresa( 678, "Riot Games" );

        List<Empresa> empresas = new ArrayList<>();
        empresas.addAll( Arrays.asList( empresa2, empresa2, empresa3, empresa4, empresa5 ) );

        Cargo cargo1 = new Cargo( 001, "Manager", "Gerencia o líder e o time" );
        Cargo cargo2 = new Cargo( 002, "Líder", "Lídera um time da empresa" );
        Cargo cargo3 = new Cargo( 003, "Projeto Owner (PO)", "Interemediador entre cliente e desenvolvedor" );
        Cargo cargo4 = new Cargo( 004, "Quality Assurance", "Certifica que os produtos serão entregues com qualidade" );
        Cargo cargo5 = new Cargo( 005, "Developer (Dev)", "Cria e manutenseia o software" );
        Cargo cargo6 = new Cargo( 006, "Estagiário", "Aprende com o time para se tornar um bom profissional" );

        List<Cargo> cargos = new ArrayList<>();
        cargos.addAll( Arrays.asList( cargo1, cargo2, cargo3, cargo4, cargo5, cargo6 ) );

        Oferta oferta1 = new Oferta( "codOferta1", cargo1, empresa1, 15.000f, 8 );
        Oferta oferta2 = new Oferta( "codOferta2", cargo1, empresa2, 20.0000f, 8 );
        Oferta oferta3 = new Oferta( "codOferta3", cargo6, empresa2, 5000f, 6 );
        Oferta oferta4 = new Oferta( "codOferta4", cargo4, empresa2, 70000f, 8 );
        Oferta oferta5 = new Oferta( "codOferta5", cargo5, empresa5, 45000f, 8 );

        List<Oferta> ofertas = new ArrayList<>();
        ofertas.addAll( Arrays.asList( oferta1, oferta2, oferta3, oferta4, oferta5 ) );

        manager.getTransaction().begin();
        for ( Candidato candidato : candidatos ) {
            manager.persist(candidato);
        }
        manager.getTransaction().commit();

        manager.getTransaction().begin();
        for ( Empresa empresa : empresas ) {
            manager.persist(empresa);
        }
        manager.getTransaction().commit();

        manager.getTransaction().begin();
        for ( Cargo cargo : cargos ) {
            manager.persist(cargo);
        }
        manager.getTransaction().commit();

        manager.getTransaction().begin();
        for ( Oferta oferta : ofertas ) {
            manager.persist(oferta);
        }
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}

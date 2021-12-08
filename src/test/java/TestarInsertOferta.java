import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestarInsertOferta {
    public static void main( String[] args ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

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

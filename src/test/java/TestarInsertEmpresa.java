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

public class TestarInsertEmpresa {
    public static void main( String[] args ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

        Empresa empresa1 = new Empresa( 123, "Amazon" );
        Empresa empresa2 = new Empresa( 345, "Google" );
        Empresa empresa3 = new Empresa( 456, "Apple" );
        Empresa empresa4 = new Empresa( 567, "Netflix" );
        Empresa empresa5 = new Empresa( 678, "Riot Games" );

        List<Empresa> empresas = new ArrayList<>();
        empresas.addAll( Arrays.asList( empresa2, empresa2, empresa3, empresa4, empresa5 ) );


        manager.getTransaction().begin();

        manager.getTransaction().begin();
        for ( Empresa empresa : empresas ) {
            manager.persist(empresa);
        }

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

}

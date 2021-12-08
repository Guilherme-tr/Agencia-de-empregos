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

public class TestarInsertCargo {
    public static void main( String[] args ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

        Cargo cargo1 = new Cargo( 001, "Manager", "Gerencia o líder e o time" );
        Cargo cargo2 = new Cargo( 002, "Líder", "Lídera um time da empresa" );
        Cargo cargo3 = new Cargo( 003, "Projeto Owner (PO)", "Interemediador entre cliente e desenvolvedor" );
        Cargo cargo4 = new Cargo( 004, "Quality Assurance", "Certifica que os produtos serão entregues com qualidade" );
        Cargo cargo5 = new Cargo( 005, "Developer (Dev)", "Cria e manutenseia o software" );
        Cargo cargo6 = new Cargo( 006, "Estagiário", "Aprende com o time para se tornar um bom profissional" );

        List<Cargo> cargos = new ArrayList<>();
        cargos.addAll( Arrays.asList( cargo1, cargo2, cargo3, cargo4, cargo5, cargo6 ) );


        manager.getTransaction().begin();

        for ( Cargo cargo : cargos ) {
            manager.persist(cargo);
        }

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

}

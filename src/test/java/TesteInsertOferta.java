import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;
import org.agenciaDeEmprego.modelo.Usuario;
import org.agenciaDeEmprego.repositorio.CargoRepositorio;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteInsertOferta {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

        EmpresaRepositorio empresaRepositorio = new EmpresaRepositorio(manager);
        Empresa empresa = empresaRepositorio.getEmpresa(12);

        CargoRepositorio cargoRepositorio = new CargoRepositorio(manager);
        Cargo cargo = cargoRepositorio.buscarCargoPorCodigo(12);

        Oferta oferta = new Oferta("123",cargo,empresa,213123,12);

        manager.getTransaction().begin();
        manager.persist(oferta);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

}

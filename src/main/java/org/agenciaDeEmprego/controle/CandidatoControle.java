package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;
import org.agenciaDeEmprego.repositorio.CandidatoRepositorio;
import org.agenciaDeEmprego.repositorio.CargoRepositorio;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.agenciaDeEmprego.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CandidatoControle {
    private CandidatoRepositorio repositorio;
    private OfertaRepositorio ofertasRepositorio;
    private EmpresaRepositorio empresaRepositorio;
    private CargoRepositorio cargoRepositorio;

    @Autowired
    public CandidatoControle( CandidatoRepositorio repositorio, OfertaRepositorio ofertaRepositorio, EmpresaRepositorio empresaRepositorio, CargoRepositorio cargoRepositorio ) {
        super();
        this.repositorio = repositorio;
        this.ofertasRepositorio = ofertaRepositorio;
        this.cargoRepositorio = cargoRepositorio;
        this.empresaRepositorio = empresaRepositorio;
    }

    @RequestMapping("candidato-pagina-inicial")
    public String inicioCandidato( Model model, HttpSession sessao ) {
        //model.addAttribute( "candidato", repositorio.getCandidato( candidato ) );
        List<Oferta> ofertas = ofertasRepositorio.buscarOfertas();
        ofertas.removeIf(oferta -> oferta.hasCandidato((Candidato) sessao.getAttribute("candidato")));
        model.addAttribute("ofertas", ofertas);

        model.addAttribute("cargos", cargoRepositorio.buscarTodosCargos());

        return "candidato/PaginaCandidato";
    }

    @RequestMapping("admin-pagina-inicial")
    public String inicioAdmin(Model model){
        model.addAttribute("empresas", empresaRepositorio.getAll());
        model.addAttribute("cargos", cargoRepositorio.buscarTodosCargos());
        return "admin/Admin";
    }

    @Transactional
    @RequestMapping(value = "inscrever", method = RequestMethod.GET)
    public String inscreverCargo( @SessionAttribute("candidato") Candidato candidato, @ModelAttribute("id") int id, Model model ) {
        Oferta oferta = ofertasRepositorio.getOferta(id);
        oferta.addCandidato(candidato);
        ofertasRepositorio.update(oferta);
        model.addAttribute("msg", "sucesso");

        return "redirect:candidato-pagina-inicial";
    }

    @Transactional
    @RequestMapping(value = "adicionarExperiencia", method = RequestMethod.POST)
    public String adicionarExperiencia( @SessionAttribute("candidato") Candidato candidato, @ModelAttribute("id") int id, Model model ) {
        Cargo cargo = cargoRepositorio.buscarCargoPorId(id);
        candidato.addExperiencia(cargo);
        repositorio.update(candidato);
        model.addAttribute("msg", "sucesso");

        return "redirect:candidato-pagina-inicial";
    }

    @Transactional
    @RequestMapping(value = "cadastrarCandidato", method = RequestMethod.POST)
    public String cadastrar( Candidato candidato, Model model ) {
        repositorio.cadastrar( candidato );
        model.addAttribute("msg", "sucesso");

        return "LoginCandidato";
    }
}

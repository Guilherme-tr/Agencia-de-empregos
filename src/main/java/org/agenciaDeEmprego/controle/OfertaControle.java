package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;
import org.agenciaDeEmprego.repositorio.CargoRepositorio;
import org.agenciaDeEmprego.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class OfertaControle {
    private OfertaRepositorio repositorio;
    private CargoRepositorio cargoRepositorio;

    @Autowired
    public OfertaControle( OfertaRepositorio repositorio, CargoRepositorio cargoRepositorio ) {
        this.repositorio = repositorio;
        this.cargoRepositorio = cargoRepositorio;
    }

    @RequestMapping("detalhes-oferta")
    public String detalhesOferta( int id, Model model ) {
        model.addAttribute( "oferta", repositorio.getOferta( id ) );
        return "empresa/DetalhesOferta";
    }

    @RequestMapping("excluir-oferta")
    public String excluirOferta( int numero ) {
        Oferta oferta = repositorio.getOferta( numero );
        repositorio.excluirOferta( oferta );
        return "empresa/DetalhesOferta";
    }

    @RequestMapping("pagina-cadastro-oferta")
    public String visaoCadastroOferta( @SessionAttribute("empresa") Empresa empresa, Model model ) {
        model.addAttribute( "cargos", cargoRepositorio.buscarTodosCargos() );
        return "empresa/CadastrarOferta";
    }

    @RequestMapping(value = "cadastrar-oferta", method = RequestMethod.POST)
    @Transactional
    public String cadastrarOferta( @ModelAttribute("id") Cargo cargo, Oferta oferta, HttpSession sessao ) {
        oferta.setCargo( cargo );
        oferta.setEmpresa( ( Empresa ) sessao.getAttribute( "empresa" ) );
        repositorio.cadastrar( oferta );
        return "redirect:pagina-cadastro-oferta";
    }
}

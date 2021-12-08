package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.repositorio.CargoRepositorio;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CargoControle {
    private CargoRepositorio repositorio;
    private EmpresaRepositorio empresaRepositorio;

    @Autowired
    public CargoControle( CargoRepositorio repositorio, EmpresaRepositorio empresaRepositorio ) {
        this.repositorio = repositorio;
        this.empresaRepositorio = empresaRepositorio;
    }

    @RequestMapping("cadastrar-cargo")
    public String cadastrarCargo( Cargo cargo, Model model) {
        System.out.println(cargo.toString());
        repositorio.cadastrar( cargo );
        model.addAttribute("cargos", repositorio.buscarTodosCargos());
        model.addAttribute("empresas", empresaRepositorio.getAll());
        return "admin/Admin";
    }

    @RequestMapping("atualizar-cargo")
    public String atualizarCargo( Cargo cargo ) {
        repositorio.atualizarCargo( cargo );
        return "admin/Admin";
    }

    @Transactional
    @RequestMapping("excluir-cargo")
    public String excluirCargo(int codigo, Model model) {
        repositorio.excluirCargoPorId( codigo );
        model.addAttribute("cargos", repositorio.buscarTodosCargos());
        model.addAttribute("empresas", empresaRepositorio.getAll());
        return "admin/Admin";
    }
}

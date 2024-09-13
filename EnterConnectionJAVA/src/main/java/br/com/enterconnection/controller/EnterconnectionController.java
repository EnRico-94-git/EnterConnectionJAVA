package br.com.enterconnection.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.enterconnection.model.Cliente;
import br.com.enterconnection.model.Empresa;
import br.com.enterconnection.model.Parceiro;
import br.com.enterconnection.repository.ClienteRepository;
import br.com.enterconnection.repository.EmpresaRepository;
import br.com.enterconnection.repository.ParceiroRepository;
import jakarta.validation.Valid;

@Controller
public class EnterconnectionController {


    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Autowired
    private ParceiroRepository parceiroRepository;

    // Página Inicial
    @GetMapping("/index")
    public String retornaPaginaPrincipal() {
        return "index";
    }

    // Listar Clientes
    @GetMapping("/cliente")
    public ModelAndView retornaListaClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        ModelAndView mv = new ModelAndView("cliente-lista");
        mv.addObject("clientes", clientes);
        return mv;
    }

    // Listar Empresas
    @GetMapping("/empresa")
    public ModelAndView retornaListaEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        ModelAndView mv = new ModelAndView("empresa-lista");
        mv.addObject("empresas", empresas);
        return mv;
    }

    // Listar Parceiros
    @GetMapping("/parceiro")
    public ModelAndView retornaListaParceiros() {
        List<Parceiro> parceiros = parceiroRepository.findAll();
        ModelAndView mv = new ModelAndView("parceiro-lista");
        mv.addObject("parceiros", parceiros);
        return mv;
    }

    // Formulário para cadastro de cliente
    @GetMapping("/cliente/cadastro")
    public ModelAndView retornaFormCadastroCliente() {
        ModelAndView mv = new ModelAndView("cliente-form");
        mv.addObject("cliente", new Cliente());
        return mv;
    }

    // Cadastrar Cliente
    @PostMapping("/cliente/inserir")
    public ModelAndView inserirCliente(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("cliente-form");
            mv.addObject("cliente", cliente);
            return mv;
        }
        clienteRepository.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    // Atualizar Cliente
    @GetMapping("/cliente/atualizar/{id}")
    public ModelAndView retornaFormAtualizaCliente(@PathVariable("id") String idCliente) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
        if (clienteOpt.isPresent()) {
            ModelAndView mv = new ModelAndView("cliente-form");
            mv.addObject("cliente", clienteOpt.get());
            return mv;
        }
        return new ModelAndView("redirect:/clientes");
    }

    @PostMapping("/cliente/atualizar/{id}")
    public ModelAndView atualizarCliente(@PathVariable Long id, @Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("cliente-form");
            mv.addObject("cliente", cliente);
            return mv;
        }
        clienteRepository.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    // Remover Cliente
    public String removerCliente(@PathVariable String id) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            clienteRepository.deleteById(id); // Exclusão usando o ID (String)
            return "redirect:/clientes";
        } else {
            return "redirect:/clientes"; // Ou uma página de erro personalizada
        }
    }

    // Detalhes de Empresa
    @GetMapping("/empresa/detalhes/{id}")
    public ModelAndView retornaDetalhesEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresaOpt = empresaRepository.findById(id);
        if (empresaOpt.isPresent()) {
            ModelAndView mv = new ModelAndView("empresa-detalhes");
            mv.addObject("empresa", empresaOpt.get());
            return mv;
        }
        return new ModelAndView("redirect:/empresas");
    }

    // Remover Parceiro
    @GetMapping("/parceiro/remover/{id}")
    public String removerParceiro(@PathVariable String id) {
        Optional<Parceiro> parceiroOpt = parceiroRepository.findById(id);
        if (parceiroOpt.isPresent()) {
            parceiroRepository.deleteById(id); // Exclusão usando o ID (String)
            return "redirect:/parceiros";
        } else {
            return "redirect:/parceiros"; // Ou uma página de erro personalizada
        }
    }

}

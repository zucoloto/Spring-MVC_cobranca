package br.com.zuco.controller;

import br.com.zuco.model.StatusTitulo;
import br.com.zuco.model.Titulo;
import br.com.zuco.repository.filter.TituloFilter;
import br.com.zuco.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulo")
public class TituloController {

    @Autowired
    private TituloService tituloService;

    private static final String CADASTRO_VIEW = "cadastro_titulo";

    /*@GetMapping
    public ModelAndView listar() {
        List<Titulo> listar = tituloService.listarTodos();
        ModelAndView mv = new ModelAndView("/lista_titulo");
        mv.addObject("todosTitulos", listar);
        return mv;
    }*/

    @RequestMapping
    public ModelAndView pesquisar(@ModelAttribute("filtro") TituloFilter filtro) {
        List<Titulo> listar = tituloService.filtrar(filtro);
        ModelAndView mv = new ModelAndView("/lista_titulo");
        mv.addObject("todosTitulos", listar);
        return mv;
    }

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(new Titulo());
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView editar(@PathVariable("codigo") Titulo titulo) {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(titulo);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Titulo titulo, Errors errors, RedirectAttributes attributes) {
        try {
            tituloService.salvar(titulo);
            attributes.addFlashAttribute("mensagem", "Título salvo");
            attributes.addFlashAttribute("sucesso", true);
            return "redirect:/titulo/novo";
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("dataVencimento", null, "Formato de data inválido");
            return CADASTRO_VIEW;
        }
    }

    @DeleteMapping("/delete/{codigo}")
    public String excluir(@PathVariable("codigo") Long codigo, RedirectAttributes attributes) {
        tituloService.deletar(codigo);
        attributes.addFlashAttribute("mensagem", "Título excluído.");
        attributes.addFlashAttribute("sucesso", true);
        return "redirect:/titulo";
    }

    //@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
    @PutMapping("/{codigo}/receber")
    public @ResponseBody String receber(@PathVariable Long codigo) {
        return tituloService.receber(codigo);
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo() {
        return Arrays.asList(StatusTitulo.values());
    }
}

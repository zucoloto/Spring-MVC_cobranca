package br.com.zuco.controllers;

import br.com.zuco.model.StatusTitulo;
import br.com.zuco.model.Titulo;
import br.com.zuco.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulo")
public class TituloController {

    @Autowired
    private TituloRepository tituloRepository;

    private static final String CADASTRO_VIEW = "cadastro_titulo";

    @GetMapping
    public ModelAndView listar() {
        List<Titulo> listar = tituloRepository.findAll();
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
    public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(titulo);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo) {
        tituloRepository.save(titulo);
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject("mensagem", "Título salvo!!!");
        mv.addObject("sucesso", true);
        return mv;
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo() {
        return Arrays.asList(StatusTitulo.values());
    }
}

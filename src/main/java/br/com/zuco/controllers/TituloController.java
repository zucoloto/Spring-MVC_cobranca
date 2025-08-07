package br.com.zuco.controllers;

import br.com.zuco.model.StatusTitulo;
import br.com.zuco.model.Titulo;
import br.com.zuco.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulo")
public class TituloController {

    @Autowired
    private TituloRepository tituloRepository;

    @RequestMapping("/novo")
    public String novo() {
        return "/cadastro_titulo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo) {
        tituloRepository.save(titulo);
        ModelAndView mv = new ModelAndView("/cadastro_titulo");
        mv.addObject("mensagem", "Título salvo!");
        return mv;
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo() {
        return Arrays.asList(StatusTitulo.values());
    }
}

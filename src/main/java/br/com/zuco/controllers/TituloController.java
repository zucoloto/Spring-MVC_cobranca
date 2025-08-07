package br.com.zuco.controllers;

import br.com.zuco.model.Titulo;
import br.com.zuco.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}

package br.com.zuco.controllers;

import br.com.zuco.model.Titulo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/titulo")
public class TituloController {

    @RequestMapping("/novo")
    public String novo() {
        return "/cadastro_titulo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Titulo titulo) {
        System.out.println(">>> " + titulo.getDescricao());
        return "/cadastro_titulo";
    }
}

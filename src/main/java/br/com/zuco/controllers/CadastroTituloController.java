package br.com.zuco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/titulo")
public class CadastroTituloController {

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/cadastro_titulo";
    }
}

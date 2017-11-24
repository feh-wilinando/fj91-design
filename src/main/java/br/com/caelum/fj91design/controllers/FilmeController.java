package br.com.caelum.fj91design.controllers;

import br.com.caelum.fj91design.repositories.FilmeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("filmes")
public class FilmeController {


    private FilmeRepository repository;

    public FilmeController(FilmeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("em-cartaz")
    public ModelAndView emCartaz(){

        ModelAndView view = new ModelAndView("filmes/em-cartaz");

        view.addObject("filmes", repository.findAllOpenSession());

        return view;
    }

}

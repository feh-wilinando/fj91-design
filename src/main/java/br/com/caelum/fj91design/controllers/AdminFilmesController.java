package br.com.caelum.fj91design.controllers;

import br.com.caelum.fj91design.domains.Filme;
import br.com.caelum.fj91design.repositories.FilmeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("admin/filmes")
public class AdminFilmesController {


    private final FilmeRepository filmeRepository;

    public AdminFilmesController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping({"new", "{id}"})
    public ModelAndView form(@PathVariable("id") Optional<Long> optionalId, Filme filme){
        ModelAndView view = new ModelAndView("filmes/form");

        filme = optionalId.map(filmeRepository::findOne).orElse(filme);

        System.out.println(filme);

        view.addObject("filme", filme);

        return view;
    }


    @GetMapping
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("filmes/lista");

        Iterable<Filme> filmes = filmeRepository.findAll();

        view.addObject("filmes", filmes);

        return view;
    }


    @PostMapping
    public ModelAndView save(Filme filme){
        filmeRepository.save(filme);

        return new ModelAndView("redirect:/admin/filmes");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(filmeRepository.exists(id)){

            filmeRepository.delete(id);

            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.noContent().build();
    }

}

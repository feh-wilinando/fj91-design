package br.com.caelum.fj91design.controllers;

import br.com.caelum.fj91design.domains.Sala;
import br.com.caelum.fj91design.repositories.SalaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("admin/salas")
public class AdminSalasController {

    private SalaRepository salaRepository;


    public AdminSalasController(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @GetMapping
    public ModelAndView list(){

        ModelAndView view = new ModelAndView("salas/lista");
        Iterable<Sala> salas = salaRepository.findAll();

        view.addObject("salas", salas);

        return view;

    }


    @GetMapping({"new", "{id}"})
    public ModelAndView form(@PathVariable("id") Optional<Long> optionalId, Sala sala){
        ModelAndView view = new ModelAndView("salas/form");

        sala = optionalId.map(salaRepository::findOne).orElse(sala);

        view.addObject("sala", sala);

        return view;
    }



    @PostMapping
    public ModelAndView save(Sala sala){

        salaRepository.save(sala);

        return new ModelAndView("redirect:/admin/salas");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if (salaRepository.exists(id)) {

            salaRepository.delete(id);

            return ResponseEntity.accepted().build();
        }


        return ResponseEntity.noContent().build();
    }

}

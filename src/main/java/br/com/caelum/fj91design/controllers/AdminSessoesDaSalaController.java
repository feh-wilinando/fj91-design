package br.com.caelum.fj91design.controllers;

import br.com.caelum.fj91design.controllers.forms.SessaoForm;
import br.com.caelum.fj91design.domains.Sala;
import br.com.caelum.fj91design.domains.Sessao;
import br.com.caelum.fj91design.repositories.FilmeRepository;
import br.com.caelum.fj91design.repositories.SalaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin/salas/{id}/sessoes")
class AdminSessoesDaSalaController {

    private final SalaRepository salaRepository;
    private FilmeRepository filmeRepository;

    public AdminSessoesDaSalaController(SalaRepository salaRepository, FilmeRepository filmeRepository) {
        this.salaRepository = salaRepository;
        this.filmeRepository = filmeRepository;
    }

    @GetMapping
    public ModelAndView sessions(@PathVariable Long id){

        ModelAndView view = new ModelAndView("sessoes/lista");

        Sala sala = salaRepository.findOne(id);

        view.addObject("sala", sala);

        return view;

    }


    @GetMapping("new")
    public ModelAndView form(@PathVariable Long id, SessaoForm form){
        ModelAndView view = new ModelAndView("sessoes/form");


        view.addObject("form", form);
        view.addObject("id", id);
        view.addObject("filmes", filmeRepository.findAll());


        return view;
    }



    @PostMapping
    public ModelAndView save(@PathVariable Long id, SessaoForm form){

        Sala sala = salaRepository.findOne(id);

        Sessao sessao = form.toSessao(sala, filmeRepository);

        sala.add(sessao);

        salaRepository.save(sala);

        return new ModelAndView("redirect:/admin/salas/" + id + "/sessoes");
    }


    @DeleteMapping("{sessaoId}")
    public ResponseEntity<?> remove(@PathVariable Long id, @PathVariable Long sessaoId){

        Sala sala = salaRepository.findOne(id);

        if (sala.getSessoes().removeIf(sessao -> sessao.getId().equals(sessaoId))){
            salaRepository.save(sala);
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.noContent().build();
    }
}
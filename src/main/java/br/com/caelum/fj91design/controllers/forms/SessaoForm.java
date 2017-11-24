package br.com.caelum.fj91design.controllers.forms;

import br.com.caelum.fj91design.domains.Filme;
import br.com.caelum.fj91design.domains.Sala;
import br.com.caelum.fj91design.domains.Sessao;
import br.com.caelum.fj91design.repositories.FilmeRepository;

import java.time.LocalTime;

public class SessaoForm {

    private Long filmeId;
    private LocalTime horario;

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }


    public Sessao toSessao(Sala sala, FilmeRepository filmeRepository){
        Filme filme = filmeRepository.findOne(filmeId);

        return new Sessao(horario, filme, sala);
    }
}

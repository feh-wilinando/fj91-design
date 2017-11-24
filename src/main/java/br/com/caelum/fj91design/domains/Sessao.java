package br.com.caelum.fj91design.domains;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
public class Sessao {

    @Id
    @GeneratedValue
    private Long id;

    private LocalTime horario;

    private BigDecimal preco;

    @ManyToOne
    private Filme filme;


    /**
     * @deprecated frameworks only
     */
    private Sessao() {
    }

    public Sessao(LocalTime horario, Filme filme, Sala sala) {
        this.horario = horario;
        this.filme = filme;
        this.preco = filme.getPreco().add(sala.getPreco());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalTime getTermino(){
        return horario.plus(filme.getDuracao());
    }
}

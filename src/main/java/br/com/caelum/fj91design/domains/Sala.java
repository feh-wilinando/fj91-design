package br.com.caelum.fj91design.domains;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @NumberFormat(pattern = "###,###,###.##")
    private BigDecimal preco;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Sessao> sessoes = new ArrayList<>();

    /**
     * @deprecated frameworks only
     */
    private Sala() {
    }

    public Sala(String nome, BigDecimal preco, List<Sessao> sessoes) {
        this.nome = nome;
        this.preco = preco;
        this.sessoes = sessoes;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public void add(Sessao sessao) {
        sessoes.add(sessao);
    }
}

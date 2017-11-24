package br.com.caelum.fj91design.domains;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Duration;

@Entity
public class Filme {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Duration duracao;
    @NumberFormat(pattern = "###,###,###.##")
    private BigDecimal preco;


    /**
     * @deprecated frameworks only
     */
    private Filme() {
    }


    public Filme(String nome, Duration duracao, BigDecimal preco) {
        this.nome = nome;
        this.duracao = duracao;
        this.preco = preco;
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

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", preco=" + preco +
                '}';
    }
}

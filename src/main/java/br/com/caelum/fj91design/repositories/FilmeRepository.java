package br.com.caelum.fj91design.repositories;

import br.com.caelum.fj91design.domains.Filme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface FilmeRepository extends Repository<Filme, Long>{

    void save(Filme filme);

    Iterable<Filme> findAll();

    Filme findOne(Long id);

    boolean exists(Long id);

    void delete(Long id);

    @Query("select s.filme from Sessao s")
    List<Filme> findAllOpenSession();

}

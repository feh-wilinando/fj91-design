package br.com.caelum.fj91design.repositories;

import br.com.caelum.fj91design.domains.Sala;
import org.springframework.data.repository.Repository;

public interface SalaRepository extends Repository<Sala, Long>{
    Iterable<Sala> findAll();

    void save(Sala sala);

    void delete(Long id);

    boolean exists(Long id);

    Sala findOne(Long id);
}

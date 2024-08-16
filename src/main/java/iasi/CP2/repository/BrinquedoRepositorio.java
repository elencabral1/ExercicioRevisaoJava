package iasi.CP2.repository;

import iasi.CP2.model.Brinquedo;
import java.util.List;

public interface BrinquedoRepositorio {
    int save(Brinquedo brinquedo);

    int update(Brinquedo book);

    Brinquedo findById(Long id);

    int deleteById(Long id);

    List<Brinquedo> findAll();

    List<Brinquedo> findByNameContaining(String nome);

    int deleteAll();
}


package com.mcService.microService.ripo;

import com.mcService.microService.model.Prodotti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryFace extends JpaRepository<Prodotti,Long> {

   Optional<Prodotti>  getProductById(Long id);

    @Override
    <S extends Prodotti> S save(S prodotti);

    // Non hai bisogno di un metodo per aggiornare un prodotto, usa save
    @Override
    <S extends Prodotti> S saveAndFlush(S prodotti);
}

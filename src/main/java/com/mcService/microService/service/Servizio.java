package com.mcService.microService.service;


import com.mcService.microService.model.Prodotti;
import com.mcService.microService.ripo.RepositoryFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;


@Service
public class Servizio {
    private final RepositoryFace repositoryFace;

    public Servizio(RepositoryFace repositoryFace) {
        this.repositoryFace = repositoryFace;
    }


    public List<Prodotti> search() {
        return repositoryFace.findAll();
    }

    public Optional<Prodotti> searchOne(@PathVariable Long id) {
        return repositoryFace.findById(id);
    }

    public Prodotti create(@RequestBody Prodotti prodotti) {
        return repositoryFace.save(prodotti);
    }


    public ResponseEntity<Prodotti> modifie(@PathVariable long id, @RequestBody Prodotti prodotti) {
        // Trova l'oggetto da modificare
        Optional<Prodotti> existingProdotti = repositoryFace.findById(id);

        // Verifica se l'oggetto esiste
        if (existingProdotti.isPresent()) {

            Prodotti prdottoToChange = existingProdotti.get();
            prdottoToChange.setName(prodotti.getName());
            prdottoToChange.setPrice(prodotti.getPrice());
            repositoryFace.save(prdottoToChange);


            return ResponseEntity.ok(prdottoToChange);
        } else {

            return ResponseEntity.notFound().build();
        }
    }


    public void Delete(@PathVariable Long id) {
        repositoryFace.deleteById(id);
    }
}

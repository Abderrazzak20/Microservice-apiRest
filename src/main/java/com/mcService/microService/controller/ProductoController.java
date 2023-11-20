package com.mcService.microService.controller;

import com.mcService.microService.model.Prodotti;
import com.mcService.microService.service.Servizio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scemo")
public class ProductoController {
    @Autowired
    private Servizio riposi;


    @GetMapping("")
    public List<Prodotti> find() {
        return riposi.search();
    }

    @GetMapping("/{id}")
    public Optional<Prodotti> findOne(@PathVariable Long id) {
        return riposi.searchOne(id);
    }

    @PostMapping("")
    public Prodotti NewP(@RequestBody Prodotti prodotti) {
        return riposi.create(prodotti);
    }


    @PutMapping("/{id}")
    public Prodotti edit(@PathVariable Long id, @RequestBody Prodotti prodotti) {
        return riposi.modifie(id, prodotti).getBody();
    }

    @DeleteMapping("/{id}")
    public void Suprrime(@PathVariable Long id){
         riposi.Delete(id);
    }

}

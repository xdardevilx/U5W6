package valerio.U5W6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import valerio.U5W6.entity.Dipendente;
import valerio.U5W6.payloads.DipendenteDTO;
import valerio.U5W6.services.DipendenteService;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

   //  1. - POST http://localhost:3001/dipendenti (+ req.body) 1. - POST http://localhost:3001/blogs (+ req.body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)

    public DipendenteDTO save ( @Validated @RequestBody DipendenteDTO newDipendenteDTO){
        return dipendenteService.save(newDipendenteDTO);
    }

    // 2. - GET http://localhost:3001/dipendenti
    @GetMapping("")
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sort) {
        return dipendenteService.getAllDipendenti(page, size, sort);
    }

    //
}

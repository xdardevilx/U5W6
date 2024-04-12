package valerio.U5W6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import valerio.U5W6.entity.Dipendente;
import valerio.U5W6.payloads.DipendenteDTO;
import valerio.U5W6.services.DipendenteService;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

   //  1. - POST http://localhost:3001/dipendenti (+ req.body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)

    public DipendenteDTO save (  @RequestBody @Validated DipendenteDTO newDipendenteDTO){
        return dipendenteService.save(newDipendenteDTO);
    }

    // 2. - GET http://localhost:3001/dipendenti
    @GetMapping("")
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sort) {
        return dipendenteService.getAllDipendenti(page, size, sort);
    }

    // 3. - GET http://localhost:3001/dipendente/{id}
    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable int dipendenteId) throws Exception {
        return dipendenteService.findById(dipendenteId);
    }


    // 4. - PUT http://localhost:3001/dipendente/{id} (+ req.body)
    @PutMapping("/{authorId}")
    public DipendenteDTO findAndUpdate(@PathVariable int dipendenteId, @RequestBody DipendenteDTO body) throws Exception {
        return dipendenteService.findByIdAndUpdate(dipendenteId, body);
    }


    // 5. - DELETE http://localhost:3001/dipendente/{id}

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int authorId) {
        dipendenteService.findByIdAndDelete(authorId);
    }

    // 6. - POST http://localhost:3001/dipendenti/uploadImg/dipendenteId (+ req.body)

    @PostMapping("/uploadImg/{dipendenteId}")
    public Dipendente uploadImg(@RequestParam("pImg") MultipartFile img, @PathVariable int dipendenteId) throws Exception {
        return dipendenteService.findByIdAndUploadImg(dipendenteId, img );

    }

}

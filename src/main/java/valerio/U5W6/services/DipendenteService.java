package valerio.U5W6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import valerio.U5W6.entity.Dipendente;
import valerio.U5W6.payloads.DipendenteDTO;
import valerio.U5W6.repositories.DipendenteDAO;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteDAO dipendenteDAO;

    public DipendenteDTO save (DipendenteDTO newDipendenteDTO){
        Dipendente newDipendente = new Dipendente(newDipendenteDTO.name(),
                newDipendenteDTO.surname(),
                newDipendenteDTO.username(),
                newDipendenteDTO.email(),
                newDipendenteDTO.profileImg());
        dipendenteDAO.save(newDipendente);
        return newDipendenteDTO;

    }

    public Page<Dipendente> getAllDipendenti(int page, int size, String sortBy){
        if(size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.dipendenteDAO.findAll(pageable);
    }

    public Dipendente findById(int postId) {
        return this.dipendenteDAO.findById(postId).orElseThrow(() -> new NotFoundException(postId));
    }

    public void findByIdAndDelete(int id) {
        Dipendente found = this.findById(id);
        this.dipendenteDAO.delete(found);
    }

    public DipendenteDTO findByIdAndUpdate(int id, DipendenteDTO body) {
        Dipendente found = this.findById(id);
        found.setName(body.name());
        found.setSurname(body.surname());
        found.setUsername(body.username());
        found.setEmail(body.email());
        found.setProfileImage(body.profileImg());
        this.dipendenteDAO.save(found);
        return body;

    }


}

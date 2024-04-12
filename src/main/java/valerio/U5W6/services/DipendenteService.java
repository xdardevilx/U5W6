package valerio.U5W6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valerio.U5W6.entity.Dipendente;
import valerio.U5W6.payloads.DipendenteDTO;
import valerio.U5W6.repositories.DipendentiDAO;

@Service
public class DipendenteService {

    @Autowired
    private DipendentiDAO dipendentiDAO;

    public DipendenteDTO save (DipendenteDTO newDipendenteDTO){
        Dipendente newDipendente = new Dipendente(newDipendenteDTO.name(),
                newDipendenteDTO.surname(),
                newDipendenteDTO.username(),
                newDipendenteDTO.email(),
                newDipendenteDTO.profileImg());

    }

}

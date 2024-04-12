package valerio.U5W6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import valerio.U5W6.entity.Dispositivo;
import valerio.U5W6.payloads.DispositivoDTO;
import valerio.U5W6.repositories.DispositivoDAO;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoDAO dispositivoDAO;


    public Page<Dispositivo> getDispositivi(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dispositivoDAO.findAll(pageable);
    }

    public DispositivoDTO save(DispositivoDTO newDispositivoDTO) {
        Dispositivo dispositivo = new Dispositivo(newDispositivoDTO.tipologia(), newDispositivoDTO.stato());
        dispositivoDAO.save(dispositivo);


        return newDispositivoDTO;
    }

}

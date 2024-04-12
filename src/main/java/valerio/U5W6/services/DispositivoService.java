package valerio.U5W6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valerio.U5W6.entity.Dispositivo;
import valerio.U5W6.payloads.DispositivoDTO;
import valerio.U5W6.repositories.DispositivoDAO;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoDAO dispositivoDAO;

    public DispositivoDTO save(DispositivoDTO newDispositivoDTO) {
        Dispositivo dispositivo = new Dispositivo(newDispositivoDTO.tipologia(), newDispositivoDTO.stato());
        dispositivoDAO.save(dispositivo);


        return newDispositivoDTO;
    }

}

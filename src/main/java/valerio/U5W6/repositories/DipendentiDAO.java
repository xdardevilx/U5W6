package valerio.U5W6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import valerio.U5W6.entity.Dipendente;

import java.util.Optional;

public interface DipendentiDAO extends JpaRepository<Dipendente, Long> {
    boolean existsByEmail(String email);

    Optional<Dipendente> findByEmail(String email);
}

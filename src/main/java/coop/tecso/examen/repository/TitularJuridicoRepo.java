package coop.tecso.examen.repository;

import coop.tecso.examen.model.TitularJuridico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitularJuridicoRepo extends JpaRepository<TitularJuridico,Long> {
    Optional<TitularJuridico> findByCuit(String cuitObteined);
}

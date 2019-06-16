package coop.tecso.examen.repository;


import coop.tecso.examen.model.TitularFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitularFisicoRepo extends JpaRepository<TitularFisico, Long> {

    Optional<TitularFisico> findByCuit(String cuitObteined);
}

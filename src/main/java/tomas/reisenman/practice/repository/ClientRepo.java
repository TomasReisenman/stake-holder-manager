package tomas.reisenman.practice.repository;

import tomas.reisenman.practice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client,Long> {
    Optional<Client> findByContactEmail(String cuitObteined);
}

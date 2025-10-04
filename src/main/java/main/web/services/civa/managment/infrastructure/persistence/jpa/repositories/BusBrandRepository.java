package main.web.services.civa.managment.infrastructure.persistence.jpa.repositories;

import main.web.services.civa.managment.domain.model.entities.BusBrand;
import main.web.services.civa.managment.domain.model.valueobjects.BusBrandName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface BusBrandRepository extends JpaRepository<BusBrand, Long> {
    boolean existsByBusBrand(BusBrandName name);
    Optional<BusBrand> findByBusBrand(BusBrandName type);
}

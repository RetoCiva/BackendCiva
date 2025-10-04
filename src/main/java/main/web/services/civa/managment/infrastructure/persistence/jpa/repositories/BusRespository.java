package main.web.services.civa.managment.infrastructure.persistence.jpa.repositories;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import main.web.services.civa.managment.domain.model.aggregates.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BusRespository - Represents the repository of the bus.
 *
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Repository
public interface BusRespository extends JpaRepository<Bus, Long> {
    boolean existsByPlateNumber(String plateNumber);
}

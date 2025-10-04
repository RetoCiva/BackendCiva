package main.web.services.civa.managment.application.internal.queryservices;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import main.web.services.civa.managment.domain.model.aggregates.Bus;
import main.web.services.civa.managment.domain.model.queries.GetBusById;
import main.web.services.civa.managment.domain.model.queries.GetByBusBrandName;
import main.web.services.civa.managment.domain.model.queries.GetByPlateNumber;
import main.web.services.civa.managment.domain.services.BusCommandService;
import main.web.services.civa.managment.domain.services.BusQueryService;
import main.web.services.civa.managment.infrastructure.persistence.jpa.repositories.BusRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class BusQueryServiceImpl implements BusQueryService {

    private final BusRepository busRepository;
    public BusQueryServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Optional<Bus> handle(GetBusById query) {
        return this.busRepository.findById(query.busId());
    }

    @Override
    public Optional<Bus> handle(GetByBusBrandName query) {
        return Optional.empty();
    }

    @Override
    public Optional<Bus> handle(GetByPlateNumber query) {
        return Optional.empty();
    }
}

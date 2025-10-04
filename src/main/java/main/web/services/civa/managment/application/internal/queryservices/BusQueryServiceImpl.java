package main.web.services.civa.managment.application.internal.queryservices;
import main.web.services.civa.managment.domain.model.aggregates.Bus;
import main.web.services.civa.managment.domain.model.queries.GetAllBusesQuery;
import main.web.services.civa.managment.domain.model.queries.GetBusById;
import main.web.services.civa.managment.domain.model.queries.GetByBusBrandName;
import main.web.services.civa.managment.domain.model.queries.GetByPlateNumber;
import main.web.services.civa.managment.domain.services.BusQueryService;
import main.web.services.civa.managment.infrastructure.persistence.jpa.repositories.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * BusQueryServiceImpl - Represents the implementation of the bus query service.
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

    @Override
    public List<Bus> handle(GetAllBusesQuery getAllBuses) {
        return List.of();
    }
}

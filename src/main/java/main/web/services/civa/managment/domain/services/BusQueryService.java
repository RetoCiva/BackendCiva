package main.web.services.civa.managment.domain.services;

import main.web.services.civa.managment.domain.model.aggregates.Bus;
import main.web.services.civa.managment.domain.model.queries.GetAllBusesQuery;
import main.web.services.civa.managment.domain.model.queries.GetBusById;
import main.web.services.civa.managment.domain.model.queries.GetByBusBrandName;
import main.web.services.civa.managment.domain.model.queries.GetByPlateNumber;

import java.util.List;
import java.util.Optional;

/**
 * BusQueryService interface for handling bus-related queries.
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface BusQueryService {
    Optional<Bus> handle(GetBusById query);
    Optional<Bus> handle(GetByBusBrandName query);
    Optional<Bus> handle(GetByPlateNumber query);
    List<Bus> handle(GetAllBusesQuery getAllBuses);
}

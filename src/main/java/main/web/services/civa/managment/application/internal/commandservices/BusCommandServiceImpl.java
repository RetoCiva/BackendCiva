package main.web.services.civa.managment.application.internal.commandservices;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import main.web.services.civa.managment.domain.exceptions.BusBrandNotFoundException;
import main.web.services.civa.managment.domain.model.aggregates.Bus;
import main.web.services.civa.managment.domain.model.commands.CreateBusCommand;
import main.web.services.civa.managment.domain.model.entities.BusBrand;
import main.web.services.civa.managment.domain.model.valueobjects.BusBrandName;
import main.web.services.civa.managment.domain.services.BusCommandService;
import main.web.services.civa.managment.infrastructure.persistence.jpa.repositories.BusBrandRepository;
import main.web.services.civa.managment.infrastructure.persistence.jpa.repositories.BusRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * BusCommandServiceImpl - Represents the implementation of the bus command service.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class BusCommandServiceImpl implements BusCommandService {
    private final BusRepository busRepository;
    private final BusBrandRepository busBrandRepository;

    public BusCommandServiceImpl(BusRepository busRepository, BusBrandRepository busBrandRepository) {
        this.busRepository = busRepository;
        this.busBrandRepository = busBrandRepository;
    }

    @Override
    public Long handle(CreateBusCommand command) {
        BusBrandName brandName;
        try {
            brandName = BusBrandName.valueOf(command.busBrand());
        } catch (IllegalArgumentException e) {
            throw new BusBrandNotFoundException(command.busBrand());
        }

        Optional<BusBrand> optionalEquipmentType = busBrandRepository.findByBusBrand(brandName);
        BusBrand equipmentType = optionalEquipmentType.orElseThrow(() -> new BusBrandNotFoundException(command.busBrand()));

        Bus equipment = new Bus(command, equipmentType);
        try {
            busRepository.save(equipment);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving bus", e);
        }
        return equipment.getId();
    }
}

package main.web.services.civa.managment.application.internal.commandservices;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import main.web.services.civa.managment.domain.model.commands.SeedBusBrandCommmand;
import main.web.services.civa.managment.domain.model.entities.BusBrand;
import main.web.services.civa.managment.domain.model.valueobjects.BusBrandName;
import main.web.services.civa.managment.domain.services.BusBrandCommandService;
import main.web.services.civa.managment.infrastructure.persistence.jpa.repositories.BusBrandRepository;
import org.springframework.stereotype.Service;

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class BusBrandCommandServiceImpl implements BusBrandCommandService {

    private final BusBrandRepository busBrandRepository;

    public BusBrandCommandServiceImpl(BusBrandRepository busBrandRepository) {
        this.busBrandRepository = busBrandRepository;
    }

    @Override
    public Long handle(SeedBusBrandCommmand command) {
        BusBrandName[] deviceTypeNames = BusBrandName.values();
        Long lastId = null;

        for (BusBrandName busBrandName : deviceTypeNames) {
            if (!busBrandRepository.existsByBusBrand(busBrandName)) {
                var deviceType = new BusBrand(busBrandName);
                busBrandRepository.save(deviceType);
                lastId = deviceType.getId();
            }
        }
        return lastId;
    }

}

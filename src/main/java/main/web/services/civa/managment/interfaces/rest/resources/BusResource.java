package main.web.services.civa.managment.interfaces.rest.resources;

import main.web.services.civa.managment.domain.model.entities.BusBrand;
import main.web.services.civa.managment.domain.model.valueobjects.Characteristics;
import main.web.services.civa.managment.domain.model.valueobjects.Plate;
import main.web.services.civa.managment.domain.model.valueobjects.Status;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record BusResource(
        Long busId,
        Long busNumber,
        String characteristics,
        String plate,
        Long status,
        String busBrandName
) {

}

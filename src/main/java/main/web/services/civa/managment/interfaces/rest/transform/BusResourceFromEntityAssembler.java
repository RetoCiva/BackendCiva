package main.web.services.civa.managment.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import main.web.services.civa.managment.domain.model.aggregates.Bus;
import main.web.services.civa.managment.interfaces.rest.resources.BusResource;

/**
 * BusResourceFromEntityAssembler - Assembles BusResource from Bus entity.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class BusResourceFromEntityAssembler {
    public static BusResource toResourceFromEntity(Bus entity) {
        return new BusResource(
                entity.getId(),
                entity.getBusNumber(),
                entity.getCharacteristics(),
                entity.getPlate(),
                entity.getStatus(),
                entity.getBusBrand()
        );
    }
}

package main.web.services.civa.managment.interfaces.rest.transform;

import main.web.services.civa.managment.domain.model.commands.CreateBusCommand;
import main.web.services.civa.managment.interfaces.rest.resources.CreateBusResource;

/**
 * CreateBusCommandFromResourceAssembler - Assembler to create a command from a resource.
 *
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public class CreateBusCommandFromResourceAssembler {
    public static CreateBusCommand toCommandFromResource(CreateBusResource resource) {
        return new CreateBusCommand(
                resource.busNumber(),
                resource.characteristics(),
                resource.plate(),
                resource.status()
        );
    }
}

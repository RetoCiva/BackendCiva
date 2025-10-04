package main.web.services.civa.managment.domain.model.commands;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

/**
 * CreateBusCommand - Command to create a bus.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record CreateBusCommand(
        Long busNumber,
        String characteristics,
        String plate,
        Long status,
        String busBrand
) {
}

package main.web.services.civa.managment.domain.model.commands;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record CreateBusBrandCommand(
        Long busNumber,
        String characteristics,
        String plate,
        Long status
) {
}

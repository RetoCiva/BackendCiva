package main.web.services.civa.managment.interfaces.rest.resources;

/**
 * This class is a resource class that will be used to create a bus.
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record CreateBusResource(
        Long busNumber,
        String characteristics,
        String plate,
        Long status,
        String busTypeName
) {
}

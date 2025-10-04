package main.web.services.civa.managment.domain.model.valueobjects;

/**
 * BusNumber - Value object representing a bus number.
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record BusNumber(Long busNumber) {
     public BusNumber(Long busNumber) {
        if (busNumber == null || busNumber <= 0) {
            throw new IllegalArgumentException("Bus number must be a positive number.");
        }
        this.busNumber = busNumber;
     }
}

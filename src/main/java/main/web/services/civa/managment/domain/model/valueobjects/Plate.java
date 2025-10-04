package main.web.services.civa.managment.domain.model.valueobjects;

/**
 * Value object representing a vehicle's license plate.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record Plate(String plate) {
    public Plate {
        if (plate == null || plate.isBlank()) {
            throw new IllegalArgumentException("Plate cannot be null or empty.");
        }
        if (!plate.matches("^[A-Z]{3}[0-9]{3}$")) {
            throw new IllegalArgumentException("Invalid plate format. Expected format: ABC123");
        }
    }
}

package main.web.services.civa.managment.domain.model.valueobjects;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

/**
 * Descripción de la clase.
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

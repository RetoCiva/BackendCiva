package main.web.services.civa.managment.domain.model.valueobjects;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

/**
 * Characteristics - Value object representing characteristics of a bus.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record Characteristics(String characteristics) {
    public Characteristics {
        if (characteristics == null || characteristics.isBlank()) {
            throw new IllegalArgumentException("Characteristics cannot be null or empty.");
        }
    }
}

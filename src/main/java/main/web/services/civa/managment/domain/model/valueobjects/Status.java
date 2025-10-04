package main.web.services.civa.managment.domain.model.valueobjects;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record Status(Long status) {
    public Status {
        if (status == null || status < 0 || status > 1) {
            throw new IllegalArgumentException("Status must be 0 or 1");
        }
    }
}

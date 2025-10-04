package main.web.services.civa.managment.domain.exceptions;

/**
 * BusBrandNotFoundException - Exception thrown when a bus brand is not found.
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public class BusBrandNotFoundException extends RuntimeException {
    public BusBrandNotFoundException(String aLong) {
        super("Bus Brand with id " + aLong + " not found");
    }
}

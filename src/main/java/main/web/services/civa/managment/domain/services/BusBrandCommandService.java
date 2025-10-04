package main.web.services.civa.managment.domain.services;

import main.web.services.civa.managment.domain.model.commands.SeedBusBrandCommmand;

/**
 * BusBrandCommandService - Service interface for handling bus brand commands.
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface BusBrandCommandService {
    Long handle(SeedBusBrandCommmand command);
}

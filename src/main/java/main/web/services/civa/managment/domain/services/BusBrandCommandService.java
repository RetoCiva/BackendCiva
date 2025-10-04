package main.web.services.civa.managment.domain.services;

import main.web.services.civa.managment.domain.model.commands.SeedBusBrandCommmand;
import org.springframework.stereotype.Service;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface BusBrandCommandService {
    Long handle(SeedBusBrandCommmand command);
}

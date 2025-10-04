package main.web.services.civa.managment.domain.services;

import main.web.services.civa.managment.domain.model.commands.CreateBusCommand;

import javax.swing.*;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface BusCommandService {
    Long handle(CreateBusCommand command);
}

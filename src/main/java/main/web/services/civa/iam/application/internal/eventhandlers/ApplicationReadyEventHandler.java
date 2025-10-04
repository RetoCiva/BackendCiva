package main.web.services.civa.iam.application.internal.eventhandlers;

import main.web.services.civa.iam.domain.model.commands.SeedRolesCommand;
import main.web.services.civa.iam.domain.services.RoleCommandService;
import main.web.services.civa.managment.domain.model.commands.SeedBusBrandCommmand;
import main.web.services.civa.managment.domain.services.BusBrandCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Event handler for the application ready event.
 *
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Component
public class ApplicationReadyEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    private final RoleCommandService roleCommandService;
    private final BusBrandCommandService busBrandCommandService;

    public ApplicationReadyEventHandler(RoleCommandService roleCommandService,
                                        BusBrandCommandService busBrandCommandService) {
        this.roleCommandService = roleCommandService;
        this.busBrandCommandService = busBrandCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();

        // Seed Roles
        LOGGER.info("Starting to verify if roles seeding is needed for {} at {}", applicationName, currentTimestamp());
        roleCommandService.handle(new SeedRolesCommand());
        LOGGER.info("Roles seeding verification finished for {} at {}", applicationName, currentTimestamp());

        // Seed Bus Brands
        LOGGER.info("Starting to verify if bus brand seeding is needed for {} at {}", applicationName, currentTimestamp());
        busBrandCommandService.handle(new SeedBusBrandCommmand());
        LOGGER.info("Bus brand seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}

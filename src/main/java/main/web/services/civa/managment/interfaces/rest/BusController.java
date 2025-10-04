package main.web.services.civa.managment.interfaces.rest;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import io.swagger.v3.oas.annotations.tags.Tag;
import main.web.services.civa.managment.domain.services.BusCommandService;
import main.web.services.civa.managment.domain.services.BusQueryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */
@RestController
@RequestMapping(value = "api/v1/bus", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Civa Bus", description = "Civa Management Endpoints")
public class BusController {

    private final BusCommandService busCommandService;
    private final BusQueryService busQueryService;

    public BusController(BusCommandService busCommandService, BusQueryService busQueryService) {
        this.busCommandService = busCommandService;
        this.busQueryService = busQueryService;
    }


}

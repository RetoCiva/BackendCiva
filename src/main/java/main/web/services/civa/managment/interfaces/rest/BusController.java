package main.web.services.civa.managment.interfaces.rest;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import main.web.services.civa.iam.domain.model.queries.GetAllUsersQuery;
import main.web.services.civa.managment.domain.model.aggregates.Bus;
import main.web.services.civa.managment.domain.model.queries.GetAllBusesQuery;
import main.web.services.civa.managment.domain.model.queries.GetBusById;
import main.web.services.civa.managment.domain.services.BusCommandService;
import main.web.services.civa.managment.domain.services.BusQueryService;
import main.web.services.civa.managment.interfaces.rest.resources.BusResource;
import main.web.services.civa.managment.interfaces.rest.resources.CreateBusResource;
import main.web.services.civa.managment.interfaces.rest.transform.BusResourceFromEntityAssembler;
import main.web.services.civa.managment.interfaces.rest.transform.CreateBusCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bus Controller - This class represents the REST controller for the Bus entity.
 *
 * @author Fiorella Jarama Peñaloza
 */
@CrossOrigin(
        origins = "http://localhost:5173",
        allowedHeaders = {"Authorization","Content-Type"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS}
)
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

    /**
     * This method creates a bus.
     * @param res
     * @return ResponseEntity<BusResource>
     */
    @PostMapping
    public ResponseEntity<BusResource> createBus(@RequestBody CreateBusResource res) {
        var createBusCommand = CreateBusCommandFromResourceAssembler.toCommandFromResource(res);
        var busId = busCommandService.handle(createBusCommand);
        if (busId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getBusByIdQuery = new GetBusById(busId);
        var bus = busQueryService.handle(getBusByIdQuery);
        if (bus.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var animalResource = BusResourceFromEntityAssembler.toResourceFromEntity(bus.get());
        return new ResponseEntity<>(animalResource, HttpStatus.CREATED);
    }

    /**
     * GET /api/v1/bus
     * Returns all buses.
     */
    @Operation(summary = "OGet all buses",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Datos obtenidos exitosamente")
            })
    @GetMapping
    public ResponseEntity<List<BusResource>> getAllSensorData() {
        List<Bus> sensorDataList = busQueryService.handle(new GetAllBusesQuery());
        List<BusResource> resources = sensorDataList.stream()
                .map(BusResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    /**
     * GET /api/v1/bus/{id}
     * Returns a specific bus by its ID.
     */
    @Operation(summary = "Get bus by ID", description = "Returns detailed information of a specific bus")
    @GetMapping("/{id}")
    public ResponseEntity<BusResource> getBusById(@PathVariable Long id) {
        var getBusByIdQuery = new GetBusById(id);
        var busOptional = busQueryService.handle(getBusByIdQuery);

        return busOptional
                .map(bus -> ResponseEntity.ok(BusResourceFromEntityAssembler.toResourceFromEntity(bus)))
                .orElse(ResponseEntity.notFound().build());
    }



}

package main.web.services.civa.managment.domain.model.aggregates;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import main.web.services.civa.managment.domain.model.commands.CreateBusCommand;
import main.web.services.civa.managment.domain.model.entities.BusBrand;
import main.web.services.civa.managment.domain.model.valueobjects.BusNumber;
import main.web.services.civa.managment.domain.model.valueobjects.Characteristics;
import main.web.services.civa.managment.domain.model.valueobjects.Plate;
import main.web.services.civa.managment.domain.model.valueobjects.Status;
import main.web.services.civa.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */

@Getter
@Setter
@Entity
public class Bus extends AuditableAbstractAggregateRoot<Bus> {

    @Embedded
    private BusNumber busNumber;

    @Embedded
    private Characteristics characteristics;

    @Embedded
    private Plate plate;

    @Embedded
    private Status status;

    @ManyToOne
    @JoinColumn(name = "busBrand_id")
    private BusBrand busBrand;

    public Bus() {
    }

    public Bus(BusNumber busNumber, Characteristics characteristics, Plate plate, Status status, BusBrand busBrand) {
        this.busNumber = busNumber;
        this.characteristics = characteristics;
        this.plate = plate;
        this.status = status;
        this.busBrand = busBrand;
    }

    public Bus (CreateBusCommand command, BusBrand busBrand) {
        this.busNumber = new BusNumber(command.busNumber());
        this.characteristics = new Characteristics(command.characteristics());
        this.plate = new Plate(command.plate());
        this.status = new Status(command.status());
        this.busBrand = busBrand;
    }

    //getters
    public Long getBusId() {
        return super.getId();
    }

    public Long getBusNumber() {
        return busNumber.busNumber();
    }

    public String getCharacteristics() {
        return characteristics.characteristics();
    }

    public String getPlate() {
        return plate.plate();
    }

    public Long getStatus() {
        return status.status();
    }

    public String getBusBrand() {
        return busBrand.getBrand().name();
    }
}

package main.web.services.civa.managment.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import main.web.services.civa.managment.domain.model.valueobjects.BusBrandName;

/**
 * BusBrand - Represents the brand of a bus.
 * @author Fiorella Jarama Peñaloza
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class BusBrand {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BusBrandName brand;

    public BusBrand(BusBrandName brand) {
        this.brand = brand;
    }
}

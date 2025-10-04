package main.web.services.civa.managment.domain.model.entities;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import main.web.services.civa.managment.domain.model.valueobjects.BusBrandName;

/**
 * Descripción de la clase.
 *
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
    private BusBrandName busBrand;

    public BusBrand(BusBrandName busBrand) {
            this.busBrand = busBrand;
    }
}

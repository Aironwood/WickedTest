package PropertyManager.manager;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;
import java.util.Calendar;

/**
 * Created by Jozef Živčic on 10. 3. 2015.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property implements Serializable {
    private Long id;
    private String addressStreet;
    private String addressTown;
    private BigDecimal price;
    private String typeOfBuilding;
    private int squareMeters;
    private LocalDate dateOfBuild;
    private String description;

    /*public Property() {

    }
    public Property(Long id, String addressStreet, String addressTown, BigDecimal price, String type, int squareMeters, LocalDate dateOfBuild, String description) {
        this.id = id;
        this.addressStreet = addressStreet;
        this.addressTown = addressTown;
        this.price = price;
        this.typeOfBuilding = type;
        this.squareMeters = squareMeters;
        this.dateOfBuild = dateOfBuild;
        this.description = description;
    }

    public Property(String addressStreet, String addressTown, BigDecimal price, String type, int squareMeters, LocalDate dateOfBuild, String description) {
        this.addressStreet = addressStreet;
        this.addressTown = addressTown;
        this.price = price;
        this.typeOfBuilding = type;
        this.squareMeters = squareMeters;
        this.dateOfBuild = dateOfBuild;
        this.description = description;
    }
  
    @Override
    public String toString() {
        return addressStreet + ",  " + addressTown;
    }*/
}

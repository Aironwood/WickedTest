package PropertyManager.manager;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.*;

/**
 * Created by Jan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private LocalDate born;
    private PhoneNumber phoneNumber;
    private String addressStreet;
    private String addressTown;

}

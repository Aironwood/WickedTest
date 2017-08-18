package PropertyManager.manager;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.wicket.validation.ValidationError;

/**
 *
 * @author jan.jarabinec
 */
@Data
@NoArgsConstructor
public class PhoneNumber implements Serializable {
    private String prefix;
    private String bodyNumber;
    
    public PhoneNumber(String rawFormat)
    {
        prefix = rawFormat.substring(0, 4);
        bodyNumber = rawFormat.substring(4);
    }
    
    @Override
    public String toString()
    {
        return prefix + bodyNumber;
    }
}

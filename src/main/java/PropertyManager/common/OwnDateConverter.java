package PropertyManager.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

/**
 *
 * @author jan.jarabinec
 */
public class OwnDateConverter implements IConverter<LocalDate> {


    @Override
    public LocalDate convertToObject(String string, Locale locale) throws ConversionException {
        LocalDate localDate = LocalDate.parse(string, DateTimeFormatter.ISO_LOCAL_DATE);
        return localDate;
    }

    @Override
    public String convertToString(LocalDate c, Locale locale) {
        String formattedString = ((LocalDate)c).format(DateTimeFormatter.ISO_LOCAL_DATE);
        return formattedString;
    }

    
    
    
}

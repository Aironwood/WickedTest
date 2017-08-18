package PropertyManager.common;

import PropertyManager.manager.PhoneNumber;
import java.util.Locale;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

/**
 *
 * @author jan.jarabinec
 */
public class PhoneNumberConverter implements IConverter {

    @Override
    public Object convertToObject(String rawFormat, Locale locale) throws ConversionException, IllegalArgumentException {
        PhoneNumber number = new PhoneNumber(rawFormat);
        return number;
    }

    @Override
    public String convertToString(Object number, Locale locale) {
        PhoneNumber phoneNumber = (PhoneNumber)number;
        return phoneNumber.toString();
    }

}

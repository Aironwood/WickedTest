package com.mycompany.OwnerPage;

import java.io.Serializable;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.joda.time.LocalDate;
import org.apache.wicket.validation.ValidationError;

/**
 *
 * @author jan.jarabinec
 */
public final class NameValidator implements IValidator<String>, Serializable {

    private final int max;
    private final int min;
    private final String propName;
    public NameValidator(int min, int max, String propname){
        this.max = max;
        this.min = min;
        this.propName = propname;
    }
    
    @Override
    public void validate(IValidatable<String> iv) {
        String valiable = iv.getValue();
        if (valiable.length() > max || valiable.length() < min) {
            ValidationError error = new ValidationError();
            error.setMessage( propName + " moze mať dĺžku maximálne "+ max +" znakov a minimálne "+ min +" znakov");
            iv.error(error);

        }

    }

}

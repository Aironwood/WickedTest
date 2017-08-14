package com.mycompany.OwnerPage;

import java.io.Serializable;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import java.util.regex.*;
import org.apache.wicket.validation.ValidationError;

/**
 *
 * @author jan.jarabinec
 */
public class PhoneValidator implements IValidator<String>, Serializable {

    @Override
    public void validate(IValidatable<String> iv) {
        String rawPhone = iv.getValue();
        
        if(!rawPhone.matches("(^\\+[0-9]{3})([0-9]{9}$)"))
        {
            ValidationError error = new ValidationError();
            error.setMessage("Zlý formát telefónneho čísla. Príklad správneho čísla: +421263678954");
            iv.error(error);
        }
    }
    
}

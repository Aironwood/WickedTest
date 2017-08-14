/*
 * Copyright 2017 jan.jarabinec.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

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
package PropertyManager.common;

import PropertyManager.manager.PhoneNumber;
import java.util.Locale;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

/**
 *
 * @author jan.jarabinec
 */
public class PhoneNumberConverter implements IConverter<PhoneNumber> {

    @Override
    public PhoneNumber convertToObject(String rawFormat, Locale locale) throws ConversionException, IllegalArgumentException {
        PhoneNumber number = new PhoneNumber(rawFormat);
        return number;
    }

    @Override
    public String convertToString(PhoneNumber number, Locale locale) {
        return number.toString();
    }

}

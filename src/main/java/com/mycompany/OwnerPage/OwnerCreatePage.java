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

import PropertyManager.common.AppCommons;
import PropertyManager.manager.Owner;
import PropertyManager.manager.OwnerManager;
import com.mycompany.BasePage;
import com.mycompany.PropertyPage.PropertyPage;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author jan.jarabinec
 */
public class OwnerCreatePage extends BasePage {
    private final Owner owner = new Owner();

    public OwnerCreatePage()
    {
        Form form = new Form("form"){};
        //Date dateProp = new Date();
        form.add(new TextField<String>("nameProperty", new PropertyModel<String>(owner, "name")).setRequired(true));
        form.add(new TextField<String>("surnameProperty", new PropertyModel<String>(owner, "surname")).setRequired(true));
        //form.add(new DateField("bornDateProperty", new PropertyModel<>(owner, "born")).setRequired(true));
        form.add(new TextField<String>("phoneNumberProperty", new PropertyModel<String>(owner, "phoneNumber")).setRequired(true));
        form.add(new TextField<String>("addressStreetProperty", new PropertyModel<String>(owner, "addressStreet")).setRequired(true));
        form.add(new TextField<String>("addressTownProperty", new PropertyModel<String>(owner, "addressTown")).setRequired(true));
        Button addButton = new Button("okButton"){
            @Override
            public void onSubmit()
            {
                info("OK butted executed");
                owner.setBorn(LocalDate.now());
                OwnerManager ownerManager = AppCommons.getOwnerManager();
                ownerManager.createOwner(owner);
                setResponsePage(PropertyPage.class);
            }
        };
        form.add(addButton);
        Button cancelButton = new Button("cancelButton"){
            @Override
            public void onSubmit()
            {
                info("Cancel button executed");
                setResponsePage(OwnerPage.class);
            }
            @Override
            public void onError()
            {
                info("Cancel button executed");
                setResponsePage(OwnerPage.class);
            }
        };

        form.add(cancelButton);
        add(form);
    }
    
    @Override
    public String getTitle() {
        return "Kataster - vytvorenie vlastníka";
    }
    
}

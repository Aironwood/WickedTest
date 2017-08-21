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
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author jan.jarabinec
 */
public class OwnerCreatePage extends BasePage { 

    public OwnerCreatePage()
    {
        add(new FeedbackPanel("feedback"));
        add(new OwnerCreatePanel("ownerCreatePanel", new CompoundPropertyModel<>(new Owner())));
    }
    
    public OwnerCreatePage(Owner own)             
    {
        add(new FeedbackPanel("feedback"));
        add(new OwnerCreatePanel("ownerCreatePanel", new CompoundPropertyModel<>(own)));
    }
    
    @Override
    public String getTitle() {
        return "Kataster - vytvorenie vlastníka";
    }
    
}

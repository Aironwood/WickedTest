/*
 * Copyright 2017 JanJ.
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
package com.mycompany.PropertyPage;

import PropertyManager.common.AppCommons;
import PropertyManager.manager.Property;
import PropertyManager.manager.PropertyManager;
import com.mycompany.BasePage;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

/**
 *
 * @author JanJ
 */
public class PropertyPage extends BasePage {

    private List propertyList;
    private DataView dataView;
    private PropertyManager propertyManager;

    public PropertyPage() {

    
        propertyManager = AppCommons.getPropertyManager();
        propertyList = propertyManager.findAllProperties();
        
        Button addButton = new Button("addbutton") {
            @Override
            public void onSubmit() {
                info("addbutton.onSubmit executed");
            }
        };
        add(addButton);
        Button removeButton = new Button("removeButton"){
            @Override
            public void onSubmit()
            {
                info("removeButton.onSubmit executed");
            }
        };
        add(removeButton);

        dataView = new DataView("simple", new ListDataProvider(propertyList)) {
            @Override
            public void populateItem(final Item item) {
                final Property propert = (Property) item.getModelObject();
                item.add(new Label("id", propert.getId()), new Label("street",
                        propert.getAddressStreet()),
                        new Label("town", propert.getAddressTown()),
                        new Label("price", propert.getPrice()),
                        new Label("typeof", propert.getTypeOfBuilding()),
                        new Label("square", propert.getSquareMeters()),
                        new Label("dateofbuild", propert.getDateOfBuild()),
                        new Label("description", propert.getDescription())
                );

            }
        };
        dataView.setItemsPerPage(20);
        add(dataView);

    }

    @Override
    public String getTitle() {
        return "Kataster - nehnuteľnosti";
    }
}


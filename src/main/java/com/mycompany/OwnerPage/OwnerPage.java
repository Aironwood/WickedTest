package com.mycompany.OwnerPage;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import com.mycompany.BasePage;
import PropertyManager.manager.Owner;
import PropertyManager.manager.OwnerDAO;
import PropertyManager.common.AppCommons;
import PropertyManager.manager.*;
import com.mycompany.PropertyPage.PropertyPage;
import java.awt.Panel;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class OwnerPage extends BasePage {

    private List ownersList;
    private final DataView dataView;
    private OwnerManager ownerManager;

    public OwnerPage() {
        ownerManager = AppCommons.getOwnerManager();
        ownersList = ownerManager.findAllOwners();
        Form form = new Form("form");
        dataView = new DataView("rows", new ListDataProvider(ownersList)) {
            @Override
            public void populateItem(final Item item) {
                final Owner user = (Owner) item.getModelObject();
                item.add(new Label("id", user.getId()), new Label("Surname",
                        user.getSurname()),
                        new Label("Born Date", user.getBorn().toString()),
                        new Label("Phonenumber", user.getPhoneNumber()),
                        new Label("Street", user.getAddressStreet()),
                        new Label("Town", user.getAddressTown()),
                        new Label("Name", user.getName())
                );
                

            }
            
        };
        Button addButton = new Button("addbutton") {
            @Override
            public void onSubmit() {
                info("addbutton.onSubmit executed");
                
                setResponsePage(OwnerCreatePage.class);
            }
        };
        
        form.add(addButton);
        Button removeButton = new Button("removeButton"){
            @Override
            public void onSubmit()
            {
                info("removeButton.onSubmit executed");
            }
        };
        form.add(removeButton);
        dataView.setItemsPerPage(50);
        form.add(dataView);
        add(form);
    }

    public String getTitle() {
        return "Kataster - vlastníci";
    }
    @Override
    protected void onBeforeRender()
    {
        ownersList = ownerManager.findAllOwners();
        super.onBeforeRender();
    }
    
    
}

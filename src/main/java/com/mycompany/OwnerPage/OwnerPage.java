package com.mycompany.OwnerPage;

import org.apache.wicket.markup.html.basic.Label;
import com.mycompany.BasePage;
import PropertyManager.manager.Owner;
import PropertyManager.common.AppCommons;
import PropertyManager.manager.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.model.AbstractCheckBoxModel;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

public class OwnerPage extends BasePage {

    private List<Owner> selectedOwners = new ArrayList<>();

    public OwnerPage() {
        OwnerManager ownerManager = AppCommons.getOwnerManager();
        List<Owner> ownersList = ownerManager.findAllOwners();
        OwnerDataView dataView = new OwnerDataView("rows", new ListDataProvider(ownersList));

        Button addButton = new Button("addbutton") {
            @Override
            public void onSubmit() {
                info("addbutton.onSubmit executed");

                setResponsePage(OwnerCreatePage.class);
            }
        };
        Form form = new Form("form");
        form.add(addButton);
        Button removeButton = new Button("removeButton") {
            @Override
            public void onSubmit() {
                for (Owner own : selectedOwners) {
                    try {
                        ownerManager.deleteOwner(own);
                    } catch (Exception ex) {
                        error(getString("ownerConstrainError"));
                    }
                }
                setResponsePage(OwnerPage.class); //bad bad
            }
        };
        form.add(new FeedbackPanel("feedback"));
        Button updateButton = new Button("updateButton") {
            @Override
            public void onSubmit() {
                if (selectedOwners.size() != 1) {
                    error(getString("updateOnlyOne"));
                    return;
                }
                setResponsePage(new OwnerCreatePage(selectedOwners.get(0)));

            }
        };
        form.add(updateButton);
        form.add(removeButton);
        dataView.setItemsPerPage(50);
        form.add(dataView);
        add(form);
    }

    @Override
    public String getTitle() {
        return this.getString("tabTitleOwn");
    }

    private class CheckBoxSelection extends AbstractCheckBoxModel {

        private final Owner owner;

        public CheckBoxSelection(Owner owner) {
            this.owner = owner;
        }

        @Override
        public boolean isSelected() {
            return selectedOwners.contains(owner);
        }

        @Override
        public void select() {
            selectedOwners.add(owner);
        }

        @Override
        public void unselect() {
            selectedOwners.remove(owner);
        }
    }

    private class OwnerDataView extends DataView {

        public OwnerDataView(String id, IDataProvider dataProvider) {
            super(id, dataProvider);
        }

        public OwnerDataView(String id, IDataProvider dataProvider, long itemsPerPage) {
            super(id, dataProvider, itemsPerPage);
        }

        @Override
        protected void populateItem(Item item) {
            final Owner user = (Owner) item.getModelObject();
            item.add(new Label("id", user.getId()), new Label("Surname",
                    user.getSurname()),
                    new Label("Born Date", user.getBorn().toString()),
                    new Label("Phonenumber", user.getPhoneNumber().toString()),
                    new Label("Street", user.getAddressStreet()),
                    new Label("Town", user.getAddressTown()),
                    new Label("Name", user.getName()),
                    new CheckBox("check", new CheckBoxSelection(user)));
        }

        protected void refresh() {
            this.onPopulate();
        }

    }

}

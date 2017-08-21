package com.mycompany.OwnerPage;

import PropertyManager.common.AppCommons;
import PropertyManager.common.PhoneNumberConverter;
import PropertyManager.manager.Owner;
import PropertyManager.manager.OwnerManager;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.markup.html.form.RequiredTextField;

/**
 *
 * @author jan.jarabinec
 */
public class OwnerCreatePanel extends GenericPanel<Owner> {

    public OwnerCreatePanel(String id, IModel<Owner> model) {
        super(id, model);

        final TextField<String> tName = new RequiredTextField<>("name");
        tName.add(new NameValidator(1, 10, "Meno"));

        final TextField<String> tSurname = new RequiredTextField<>("surname");
        tSurname.add(new NameValidator(1, 10, "Priezvisko"));

        final TextField<String> tDate = new RequiredTextField<>("born");
        final DatePicker dp = new DatePicker() {
            @Override
            protected boolean enableMonthYearSelection() {
                return true;
            }

            @Override
            protected String getDatePattern() {
                return "yyyy-MM-dd";
            }
        };
        tDate.add(dp);
        final TextField<String> tPhone = new RequiredTextField("phoneNumber", String.class) {

            public IConverter getConverter() {
                return new PhoneNumberConverter();
            }
        };
        tPhone.add(new PhoneValidator());
        final TextField<String> tStreet = new RequiredTextField<>("addressStreet");
        tStreet.add(new NameValidator(1, 10, "Ulica"));
        final TextField<String> tTown = new RequiredTextField<>("addressTown");
        tTown.add(new NameValidator(1, 10, "Mesto"));

        Form<Owner> form = new Form<Owner>("form", model) {
            @Override
            public void onSubmit() {
                OwnerManager ownerManager = AppCommons.getOwnerManager();
                if (this.getModelObject().getId() != null) {
                    ownerManager.updateOwner(this.getModelObject());
                } else {
                    ownerManager.createOwner(this.getModelObject());
                }
            }

        };
        form.add(tName, tSurname, tDate, tPhone, tStreet, tTown);
        Button addButton = new Button("okButton") {
            @Override
            public void onSubmit() {
                setResponsePage(OwnerPage.class);
            }
        };
        form.add(addButton);
        Button cancelButton = new Button("cancelButton") {
            @Override
            public void onSubmit() {
                setResponsePage(OwnerPage.class);
            }

            @Override
            public void onError() {
                setResponsePage(OwnerPage.class);
            }
        };

        form.add(cancelButton);
        add(form);
    }

}

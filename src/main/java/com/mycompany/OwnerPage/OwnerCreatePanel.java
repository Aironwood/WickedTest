package com.mycompany.OwnerPage;

import PropertyManager.common.AppCommons;
import PropertyManager.common.OwnDateConverter;
import PropertyManager.common.PhoneNumberConverter;
import PropertyManager.manager.Owner;
import PropertyManager.manager.OwnerManager;
import PropertyManager.manager.PhoneNumber;
import com.mycompany.PropertyPage.PropertyPage;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.CompoundPropertyModel;
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
        
        final DateTextField tDate = new DateTextField("born", new PatternDateConverter("yyyy-MM-dd", true));
        final TextField<String> tPhone = new RequiredTextField("phoneNumber", PhoneNumber.class) {
            

            public IConverter getConverter() {
                return new PhoneNumberConverter();
            }
        };
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
                setResponsePage(PropertyPage.class);
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

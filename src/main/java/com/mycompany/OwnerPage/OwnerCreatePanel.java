package com.mycompany.OwnerPage;

import PropertyManager.common.AppCommons;
import PropertyManager.manager.Owner;
import PropertyManager.manager.OwnerManager;
import com.mycompany.PropertyPage.PropertyPage;
import java.io.Serializable;
import java.time.LocalDate;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author jan.jarabinec
 */
public class OwnerCreatePanel extends GenericPanel<Owner> {
     
    public OwnerCreatePanel(String id, IModel<Owner> model) {
        super(id);
        
        final Owner owner = new Owner();
        final TextField<String> tName = new TextField<String>("name");
        tName.add(new NameValidator(1, 10, "Meno"));
        final TextField<String> tSurname = new TextField<String>("surname");
        tSurname.add(new NameValidator(1, 10, "Priezvisko"));
        final TextField<String> tPhone = new TextField<String>("phoneNumber");
        tPhone.add(new PhoneValidator());
        final TextField<String> tStreet = new TextField<String>("addressStreet");
        tStreet.add(new NameValidator(1, 10, "Ulica"));
        final TextField<String> tTown = new TextField<String>("addressTown");
        tStreet.add(new NameValidator(1, 10, "Mesto"));
        Form<Owner> form = new Form<Owner>("form", new CompoundPropertyModel<Owner>(owner)){
            @Override
            public void onSubmit()
            {
                owner.setName(this.getModelObject().getName());
                owner.setSurname(this.getModelObject().getSurname());
                owner.setBorn(LocalDate.now());
                owner.setPhoneNumber(this.getModelObject().getPhoneNumber());
                owner.setAddressStreet(this.getModelObject().getAddressStreet());
                owner.setAddressTown(this.getModelObject().getAddressTown());
                OwnerManager ownerManager = AppCommons.getOwnerManager();
                ownerManager.createOwner(owner);
            }
        
        };
        form.add(tName, tSurname, tPhone, tStreet, tTown);
        Button addButton = new Button("okButton"){
            @Override
            public void onSubmit()
            {
                info("OK butted executed");
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
    
    
    
    
}

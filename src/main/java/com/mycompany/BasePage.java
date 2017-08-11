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
package com.mycompany;

import PropertyManager.common.BatisConnectionFactory;
import PropertyManager.common.DBUtils;
import PropertyManager.common.SpringConfig;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import com.mycompany.OwnerPage.OwnerPage;
import com.mycompany.PropertyPage.PropertyPage;
import PropertyManager.common.*;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.ibatis.session.SqlSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author JanJ
 */
public abstract class BasePage extends WebPage {

    private static DataSource ds = AppCommons.getDataSource();
    
    public BasePage() {
        Link ownerPageLink = new Link("OwnerPage") {
            @Override
            public void onClick() {
                setResponsePage(OwnerPage.class);
            }
        };
        add(ownerPageLink);
        Label titleLB = new Label("title", new Model(getTitle()));
        add(titleLB);
        Link propertyPageLink = new Link("PropertyPage") {
            @Override
            public void onClick() {
                setResponsePage(PropertyPage.class);
            }
        };
        add(propertyPageLink);
        
    }
    

    public abstract String getTitle();

}

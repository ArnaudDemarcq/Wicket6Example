/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.pages;

import beans.TestEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.dao.GenericDao;

/**
 *
 * @author arnaud
 */
public class PropertiesTestPage extends PocMainPage {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesTestPage.class);

    public PropertiesTestPage(PageParameters parameters) {
        super(parameters);
        List<String> propList = new ArrayList<String>(System.getProperties().stringPropertyNames());
        PropertyListView propTable = new PropertyListView("propList", propList);
        add(propTable);


    }

    private class PropertyListView extends ListView<String> {

        
        //private final List<String> propList = new ArrayList<String>();

        public PropertyListView(String string, List<String> list) {
            super(string, list);
       //     propList.addAll(list);
        } /**/

        @Override
        protected void populateItem(ListItem<String> item) {
            String propKey = item.getModelObject();
            String propValue = System.getProperties().getProperty(propKey);
            item.add(new Label("propKey", propKey));
            item.add(new Label("propVal", propValue));
        }
    }
}

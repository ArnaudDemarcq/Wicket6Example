/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Pannels.users;

import beans.UserBean;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmitter;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.dao.UserBeanDao;

/**
 *
 * @author arnaud
 */
public class CreateUserPanel extends Panel {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserPanel.class);
    @SpringBean(name = "userBeanDao")
    UserBeanDao userBeanDao;
    private String currentUserPassword = "";
    private String currentUserName = "";

    public CreateUserPanel(String id) {
        super(id);
        Form addUserForm = new Form("addUserForm") {

            @Override
            public void process(IFormSubmitter submittingComponent) {
                super.process(submittingComponent);
                LOGGER.error("###############################" + currentUserPassword);
                UserBean newUserBean = new UserBean();
                newUserBean.setPassword(currentUserPassword);
                newUserBean.setLogin(currentUserName);
                userBeanDao.create(newUserBean);
                currentUserPassword = currentUserName = "";
            }
        };
        addUserForm.add(new TextField<String>("addUserName", new PropertyModel<String>(this, "currentUserName")));
        addUserForm.add(new TextField<String>("addUserPassword", new PropertyModel<String>(this, "currentUserPassword")));
        add(addUserForm);
    
    }
}

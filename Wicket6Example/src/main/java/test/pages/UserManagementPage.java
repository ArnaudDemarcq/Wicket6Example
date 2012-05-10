package test.pages;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import test.Pannels.users.CreateUserPanel;
import test.Pannels.users.UserListPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arnaud
 */
public class UserManagementPage extends PocMainPage {

    public UserManagementPage(PageParameters parameters) {
        super(parameters);
        add(new UserListPanel("userPanel"));
        add(new CreateUserPanel("createUserPanel"));
    }

}

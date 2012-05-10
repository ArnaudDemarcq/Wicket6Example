/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Pannels.users;

import beans.UserBean;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import test.dao.UserBeanDao;

/**
 *
 * @author arnaud
 */
public class UserListPanel extends Panel {

    @SpringBean(name = "userBeanDao")
    UserBeanDao userBeanDao;

    public UserListPanel(String id) {
        super(id);
        add(new UserListView("userList", new AllUserBeansModel()));
        add(new Label("userCount", new UserCountModel()));
    }

    private class UserListView extends ListView<UserBean> {

        public UserListView(String string, IModel<? extends List<? extends UserBean>> imodel) {
            super(string, imodel);
        }

        @Override
        protected void populateItem(ListItem<UserBean> item) {
            UserBean currentUserBean = item.getModelObject();
            item.add(new Label("userId", "" + currentUserBean.getId()));
            item.add(new Label("userName", "" + currentUserBean.getLogin()));
            item.add(new Label("userPassword", "" + currentUserBean.getPassword()));
        }
    }

    private class AllUserBeansModel extends LoadableDetachableModel<List<UserBean>> {

        @Override
        protected List<UserBean> load() {
            return userBeanDao.findAll();
        }
    }

    private class UserCountModel extends LoadableDetachableModel<Long> {

        @Override
        protected Long load() {
             return userBeanDao.countAll();
        }
       
    }
}

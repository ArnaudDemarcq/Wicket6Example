/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import beans.UserBean;
import java.util.List;

/**
 *
 * @author arnaud
 */
public class UserBeanDao extends GenericDao<UserBean> {

    private static final String COUNT_ALL_QUERY = "UserBeanCountAll";
    private static final String GET_ALL_USERS_QUERY ="UserBeanAll";

    public Long countAll() {
        Long countAll = (Long) em.createNamedQuery(COUNT_ALL_QUERY).
                getSingleResult();
        return countAll;
    }

    public List<UserBean> findAll() {
        List returnList = em.createNamedQuery(GET_ALL_USERS_QUERY).getResultList();
        return returnList;
    }
}

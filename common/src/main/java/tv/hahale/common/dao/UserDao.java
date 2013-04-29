package tv.hahale.common.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import tv.hahale.common.bean.LoginUser;

@Repository
@SuppressWarnings("unchecked")
public class UserDao extends AbstractDao<LoginUser, String> {

  protected UserDao() {
    super(LoginUser.class);
  }

  public Long findUserTotal(String role) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.setProjection(Projections.rowCount());
    criteria.createCriteria("roles").add(Restrictions.eq("role", role));
    return (Long) criteria.uniqueResult();
  }

  public List<LoginUser> findUser(String role, int page, int pageSize) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.createCriteria("roles").add(Restrictions.eq("role", role));
    criteria.setFirstResult((Math.max(page, 1) - 1) * pageSize);
    criteria.setMaxResults(pageSize);
    return criteria.list();
  }

}

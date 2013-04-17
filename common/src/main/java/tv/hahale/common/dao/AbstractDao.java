package tv.hahale.common.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<E, I extends Serializable> extends SqlSessionDaoSupport {

  @Autowired
  private SessionFactory sessionFactory;

  protected Class<E> entityClass;

  protected AbstractDao(Class<E> entityClass) {
    this.entityClass = entityClass;
  }

  public void saveOrUpdate(E e) {
    getCurrentSession().saveOrUpdate(e);
  }

  public void delete(E e) {
    getCurrentSession().delete(e);
  }

  public List<E> findAll() {
    return getCurrentSession().createCriteria(entityClass).list();
  }

  public E findById(I id) {
    return (E) getCurrentSession().get(entityClass, id);
  }

  public List<E> findByCriteria(Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    return criteria.list();
  }

  public List<E> findByCriteria(Order order) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.addOrder(order);
    return criteria.list();
  }

  public List<E> findByCriteria(Criterion criterion, Order order) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.addOrder(order);
    return criteria.list();
  }

  public List<E> findByCriteria(Criterion criterion, int page, int pageSize) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.setFirstResult((Math.max(page, 1) - 1) * pageSize);
    criteria.setMaxResults(pageSize);
    return criteria.list();
  }

  public List<E> findByCriteria(Order order, int page, int pageSize) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.addOrder(order);
    criteria.setFirstResult((Math.max(page, 1) - 1) * pageSize);
    criteria.setMaxResults(pageSize);
    return criteria.list();
  }

  public List<E> findByCriteria(Criterion criterion, Order order, int page, int pageSize) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.addOrder(order);
    criteria.setFirstResult((Math.max(page, 1) - 1) * pageSize);
    criteria.setMaxResults(pageSize);
    return criteria.list();
  }

  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  @Autowired(required = false)
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    super.setSqlSessionFactory(sqlSessionFactory);
  }

  @Autowired(required = false)
  public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
    super.setSqlSessionTemplate(sqlSessionTemplate);
  }

}

package tv.hahale.common.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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

  public void saveOrUpdate(Object e) {
    Session currentSession = getCurrentSession();
    currentSession.saveOrUpdate(e);
  }

  public void delete(E e) {
    getCurrentSession().delete(e);
  }

  public Long total() {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.setProjection(Projections.rowCount());
    return (Long) criteria.uniqueResult();
  }

  public List<E> findAll() {
    return getCurrentSession().createCriteria(entityClass).list();
  }

  public E findById(I id) {
    return (E) getCurrentSession().get(entityClass, id);
  }

  public <T, K extends Serializable> T findById(Class<T> cls, K id) {
    return (T) getCurrentSession().get(cls, id);
  }

  public List<E> find(Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    return criteria.list();
  }

  public List<E> find(Order order) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.addOrder(order);
    return criteria.list();
  }

  public List<E> find(Criterion criterion, Order order) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.addOrder(order);
    return criteria.list();
  }

  public List<E> find(Criterion criterion, int page, int pageSize) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.setFirstResult((Math.max(page, 1) - 1) * pageSize);
    criteria.setMaxResults(pageSize);
    return criteria.list();
  }

  public List<E> find(Order order, int page, int pageSize) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.addOrder(order);
    criteria.setFirstResult((Math.max(page, 1) - 1) * pageSize);
    criteria.setMaxResults(pageSize);
    return criteria.list();
  }

  public List<E> find(Criterion criterion, Order order, int page, int pageSize) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.addOrder(order);
    criteria.setFirstResult((Math.max(page, 1) - 1) * pageSize);
    criteria.setMaxResults(pageSize);
    return criteria.list();
  }

  public E findOne(Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.add(criterion);
    criteria.setMaxResults(1);
    return (E) criteria.uniqueResult();
  }

  public Integer max(String prop) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.setProjection(Projections.max(prop));
    return (Integer) criteria.uniqueResult();
  }

  public Integer max(String prop, Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.setProjection(Projections.max(prop));
    criteria.add(criterion);
    return (Integer) criteria.uniqueResult();
  }

  public Integer min(String prop) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.setProjection(Projections.min(prop));
    return (Integer) criteria.uniqueResult();
  }

  public Integer min(String prop, Criterion criterion) {
    Criteria criteria = getCurrentSession().createCriteria(entityClass);
    criteria.setProjection(Projections.min(prop));
    criteria.add(criterion);
    return (Integer) criteria.uniqueResult();
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

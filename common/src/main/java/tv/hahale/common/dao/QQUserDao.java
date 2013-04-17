package tv.hahale.common.dao;

import org.springframework.stereotype.Repository;

import tv.hahale.common.bean.QQUser;

@Repository
public class QQUserDao extends AbstractDao<QQUser, String> {

  protected QQUserDao() {
    super(QQUser.class);
  }

}

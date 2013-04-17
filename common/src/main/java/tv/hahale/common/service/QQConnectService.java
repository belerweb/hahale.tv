package tv.hahale.common.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tv.hahale.common.bean.QQUser;
import tv.hahale.common.dao.QQUserDao;

@Service
@Transactional(readOnly = true)
public class QQConnectService {

  @Autowired
  private QQUserDao qqUserDao;

  /**
   * 注册一个新QQ用户，如果已经注册则更新Token等信息
   */
  @Transactional(readOnly = false)
  public void register(QQUser newUser) {
    QQUser user = qqUserDao.findById(newUser.getOpenid());
    if (user == null) {
      newUser.setCreatedTime(new Date());
      newUser.setLastUpdate(new Date());
      qqUserDao.saveOrUpdate(newUser);
    } else {
      user.setToken(newUser.getToken());
      user.setExpireIn(newUser.getExpireIn());
      user.setLastUpdate(new Date());
      qqUserDao.saveOrUpdate(user);
    }
  }

}

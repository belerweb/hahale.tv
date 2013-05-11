package tv.hahale.common.service;


import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tv.hahale.common.bean.LoginUser;
import tv.hahale.common.bean.QQAuth;
import tv.hahale.common.bean.Role;
import tv.hahale.common.bean.WeiboAuth;
import tv.hahale.common.dao.UserDao;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Transactional
  public void addUser(LoginUser user) {
    userDao.saveOrUpdate(user);
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String usernameType = null;
    if (username.matches("^\\d+$")) {
      usernameType = "cellPhone";
    } else if (username.contains("@")) {
      usernameType = "email";
    } else {
      usernameType = "loginUsername";
    }
    LoginUser user = userDao.findOne(Restrictions.eq(usernameType, username));
    if (user == null) {
      user = userDao.findById(username);// 通过ID查找
      if (user == null) {
        throw new UsernameNotFoundException("用户不存在");
      }
      if (user.getPassword() == null) {
        // FIXME 是否有安全问题
        user.setPassword(username);
      }
    }
    user.setUsername(username);
    return user;
  }

  /**
   * QQ 登录用户注册
   */
  @Transactional
  public LoginUser register(QQAuth auth) {
    QQAuth existed = userDao.findById(QQAuth.class, auth.getOpenid());
    if (existed == null) {
      auth.setCreatedTime(new Date());
      auth.setLastUpdate(new Date());
      userDao.saveOrUpdate(auth);
    } else {
      existed.setToken(auth.getToken());
      existed.setExpireIn(auth.getExpireIn());
      existed.setLastUpdate(new Date());
      userDao.saveOrUpdate(existed);
    }

    LoginUser user = userDao.findOne(Restrictions.eq("qqAuth", auth));
    if (user == null) {
      user = new LoginUser(auth);
      userDao.saveOrUpdate(user);
    }
    return user;
  }

  /**
   * 新浪微博登录用户注册
   */
  @Transactional
  public LoginUser register(WeiboAuth auth) {
    WeiboAuth existed = userDao.findById(WeiboAuth.class, auth.getUid());
    if (existed == null) {
      auth.setCreatedTime(new Date());
      auth.setLastUpdate(new Date());
      userDao.saveOrUpdate(auth);
    } else {
      existed.setToken(auth.getToken());
      existed.setExpireIn(auth.getExpireIn());
      existed.setLastUpdate(new Date());
      userDao.saveOrUpdate(existed);
    }

    LoginUser user = userDao.findOne(Restrictions.eq("weiboAuth", auth));
    if (user == null) {
      user = new LoginUser(auth);
      userDao.saveOrUpdate(user);
    }
    return user;
  }

  public Long getUserListTotal(Role role) {
    return userDao.findUserTotal(role.getRole());
  }

  public List<LoginUser> getUserList(Role role, int page, int pageSize) {
    return userDao.findUser(role.getRole(), page, pageSize);
  }

}

package tv.hahale.common.bean;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class LoginUser implements UserDetails {

  private static final long serialVersionUID = 4843380217443944009L;

  private String username;// SpringSecurity
  private String password;// 密码

  private String id;// 用户编号
  private String cellPhone;// 手机号
  private String email;// 电子邮件
  private String loginUsername;// 登陆用户名
  private String fullname;// 姓名
  private String nickname;// 昵称
  private String avatar;// 头像

  private QQAuth qqAuth;// QQ 授权
  private WeiboAuth weiboAuth;// 新浪微博授权

  private Set<Role> roles;// 角色

  public LoginUser() {}

  public LoginUser(QQAuth auth) {
    this.qqAuth = auth;
    this.id = UUID.randomUUID().toString();
  }

  public LoginUser(WeiboAuth auth) {
    this.weiboAuth = auth;
    this.id = UUID.randomUUID().toString();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLoginUsername() {
    return loginUsername;
  }

  public void setLoginUsername(String loginUsername) {
    this.loginUsername = loginUsername;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public QQAuth getQqAuth() {
    return qqAuth;
  }

  public void setQqAuth(QQAuth qqAuth) {
    this.qqAuth = qqAuth;
  }

  public WeiboAuth getWeiboAuth() {
    return weiboAuth;
  }

  public void setWeiboAuth(WeiboAuth weiboAuth) {
    this.weiboAuth = weiboAuth;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.emptyList();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}

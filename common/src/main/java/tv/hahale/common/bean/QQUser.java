package tv.hahale.common.bean;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

public class QQUser implements User {

  private static final long serialVersionUID = -6961457379517207508L;

  private String openid;
  private String token;
  private long expireIn;
  private Date createdTime;
  private Date lastUpdate;

  public QQUser() {}

  public QQUser(String openid, String token, long expireIn) {
    this.openid = openid;
    this.token = token;
    this.expireIn = expireIn;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
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

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public long getExpireIn() {
    return expireIn;
  }

  public void setExpireIn(long expireIn) {
    this.expireIn = expireIn;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

}

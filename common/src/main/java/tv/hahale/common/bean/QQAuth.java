package tv.hahale.common.bean;

import java.util.Date;

public class QQAuth {

  private String openid;
  private String token;
  private long expireIn;
  private Date createdTime;
  private Date lastUpdate;

  public QQAuth() {}

  public QQAuth(String openid, String token, long expireIn) {
    this.openid = openid;
    this.token = token;
    this.expireIn = expireIn;
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

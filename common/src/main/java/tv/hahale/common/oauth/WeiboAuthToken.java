package tv.hahale.common.oauth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import tv.hahale.common.bean.LoginUser;

public class WeiboAuthToken extends AbstractAuthenticationToken {

  private static final long serialVersionUID = 7201859537467572288L;

  private LoginUser user;

  public WeiboAuthToken(LoginUser user) {
    this(Collections.<GrantedAuthority>emptyList());
    this.user = user;
  }

  private WeiboAuthToken(Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return user;
  }

}

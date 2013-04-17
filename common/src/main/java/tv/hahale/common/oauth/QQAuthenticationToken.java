package tv.hahale.common.oauth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import tv.hahale.common.bean.QQUser;

public class QQAuthenticationToken extends AbstractAuthenticationToken {

  private static final long serialVersionUID = -7795121296695826713L;

  private QQUser user;

  public QQAuthenticationToken(QQUser user) {
    this(Collections.<GrantedAuthority>emptyList());
    this.user = user;
  }

  private QQAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return user.getOpenid();
  }

  @Override
  public Object getPrincipal() {
    return user;
  }

}

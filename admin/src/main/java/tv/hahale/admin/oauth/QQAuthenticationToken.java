package tv.hahale.admin.oauth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class QQAuthenticationToken extends AbstractAuthenticationToken {

  private String openId;
  private String accessToken;

  public QQAuthenticationToken(String openId, String accessToken) {
    this(Collections.<GrantedAuthority>emptyList());
    this.openId = openId;
    this.accessToken = accessToken;
  }

  private QQAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    setAuthenticated(true);
  }

  private static final long serialVersionUID = -7795121296695826713L;

  @Override
  public Object getCredentials() {
    return accessToken;
  }

  @Override
  public Object getPrincipal() {
    return openId;
  }

}

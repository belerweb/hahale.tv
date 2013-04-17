package tv.hahale.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tv.hahale.common.bean.QQUser;
import tv.hahale.common.oauth.QQAuthenticationToken;
import tv.hahale.common.service.QQConnectInitService;
import tv.hahale.common.service.QQConnectService;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;
import com.qq.connect.utils.QQConnectConfig;

@Controller
public class Oauth2Controller {

  private static final Oauth QQ_OAUTH = new Oauth();

  @Autowired
  private QQConnectService qqConnectService;

  @RequestMapping("/connector/qq_login.do")
  public String qqLogin(HttpServletRequest request) {
    String redirect = "redirect:/index.html";
    try {
      String redirectURI =
          request.getScheme() + "://" + request.getServerName() + request.getContextPath()
              + "/connector/qq.do";
      QQConnectConfig.updateProperties(QQConnectInitService.REDIRECT_URI, redirectURI);
      redirect = "redirect:" + QQ_OAUTH.getAuthorizeURL(request);
    } catch (QQConnectException e) {
      e.printStackTrace();
    }

    return redirect;
  }

  @RequestMapping("/connector/qq.do")
  public String auth(HttpServletRequest request) {
    String redirect = "redirect:/index.html";
    try {
      AccessToken accessToken = QQ_OAUTH.getAccessTokenByRequest(request);
      // TODO validate accessToken
      QQUser user =
          new QQUser(new OpenID(accessToken.getAccessToken()).getUserOpenID(), accessToken
              .getAccessToken(), accessToken.getExpireIn());
      qqConnectService.register(user);
      SecurityContextHolder.getContext().setAuthentication(new QQAuthenticationToken(user));
    } catch (QQConnectException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return redirect;
  }
}

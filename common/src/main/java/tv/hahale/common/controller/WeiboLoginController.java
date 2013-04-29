package tv.hahale.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tv.hahale.common.bean.LoginUser;
import tv.hahale.common.bean.WeiboAuth;
import tv.hahale.common.oauth.WeiboAuthToken;
import tv.hahale.common.service.UserService;
import tv.hahale.common.service.WeiboInitService;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

@Controller
public class WeiboLoginController {

  private static final Oauth WEIBO_OAUTH = new Oauth();

  @Autowired
  private UserService userService;

  @RequestMapping("/connector/weibo_login.do")
  public String weiboLogin(HttpServletRequest request) {
    String redirect = "redirect:/index.html";
    try {
      String redirectURI =
          request.getScheme() + "://" + request.getServerName() + request.getContextPath()
              + "/connector/weibo.do";
      WeiboConfig.updateProperties(WeiboInitService.REDIRECT_URI, redirectURI);
      redirect =
          "redirect:"
              + WEIBO_OAUTH.authorize(WeiboInitService.RESPONSE_TYPE_CODE,
                  WeiboInitService.SCOPE_FOLLOW_APP_OFFICIAL_MICROBLOG);
    } catch (WeiboException e) {
      e.printStackTrace();
    }

    return redirect;
  }

  @RequestMapping("/connector/weibo.do")
  public String weibo(@RequestParam String state, @RequestParam String code,
      HttpServletRequest request) {
    String redirect = "redirect:/index.html";
    try {
      AccessToken accessToken = WEIBO_OAUTH.getAccessTokenByCode(code);
      String token = accessToken.getAccessToken();
      WeiboAuth auth =
          new WeiboAuth(accessToken.getUid(), token, Long.parseLong(accessToken.getExpireIn()));
      LoginUser user = userService.register(auth);
      SecurityContextHolder.getContext().setAuthentication(new WeiboAuthToken(user));
    } catch (WeiboException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return redirect;
  }
}

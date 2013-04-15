package tv.hahale.admin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tv.hahale.admin.oauth.QQAuthenticationToken;

@Controller
public class Oauth2Connector {

  @RequestMapping("/connector/qq.do")
  @ResponseBody
  public void auth(@RequestParam String openId, @RequestParam String accessToken) {
    // TODO validataion
    SecurityContextHolder.getContext().setAuthentication(
        new QQAuthenticationToken(openId, accessToken));
    System.out.println("openId:" + openId);
    System.out.println("accessToken:" + accessToken);
  }
}

package tv.hahale.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tv.hahale.common.bean.QQUser;
import tv.hahale.common.oauth.QQAuthenticationToken;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.qzone.UserInfoBean;

@Controller
public class IndexController {

  @RequestMapping("/index.html")
  public String index(HttpServletRequest request, Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
      return "login";
    }

    if (authentication instanceof QQAuthenticationToken) {
      QQUser user = (QQUser) authentication.getPrincipal();
      try {
        UserInfoBean userInfo = new UserInfo(user.getToken(), user.getOpenid()).getUserInfo();
        model.addAttribute("userInfo", userInfo);
      } catch (QQConnectException e) {
        e.printStackTrace();
      }
    }
    return "index";
  }

}

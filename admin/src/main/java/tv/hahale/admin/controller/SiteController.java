package tv.hahale.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tv.hahale.common.bean.Site;
import tv.hahale.common.service.SiteService;

@Controller
public final class SiteController {

  @Autowired
  private SiteService siteService;

  @RequestMapping(value = "/site/config.html", method = RequestMethod.GET)
  public void config(Model model) {
    model.addAttribute("site", siteService.getSite());
  }

  @RequestMapping(value = "/site/config.html", method = RequestMethod.POST)
  @ResponseBody
  public void config(Site site) {
    siteService.modifySite(site);
  }
}

package tv.hahale.common.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tv.hahale.common.bean.Site;
import tv.hahale.common.dao.SiteDao;

@Service
@Transactional(readOnly = true)
public class SiteService {

  private Site cachedSite;

  @Autowired
  private SiteDao siteDao;

  /**
   * 获取最新的网站配置信息
   */
  public Site getSite() {
    checkCachedSite();
    return cachedSite;
  }

  /**
   * 修改网站配置信息
   */
  @Transactional(readOnly = false)
  public void modifySite(Site newSite) {
    checkCachedSite();
    if (newSite != null && !newSite.equals(cachedSite)) {
      newSite.setLastUpdate(new Date());
      siteDao.saveOrUpdate(newSite);
      cachedSite = newSite;
    }
  }

  private void checkCachedSite() {
    if (cachedSite == null) {
      cachedSite = siteDao.findLatestSite();
    }
  }

}

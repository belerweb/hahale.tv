package tv.hahale.common.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.qq.connect.utils.QQConnectConfig;

@Service
public class QQConnectInitService implements InitializingBean {

  private static final String QQ_APP_ID = "qq.app_id";
  private static final String QQ_APP_KEY = "qq.app_key";

  public static final String APP_ID = "app_ID";
  public static final String APP_KEY = "app_KEY";
  public static final String REDIRECT_URI = "redirect_URI";
  public static final String SCOPE = "scope";

  @Override
  public void afterPropertiesSet() throws Exception {
    String appId = System.getProperty(QQ_APP_ID, System.getenv(QQ_APP_ID));
    String appKey = System.getProperty(QQ_APP_KEY, System.getenv(QQ_APP_KEY));
    Assert.notNull(appId, "qq.app_id must confid in env or system properties.");
    Assert.notNull(appKey, "qq.app_key must confid in env or system properties.");
    QQConnectConfig.updateProperties(APP_ID, appId);
    QQConnectConfig.updateProperties(APP_KEY, appKey);
  }


}

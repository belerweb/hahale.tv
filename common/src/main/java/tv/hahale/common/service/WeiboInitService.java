package tv.hahale.common.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import weibo4j.util.WeiboConfig;

@Service
public class WeiboInitService implements InitializingBean {

  private static final String WEIBO_APP_KEY = "weibo.app_key";
  private static final String WEIBO_APP_SECRET = "weibo.app_secret";

  public static final String CLIENT_ID = "client_ID";
  public static final String CLIENT_SECRET = "client_SERCRET";
  public static final String REDIRECT_URI = "redirect_URI";
  public static final String SCOPE = "scope";
  public static final String SCOPE_EMAIL = "email";// 用户的联系邮箱
  public static final String SCOPE_DIRECT_MESSAGES_WRITE = "direct_messages_write";// 私信发送接口
  public static final String SCOPE_DIRECT_MESSAGES_READ = "direct_messages_read";// 私信读取接口
  public static final String SCOPE_FRIENDSHIPS_GROUPS_READ = "friendships_groups_read";// 好友分组读取接口组
  public static final String SCOPE_FRIENDSHIPS_GROUPS_WRITE = "friendships_groups_write";// 好友分组写入接口组
  public static final String SCOPE_STATUSES_TO_ME_READ = "statuses_to_me_read";// 定向微博读取接口组
  public static final String SCOPE_FOLLOW_APP_OFFICIAL_MICROBLOG = "follow_app_official_microblog";// 关注应用官方微博

  public static final String RESPONSE_TYPE_CODE = "code";

  @Override
  public void afterPropertiesSet() throws Exception {
    String appKey = System.getProperty(WEIBO_APP_KEY, System.getenv(WEIBO_APP_KEY));
    String appSecret = System.getProperty(WEIBO_APP_SECRET, System.getenv(WEIBO_APP_SECRET));
    Assert.notNull(appKey, "weibo.app_key must confid in env or system properties.");
    Assert.notNull(appSecret, "weibo.app_secret must confid in env or system properties.");

    WeiboConfig.updateProperties(CLIENT_ID, appKey);
    WeiboConfig.updateProperties(CLIENT_SECRET, appSecret);
  }


}

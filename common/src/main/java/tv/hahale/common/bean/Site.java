package tv.hahale.common.bean;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * @author jun
 * 
 *         网站配置，名称...
 */
public class Site {

  private Integer id;
  /**
   * 网站名称
   */
  private String name;
  /**
   * 网页 meta keyword
   */
  private String metaKeyword;
  /**
   * 网页 meta description
   */
  private String metaDescription;
  /**
   * 网页版权说明文字
   */
  private String copyright;
  /**
   * 统计代码
   */
  private String statisticalCode;
  /**
   * 备案号
   */
  private String icp;
  private Date lastUpdate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMetaKeyword() {
    return metaKeyword;
  }

  public void setMetaKeyword(String metaKeyword) {
    this.metaKeyword = metaKeyword;
  }

  public String getMetaDescription() {
    return metaDescription;
  }

  public void setMetaDescription(String metaDescription) {
    this.metaDescription = metaDescription;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public String getStatisticalCode() {
    return statisticalCode;
  }

  public void setStatisticalCode(String statisticalCode) {
    this.statisticalCode = statisticalCode;
  }

  public String getIcp() {
    return icp;
  }

  public void setIcp(String icp) {
    this.icp = icp;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Site) || obj == null) {
      return false;
    }
    Site site = (Site) obj;
    return StringUtils.equals(this.name, site.name)
        && StringUtils.equals(this.metaKeyword, site.metaKeyword)
        && StringUtils.equals(this.metaDescription, site.metaDescription)
        && StringUtils.equals(this.copyright, site.copyright)
        && StringUtils.equals(this.statisticalCode, site.statisticalCode)
        && StringUtils.equals(this.icp, site.icp);
  }
}

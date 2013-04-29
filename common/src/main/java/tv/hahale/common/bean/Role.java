package tv.hahale.common.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * 角色
 * 
 * @author jun
 */
public class Role implements GrantedAuthority {

  private static final long serialVersionUID = -7470701733684274372L;

  public static final Role ADMIN = new Role("ROLE_ADMIN", "管理员");
  public static final Role CUSTOMER = new Role("ROLE_CUSTOMER", "客户");

  private String role;
  private String name;

  public Role() {}

  public Role(String role, String name) {
    Assert.hasText(role, "A granted authority textual representation is required");
    this.role = role;
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getAuthority() {
    return role;
  }

  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj instanceof Role) {
      return role.equals(((Role) obj).role);
    }

    return false;
  }

  public int hashCode() {
    return role.hashCode();
  }

  public String toString() {
    return role;
  }


}

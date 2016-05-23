package com.wxy.web.common.domain.code;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.wxy.web.common.domain.User;


/**
 * Created by qiuwang on 5/13/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/13/2016 01:30
 */
@Entity
public class Role {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column private String description;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Long id;

  @Column private String roleName;

  @OneToMany(
    mappedBy = "role",
    cascade  = CascadeType.ALL
  )
  private Set<User> users = new LinkedHashSet<>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role name.
   *
   * @return  String
   */
  public String getRoleName() {
    return roleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for users.
   *
   * @return  Set
   */
  public Set<User> getUsers() {
    return users;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role name.
   *
   * @param  roleName  String
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for users.
   *
   * @param  users  Set
   */
  public void setUsers(Set<User> users) {
    this.users = users;
  }
} // end class Role

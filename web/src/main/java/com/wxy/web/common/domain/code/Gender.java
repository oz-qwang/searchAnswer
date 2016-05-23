package com.wxy.web.common.domain.code;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.wxy.web.common.domain.BaseUserInfo;


/**
 * Created by qiuwang on 5/12/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/12/2016 01:18
 */
@Entity public class Gender {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @OneToMany(
    cascade  = CascadeType.ALL,
    mappedBy = "gender"
  )
  private Set<BaseUserInfo> baseUserInfos = new LinkedHashSet<>();

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Long id;

  @Column private String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for base user infos.
   *
   * @return  Set
   */
  public Set<BaseUserInfo> getBaseUserInfos() {
    return baseUserInfos;
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
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for base user infos.
   *
   * @param  baseUserInfos  Set
   */
  public void setBaseUserInfos(Set<BaseUserInfo> baseUserInfos) {
    this.baseUserInfos = baseUserInfos;
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
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }
} // end class Gender

package com.wxy.web.common.domain;

import javax.persistence.*;

import com.wxy.web.common.domain.code.Gender;


/**
 * Created by qiuwang on 5/13/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/13/2016 01:20
 */
@Entity public class BaseUserInfo extends baseDomain {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column private String description;

  @Column private String email;

  @JoinColumn(name = "genderId")
  @ManyToOne private Gender gender;
  @Column private String    headerImgPath;

// @Column private String name;

  @Column private String nickname;

  @JoinColumn(name = "userId")
  @OneToOne private User user;

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
   * getter method for email.
   *
   * @return  String
   */
  public String getEmail() {
    return email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gender.
   *
   * @return  Gender
   */
  public Gender getGender() {
    return gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for header img path.
   *
   * @return  String
   */
  public String getHeaderImgPath() {
    return headerImgPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nickname.
   *
   * @return  String
   */
  public String getNickname() {
    return nickname;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
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
   * setter method for email.
   *
   * @param  email  String
   */
  public void setEmail(String email) {
    this.email = email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gender.
   *
   * @param  gender  Gender
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for header img path.
   *
   * @param  headerImgPath  String
   */
  public void setHeaderImgPath(String headerImgPath) {
    this.headerImgPath = headerImgPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nickname.
   *
   * @param  nickname  String
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }
} // end class BaseUserInfo

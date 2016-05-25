package com.wxy.web.rest.command;

import java.util.Objects;

import org.springframework.util.StringUtils;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.User;


/**
 * Created by xinyu wei on 5/26/16.
 *
 * @author   <a href="mailto:564629989@qq.com">XinYu Wei</a>
 * @version  04/26/2016 00:14
 */
public class UserInfoCommand {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String description = "未填写";
  private String email       = "未填写";
  private String gender      = "未填写";
  private String nickname    = "未填写";

  private String username;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserInfoCommand object.
   */
  public UserInfoCommand() { }

  /**
   * Creates a new UserInfoCommand object.
   *
   * @param  user  baseUserInfo BaseUserInfo
   */
  public UserInfoCommand(User user) {
    BaseUserInfo baseUserInfo = user.getBaseUserInfo();
    this.username = user.getUsername();

    if (Objects.nonNull(baseUserInfo)) {
      if (!StringUtils.isEmpty(baseUserInfo.getNickname())) {
        this.nickname = baseUserInfo.getNickname();
      }

      if (!StringUtils.isEmpty(baseUserInfo.getEmail())) {
        this.email = baseUserInfo.getEmail();
      }

      if (!StringUtils.isEmpty(baseUserInfo.getDescription())) {
        this.description = baseUserInfo.getDescription();
      }

      if (Objects.nonNull(baseUserInfo.getGender())) {
        this.gender = baseUserInfo.getGender().getValue();
      }

    }
  }

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
   * @return  String
   */
  public String getGender() {
    return gender;
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
   * getter method for username.
   *
   * @return  String
   */
  public String getUsername() {
    return username;
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
   * @param  gender  String
   */
  public void setGender(String gender) {
    this.gender = gender;
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
   * setter method for username.
   *
   * @param  username  String
   */
  public void setUsername(String username) {
    this.username = username;
  }
} // end class UserInfoCommand

package com.wxy.web.rest.command;

/**
 * Created by xinyu wei on 5/24/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/24/2016 00:33
 */
public class UserLoginLogCommand {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String loginDateTime;
  private String nickname;

  private String username;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for login date time.
   *
   * @return  String
   */
  public String getLoginDateTime() {
    return loginDateTime;
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
   * setter method for login date time.
   *
   * @param  loginDateTime  String
   */
  public void setLoginDateTime(String loginDateTime) {
    this.loginDateTime = loginDateTime;
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
} // end class UserLoginLogCommand

package com.wxy.web.rest.service;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.User;


/**
 * Created by xinyu wei on 5/17/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/17/2016 23:47
 */
public interface UserService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createOrdinaryUser.
   *
   * @param  username  String
   * @param  password  String
   */
  void createOrdinaryUser(String username, String password);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findById.
   *
   * @param   userId  Long
   *
   * @return  User
   */
  User findById(Long userId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByUsername.
   *
   * @param   username  String
   *
   * @return  User
   */
  User findByUsername(String username);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByUsernameAndPassword.
   *
   * @param   username  String
   * @param   password  String
   *
   * @return  User
   */
  User findByUsernameAndPassword(String username, String password);

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * save.
   *
   * @param  user  User
   */
  void save(User user);

} // end interface UserService

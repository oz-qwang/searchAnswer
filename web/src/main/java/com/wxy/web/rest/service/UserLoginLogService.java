package com.wxy.web.rest.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.wxy.web.common.domain.UserLoginLog;


/**
 * Created by qiuwang on 5/23/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/23/2016 00:57
 */
public interface UserLoginLogService {
  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * findAllCount.
   *
   * @return  Long
   */
  Long findAllCount();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByPage.
   *
   * @param   username  String
   * @param   pageNum   Integer
   *
   * @return  Page
   */
  List<UserLoginLog> findByPage(String username, Integer pageNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param  userLoginLog  UserLoginLog
   */
  void save(UserLoginLog userLoginLog);
} // end interface UserLoginLogService

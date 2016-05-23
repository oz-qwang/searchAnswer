package com.wxy.web.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.UserLoginLog;
import com.wxy.web.common.repository.UserLoginLogRespository;
import com.wxy.web.rest.service.UserLoginLogService;


/**
 * Created by qiuwang on 5/23/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/23/2016 01:01
 */
@Service public class UserLoginLogServiceImpl implements UserLoginLogService {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Integer PER_PAGE_SIZE = 10;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private UserLoginLogRespository userLoginLogRespository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByPage.
   *
   * @param   pageNum  int
   *
   * @return  findByPage.
   */
  @Override public Page<UserLoginLog> findByPage(Integer pageNum) {
    return userLoginLogRespository.findAll(new PageRequest(pageNum - 1, PER_PAGE_SIZE));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserLoginLogService#save(com.wxy.web.common.domain.UserLoginLog)
   */
  @Override public void save(UserLoginLog userLoginLog) {
    userLoginLogRespository.save(userLoginLog);
  }
} // end class UserLoginLogServiceImpl

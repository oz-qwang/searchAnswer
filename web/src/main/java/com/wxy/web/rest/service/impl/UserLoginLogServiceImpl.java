package com.wxy.web.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.UserLoginLog;
import com.wxy.web.common.repository.UserLoginLogCustomRespository;
import com.wxy.web.common.repository.UserLoginLogRespository;
import com.wxy.web.rest.service.UserLoginLogService;


/**
 * Created by xinyu wei on 5/23/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/23/2016 01:01
 */
@Service public class UserLoginLogServiceImpl implements UserLoginLogService {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Integer PER_PAGE_SIZE = 15;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private UserLoginLogCustomRespository userLoginLogCustomRespository;

  @Autowired private UserLoginLogRespository userLoginLogRespository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserLoginLogService#findAllCount()
   */
  @Override public Long findAllCount() {
    return userLoginLogRespository.count();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserLoginLogService#findByPage(java.lang.String, java.lang.Integer)
   */
  @Override public List<UserLoginLog> findByPage(String username, Integer pageNum) {
    return userLoginLogCustomRespository.findByUsernameForPage("%"+username+"%", (pageNum - 1) * PER_PAGE_SIZE,
        pageNum * PER_PAGE_SIZE);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserLoginLogService#save(com.wxy.web.common.domain.UserLoginLog)
   */
  @Override public void save(UserLoginLog userLoginLog) {
    userLoginLogRespository.save(userLoginLog);
  }
} // end class UserLoginLogServiceImpl

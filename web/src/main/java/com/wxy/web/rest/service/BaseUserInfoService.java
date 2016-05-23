package com.wxy.web.rest.service;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.User;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/20/2016 01:09
 */
public interface BaseUserInfoService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param  baseUserInfo  BaseUserInfo
   */
  void save(BaseUserInfo baseUserInfo);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveForGenderId.
   *
   * @param  user          User
   * @param  baseUserInfo  BaseUserInfo
   * @param  genderId      Long
   */
  void saveOrUpdateBaseUserInfo(User user, BaseUserInfo baseUserInfo, Long genderId);

}

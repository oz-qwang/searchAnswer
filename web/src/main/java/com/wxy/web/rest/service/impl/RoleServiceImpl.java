package com.wxy.web.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.code.Role;
import com.wxy.web.common.repository.RoleRespository;
import com.wxy.web.rest.service.RoleService;


/**
 * Created by xinyu wei on 5/17/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/17/2016 23:50
 */
@Service public class RoleServiceImpl implements RoleService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired RoleRespository roleRespository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.RoleService#findById(java.lang.Long)
   */
  @Override public Role findById(Long id) {
    return roleRespository.getOne(id);
  }
}

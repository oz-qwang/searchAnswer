package com.wxy.web.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.code.Role;
import com.wxy.web.common.repository.RoleRespository;
import com.wxy.web.rest.service.RoleService;


/**
 * Created by qiuwang on 5/17/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/17/2016 23:50
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

package com.wxy.web.rest.service;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.code.Role;


/**
 * Created by xinyu wei on 5/17/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/17/2016 23:49
 */
public interface RoleService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findById.
   *
   * @param   id  Long
   *
   * @return  Role
   */
  Role findById(Long id);
}

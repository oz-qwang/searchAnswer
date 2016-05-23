package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.code.Role;


/**
 * Created by qiuwang on 5/17/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/17/2016 23:52
 */
public interface RoleRespository extends JpaRepository<Role, Long> { }

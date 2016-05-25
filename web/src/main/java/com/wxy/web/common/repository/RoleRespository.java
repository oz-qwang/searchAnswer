package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.code.Role;


/**
 * Created by xinyu wei on 5/17/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/17/2016 23:52
 */
public interface RoleRespository extends JpaRepository<Role, Long> { }

package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.UserLoginLog;


/**
 * Created by xinyu wei on 5/23/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/23/2016 22:48
 */
public interface UserLoginLogRespository extends JpaRepository<UserLoginLog, Long> { }

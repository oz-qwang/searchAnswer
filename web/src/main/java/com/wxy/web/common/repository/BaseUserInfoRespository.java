package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.BaseUserInfo;


/**
 * Created by xinyu wei on 5/19/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/19/2016 22:34
 */
public interface BaseUserInfoRespository extends JpaRepository<BaseUserInfo, Long> { }

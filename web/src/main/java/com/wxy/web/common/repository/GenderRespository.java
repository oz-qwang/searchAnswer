package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.code.Gender;


/**
 * Created by qiuwang on 5/19/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/19/2016 22:34
 */
public interface GenderRespository extends JpaRepository<Gender, Long> { }

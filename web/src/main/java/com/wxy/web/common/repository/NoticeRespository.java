package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.Notice;


/**
 * Created by xinyu wei on 5/23/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/23/2016 00:00
 */
public interface NoticeRespository extends JpaRepository<Notice, Long> { }

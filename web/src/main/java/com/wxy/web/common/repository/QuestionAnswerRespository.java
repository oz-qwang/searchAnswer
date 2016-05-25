package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.QuestionAnswer;


/**
 * Created by xinyu wei on 5/22/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/22/2016 22:30
 */
public interface QuestionAnswerRespository extends JpaRepository<QuestionAnswer, Long> { }

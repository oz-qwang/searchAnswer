package com.wxy.web.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.QuestionAnswer;


/**
 * Created by qiuwang on 5/22/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/22/2016 22:30
 */
public interface QuestionAnswerRespository extends JpaRepository<QuestionAnswer, Long> { }

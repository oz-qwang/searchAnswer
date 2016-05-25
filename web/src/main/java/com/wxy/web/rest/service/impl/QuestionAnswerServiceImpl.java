package com.wxy.web.rest.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.QuestionAnswer;
import com.wxy.web.common.domain.User;
import com.wxy.web.common.repository.QuestionAnswerRespository;
import com.wxy.web.rest.service.QuestionAnswerService;
import com.wxy.web.rest.service.QuestionService;


/**
 * Created by xinyu wei on 5/22/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/22/2016 22:31
 */
@Service public class QuestionAnswerServiceImpl implements QuestionAnswerService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private QuestionAnswerRespository questionAnswerRespository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.QuestionAnswerService#save(com.wxy.web.common.domain.QuestionAnswer, com.wxy.web.common.domain.User)
   */
  @Override public QuestionAnswer save(QuestionAnswer questionAnswer, User user) {
    questionAnswer.setCreater(user);
    questionAnswer.setCreateDate(new Date());
    questionAnswer.setLastUpdater(user);
    questionAnswer.setLastUpdateDate(new Date());
    questionAnswer =   questionAnswerRespository.save(questionAnswer);

    return questionAnswer;
  }


}

package com.wxy.web.rest.service;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.QuestionAnswer;
import com.wxy.web.common.domain.User;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/20/2016 01:09
 */
public interface QuestionAnswerService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param  questionAnswer  QuestionAnswer
   * @param  user            User
   */
  QuestionAnswer save(QuestionAnswer questionAnswer, User user);


}

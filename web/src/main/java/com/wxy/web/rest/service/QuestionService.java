package com.wxy.web.rest.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wxy.web.common.domain.Question;
import com.wxy.web.common.domain.User;


/**
 * Created by qiuwang on 5/22/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/22/2016 15:41
 */
public interface QuestionService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param  question  Question
   * @param  user      User
   */
  void create(Question question, User user);

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * findById.
   *
   * @param   id  Long
   *
   * @return  Question
   */
  Question findById(Long id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findQuestionsForPage.
   *
   * @param   pageNum  int
   * @param   title    searchKeyword String
   *
   * @return  Page
   */
  Page<Question> findQuestionsForPage(int pageNum, String title);

} // end interface QuestionService

package com.wxy.web.rest.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import com.wxy.web.common.domain.Question;
import com.wxy.web.common.domain.User;
import com.wxy.web.common.repository.QuestionRepository;
import com.wxy.web.rest.service.QuestionService;


/**
 * Created by qiuwang on 5/22/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/22/2016 15:41
 */
@Service public class QuestionServiceImpl implements QuestionService {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final int PER_PAGE_SIZE = 5;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired QuestionRepository questionRepository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * create.
   *
   * @param  question  Question
   * @param  user      User
   */
  @Override public void create(Question question, User user) {
    question.setCreater(user);
    question.setCreateDate(new Date());
    question.setLastUpdater(user);
    question.setLastUpdateDate(new Date());
    questionRepository.save(question);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.QuestionService#findById(java.lang.Long)
   */
  @Override public Question findById(Long id) {
    return questionRepository.getOne(id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.QuestionService#findQuestionsForPage(int, java.lang.String)
   */
  @Override public Page<Question> findQuestionsForPage(int pageNum, String title) {
    if (!StringUtils.isEmpty(title)) {
      return questionRepository.findByTitleLike("%" + title + "%", new PageRequest(pageNum - 1, PER_PAGE_SIZE));
    }

    return questionRepository.findAll(new PageRequest(pageNum - 1, PER_PAGE_SIZE));
  }
} // end class QuestionServiceImpl

package com.wxy.web.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wxy.web.common.domain.Question;


/**
 * Created by qiuwang on 5/22/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/22/2016 15:40
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByTitleLike.
   *
   * @param   name      String
   * @param   pageable  pageRequest PageRequest
   *
   * @return  Page
   */
  Page<Question> findByTitleLike(String name, Pageable pageable);


}

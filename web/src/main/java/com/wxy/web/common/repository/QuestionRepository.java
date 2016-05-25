package com.wxy.web.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.wxy.web.common.domain.Question;


/**
 * Created by xinyu wei on 5/22/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/22/2016 15:40
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

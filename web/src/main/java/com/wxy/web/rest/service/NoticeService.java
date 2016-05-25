package com.wxy.web.rest.service;

import java.util.List;

import com.wxy.web.common.domain.Notice;
import com.wxy.web.common.domain.User;


/**
 * Created by xinyu wei on 5/23/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/23/2016 00:05
 */
public interface NoticeService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findAll.
   *
   * @return  List
   */
  List<Notice> findAll();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param  notice  Notice
   * @param  user    User
   */
  void save(Notice notice, User user);
}

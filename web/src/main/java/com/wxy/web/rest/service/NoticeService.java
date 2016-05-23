package com.wxy.web.rest.service;

import java.util.List;

import com.wxy.web.common.domain.Notice;
import com.wxy.web.common.domain.User;


/**
 * Created by qiuwang on 5/23/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/23/2016 00:05
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

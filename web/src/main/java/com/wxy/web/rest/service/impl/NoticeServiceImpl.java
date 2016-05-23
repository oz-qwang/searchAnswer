package com.wxy.web.rest.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.Notice;
import com.wxy.web.common.domain.User;
import com.wxy.web.common.repository.NoticeRespository;
import com.wxy.web.rest.service.NoticeService;


/**
 * Created by qiuwang on 5/23/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/23/2016 00:03
 */
@Service public class NoticeServiceImpl implements NoticeService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired NoticeRespository noticeRespository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.NoticeService#findAll()
   */
  @Override public List<Notice> findAll() {
    return noticeRespository.findAll();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.NoticeService#save(com.wxy.web.common.domain.Notice, com.wxy.web.common.domain.User)
   */
  @Override public void save(Notice notice, User user) {
    notice.setCreater(user);
    notice.setCreateDate(new Date());
    notice.setLastUpdater(user);
    notice.setLastUpdateDate(new Date());
    noticeRespository.save(notice);
  }
} // end class NoticeServiceImpl

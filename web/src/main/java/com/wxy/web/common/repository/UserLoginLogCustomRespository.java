package com.wxy.web.common.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.wxy.web.common.domain.UserLoginLog;


/**
 * Created by xinyu wei on 5/23/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/23/2016 00:55
 */
@Repository public class UserLoginLogCustomRespository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired EntityManagerFactory entityManagerFactory;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByUsernameForPage.
   *
   * @param   username  String
   * @param   start     int
   * @param   end       int
   *
   * @return  List
   */
  public List<UserLoginLog> findByUsernameForPage(String username, int start, int end) {
    String hql = "FROM UserLoginLog u WHERE  u.user.username LIKE ?1";

    return entityManagerFactory.createEntityManager().createQuery(hql).setParameter(1, username)
      .setFirstResult(start).setMaxResults(end).getResultList();
  }

} // end class UserLoginLogCustomRespository

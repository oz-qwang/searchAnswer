package com.wxy.web.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxy.web.common.domain.User;


/**
 * Created by qiuwang on 5/12/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/12/2016 02:04
 */
public interface UserRepository extends JpaRepository<User, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByUsername.
   *
   * @param   username  String
   *
   * @return  List
   */
  List<User> findByUsername(String username);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByUsernameAndPassword.
   *
   * @param   username  String
   * @param   password  String
   *
   * @return  List
   */
  List<User> findByUsernameAndPassword(String username, String password);

} // end interface UserRepository

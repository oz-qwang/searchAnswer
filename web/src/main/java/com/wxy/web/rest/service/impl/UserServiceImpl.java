package com.wxy.web.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.User;
import com.wxy.web.common.repository.GenderRespository;
import com.wxy.web.common.repository.RoleRespository;
import com.wxy.web.common.repository.UserRepository;
import com.wxy.web.rest.service.UserService;


/**
 * Created by qiuwang on 5/17/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/17/2016 23:53
 */
@Service public class UserServiceImpl implements UserService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired RoleRespository roleRespository;

  /** TODO: DOCUMENT ME! */
  @Autowired UserRepository userRepository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserService#createOrdinaryUser(java.lang.String, java.lang.String)
   */
  @Override public void createOrdinaryUser(String username, String password) {
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);
    newUser.setRole(roleRespository.findOne(2L));
    userRepository.save(newUser);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserService#findById(java.lang.Long)
   */
  @Override public User findById(Long userId) {
    return userRepository.getOne(userId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserService#findByUsername(java.lang.String)
   */
  @Override public User findByUsername(String username) {
    List<User> users = userRepository.findByUsername(username);

    return (users.size() == 0) ? null : users.get(0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserService#findByUsernameAndPassword(java.lang.String, java.lang.String)
   */
  @Override public User findByUsernameAndPassword(String username, String password) {
    List<User> users = userRepository.findByUsernameAndPassword(username, password);

    return (users.size() == 0) ? null : users.get(0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.wxy.web.rest.service.UserService#save(com.wxy.web.common.domain.User)
   */
  @Override public void save(User user) {
    userRepository.save(user);
  }


} // end class UserServiceImpl

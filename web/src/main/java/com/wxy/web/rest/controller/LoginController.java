package com.wxy.web.rest.controller;

import java.util.Date;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wxy.web.common.domain.User;
import com.wxy.web.common.domain.UserLoginLog;
import com.wxy.web.rest.command.BaseCommand;
import com.wxy.web.rest.service.RoleService;
import com.wxy.web.rest.service.UserLoginLogService;
import com.wxy.web.rest.service.UserService;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/12/2016 00:03
 */
@RequestMapping @RestController public class LoginController {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired RoleService roleService;

  /** TODO: DOCUMENT ME! */
  @Autowired UserLoginLogService userLoginLogService;

  /** TODO: DOCUMENT ME! */
  @Autowired UserService userService;

  private final Log logger = LogFactory.getLog(this.getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * login.
   *
   * @return  String
   */
  @RequestMapping("/login")
  public ModelAndView goLoginPage() {
    return new ModelAndView("login");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * login.
   *
   * @param   username  String
   * @param   password  String
   * @param   session   HttpSession
   *
   * @return  BaseCommand
   */
  @RequestMapping("/userLogin")
  public BaseCommand login(String username, String password, HttpSession session) {
    Boolean success = true;

    if (Objects.isNull(session.getAttribute("user"))) {
      User user = userService.findByUsernameAndPassword(username, password);

      if (Objects.nonNull(user)) {
        session.setAttribute("user", user);

        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setLoginTime(new Date());
        userLoginLog.setUser(user);
        userLoginLogService.save(userLoginLog);

        if (user.getRole().getId() == 1) {
          session.setAttribute("isAdmin", true);
        } else {
          session.setAttribute("isAdmin", false);
        }
      } else {
        success = false;
      }
    }

    return new BaseCommand(success);
  } // end method login

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * logout.
   *
   * @param   session  HttpSession
   *
   * @return  String
   */
  @RequestMapping("/logout")
  public ModelAndView logout(HttpSession session) {
    session.removeAttribute("user");
    session.removeAttribute("isAdmin");

    return new ModelAndView("redirect:login");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  @RequestMapping("userRegist")
  private BaseCommand regist(String username, String password) {
    Boolean success = true;

    User user = userService.findByUsername(username);

    if (Objects.nonNull(user)) {
      success = false;
    } else {
      userService.createOrdinaryUser(username, password);
    }

    return new BaseCommand(success);

  } // end method regist
} // end class LoginController

package com.wxy.web.rest.controller;

import java.io.File;
import java.io.IOException;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.util.FileCopyUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.User;
import com.wxy.web.rest.command.BaseCommand;
import com.wxy.web.rest.command.UserInfoCommand;
import com.wxy.web.rest.service.BaseUserInfoService;
import com.wxy.web.rest.service.UserService;


/**
 * Created by xinyu wei on 5/19/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/19/2016 00:57
 */
@Controller
@RequestMapping("/user/info")
public class UserController {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** goUserMainPage. */

  @Autowired Environment environment;

  @Autowired private BaseUserInfoService baseUserInfoService;


  @Autowired private UserService userService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * goMaodifyUserInfoPage.
   *
   * @param   session  HttpSession
   * @param   model    Model
   *
   * @return  ModelAndView
   */
  @RequestMapping(
    value  = "/modifyBaseInfo",
    method = RequestMethod.GET
  )
  public String goMaodifyUserInfoPage(HttpSession session, Model model) {
    BaseUserInfo userInfo     = userService.findById(((User) session.getAttribute("user")).getId()).getBaseUserInfo();
    int          initGenderId = 1;

    if (Objects.nonNull(userInfo) && Objects.nonNull(userInfo.getGender()) && (userInfo.getGender().getId() == 2)) {
      initGenderId = 2;
    }

    model.addAttribute("initGenderId", initGenderId);
    model.addAttribute("userInfo", userInfo);

    return "modifyUserInfo";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goModifyUserMoidfyHeader.
   *
   * @param   session  HttpSession
   * @param   model    Model
   *
   * @return  String
   */
  @RequestMapping(
    value  = "/moidfyHeader",
    method = RequestMethod.GET
  )
  public String goModifyUserMoidfyHeader(HttpSession session, Model model) {
    model.addAttribute("userHeaderPath", getUserHeaderPath(session));

    return "modifyUserHeader";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goModifyUserMoidfyHeaderBySwf.
   *
   * @param   session  HttpSession
   * @param   model    Model
   *
   * @return  String
   */
  @RequestMapping public String goModifyUserMoidfyHeaderBySwf(HttpSession session, Model model) {
    return goModifyUserMoidfyHeader(session, model);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goModifyUserPassword.
   *
   * @return  String
   */
  @RequestMapping(
    path   = "/moidfyPassword",
    method = RequestMethod.GET
  )
  public String goModifyUserPassword() {
    return "modifyUserPassword";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goUserMainPage.
   *
   * @param   model    Model
   * @param   session  HttpSession
   *
   * @return  ModelAndView
   */
  @RequestMapping("/userMain")
  public String goUserMainPage(Model model, HttpSession session) {
    User user = userService.findById(((User) session.getAttribute("user")).getId());

    model.addAttribute("userInfo", new UserInfoCommand(user));

    model.addAttribute("userHeaderPath", getUserHeaderPath(session));

    return "userMain";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * modifyUserInfo.
   *
   * @param   session       HttpSession
   * @param   baseUserInfo  BaseUserInfo
   * @param   genderId      Long
   *
   * @return  String
   */
  @RequestMapping(
    path   = "/modifyBaseInfo",
    method = RequestMethod.POST
  )
  public String modifyUserInfo(HttpSession session, BaseUserInfo baseUserInfo, Long genderId,Model model) {
    baseUserInfoService.saveOrUpdateBaseUserInfo((User) session.getAttribute("user"), baseUserInfo, genderId);

    User user = userService.findById(((User) session.getAttribute("user")).getId());

    model.addAttribute("userInfo", new UserInfoCommand(user));

    model.addAttribute("userHeaderPath", getUserHeaderPath(session));

    return "userMain";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * modifyUserMoidfyHeader.
   *
   * @param   session  response HttpServletResponse
   * @param   file     MultipartFile
   *
   * @return  BaseCommand
   *
   * @throws  IOException  exception
   */
  @RequestMapping(
    value  = "/modifyUserMoidfyHeader",
    method = RequestMethod.POST
  )
  @ResponseBody public BaseCommand modifyUserMoidfyHeader(HttpSession session,
    @RequestParam(
      value    = "file",
      required = false
    ) MultipartFile file) throws IOException {
    byte[] bytes     = file.getBytes();
    String uploadDir = environment.getProperty("custom.uploadpath");
    File   dirPath   = new File(uploadDir);

    if (!dirPath.exists()) {
      dirPath.mkdirs();
    }

    String sep          = System.getProperty("file.separator");
    File   uploadedFile = new File(uploadDir + sep
        + file.getOriginalFilename());
    FileCopyUtils.copy(bytes, uploadedFile);

    User loginedUser = userService.findById(((User) session.getAttribute("user")).getId());

    BaseUserInfo baseUserInfo = loginedUser.getBaseUserInfo();

    if (baseUserInfo == null) {
      baseUserInfo = new BaseUserInfo();
      baseUserInfo.setUser(loginedUser);
    }

    String uploadedRelativePath = "/upload/" + file.getOriginalFilename();
    baseUserInfo.setHeaderImgPath(uploadedRelativePath);
    baseUserInfoService.save(baseUserInfo);

    return new BaseCommand(uploadedRelativePath, true);
  } // end method modifyUserMoidfyHeader

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * modifyUserPassword.
   *
   * @param   session          HttpSession
   * @param   currentPassword  String
   * @param   newPassword      String
   *
   * @return  String
   */
  @RequestMapping(
    path   = "/moidfyPassword",
    method = RequestMethod.POST
  )
  @ResponseBody public BaseCommand modifyUserPassword(HttpSession session, String currentPassword, String newPassword) {
    String  message     = "修改成功";
    Boolean success     = true;
    User    loginedUser = (User) session.getAttribute("user");

    if (!loginedUser.getPassword().equals(currentPassword)) {
      success = false;
      message = "原始密码错误,修改失败!";
    } else if (currentPassword.equals(newPassword)) {
      success = false;
      message = "新密码不能与原始密码相同!";
    } else {
      loginedUser = userService.findById(loginedUser.getId());
      loginedUser.setPassword(newPassword);
      userService.save(loginedUser);
      session.setAttribute("user", loginedUser);

    }

    return new BaseCommand(message, success);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String getUserHeaderPath(HttpSession session) {
    User         loginedUser    = userService.findById(((User) session.getAttribute("user")).getId());
    BaseUserInfo baseUserInfo   = loginedUser.getBaseUserInfo();
    String       userHeaderPath = null;

    if (Objects.nonNull(baseUserInfo)) {
      userHeaderPath = baseUserInfo.getHeaderImgPath();
    }

    return userHeaderPath;
  }
} // end class UserController

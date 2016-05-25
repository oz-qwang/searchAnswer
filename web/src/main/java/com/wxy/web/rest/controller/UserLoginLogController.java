package com.wxy.web.rest.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.datetime.DateFormatter;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxy.web.rest.command.UserLoginLogCommand;
import com.wxy.web.rest.command.UserLoginLogPageCommand;
import com.wxy.web.rest.service.UserLoginLogService;


/**
 * Created by xinyu wei on 5/23/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/23/2016 01:33
 */
@Controller
@RequestMapping("/userLoginLog")
public class UserLoginLogController {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private UserLoginLogService userLoginLogService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * goListPage.
   *
   * @return  String
   */
  @RequestMapping("/list")
  public String goListPage() {
    return "userLoginLog";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * searchByPage.
   *
   * @param   search  String
   * @param   limit   Integer
   * @param   offset  Integer
   *
   * @return  String
   */
  @RequestMapping("/search")
  @ResponseBody public UserLoginLogPageCommand searchByPage(String search, Integer limit, Integer offset) {
    int pageNum = 1;

    if (Objects.isNull(search)) {
      search = "";
    }

    if (Objects.nonNull(offset) && Objects.nonNull(limit)) {
      pageNum = (offset / limit) + 1;
    }

    String                    nickname             = "匿名";
    List<UserLoginLogCommand> userLoginLogCommands = new ArrayList<>();
    userLoginLogService.findByPage(search, pageNum).forEach(userLoginLog -> {
      UserLoginLogCommand userLoginLogCommand = new UserLoginLogCommand();

      if (Objects.nonNull(userLoginLog.getUser().getBaseUserInfo())
            && Objects.nonNull(userLoginLog.getUser().getBaseUserInfo().getNickname())) {
        userLoginLogCommand.setNickname(userLoginLog.getUser().getBaseUserInfo().getNickname());
      } else {
        userLoginLogCommand.setNickname(nickname);
      }

      userLoginLogCommand.setLoginDateTime(DATE_FORMAT.format(userLoginLog.getLoginTime()));
      userLoginLogCommand.setUsername(userLoginLog.getUser().getUsername());
      userLoginLogCommands.add(userLoginLogCommand);
    });

    return new UserLoginLogPageCommand(userLoginLogCommands,
        userLoginLogService.findAllCount());

  } // end method searchByPage
} // end class UserLoginLogController

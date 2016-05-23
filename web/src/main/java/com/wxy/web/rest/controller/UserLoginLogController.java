package com.wxy.web.rest.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by qiuwang on 5/23/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/23/2016 01:33
 */
@Controller
@RequestMapping("/userLoginLog")
public class UserLoginLogController {
  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * listAllByPage.
   *
   * @return  String
   */
  @RequestMapping("/list")
  public String listAllByPage() {
    return "userLoginLog";
  }
}

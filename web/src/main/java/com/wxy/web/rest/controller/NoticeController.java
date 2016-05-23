package com.wxy.web.rest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxy.web.common.domain.Notice;
import com.wxy.web.common.domain.User;
import com.wxy.web.rest.command.BaseCommand;
import com.wxy.web.rest.service.NoticeService;


/**
 * Created by qiuwang on 5/23/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/23/2016 00:07
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired NoticeService noticeService;

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * findAllNotice.
   *
   * @return  List
   */
  @RequestMapping("/list")
   public String findAllNotice(Model model) {
    model.addAttribute("noticeList",noticeService.findAll());
    return "noticeList";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveNotice.
   *
   * @param   session  HttpSession
   * @param   notice   Notice
   *
   * @return  BaseCommand
   */
  @RequestMapping(value = "/publish",method = RequestMethod.POST)
  @ResponseBody
  public BaseCommand publishNotice(HttpSession session, Notice notice) {
    noticeService.save(notice, (User) session.getAttribute("user"));

    return new BaseCommand(true);
  }

    @RequestMapping(value = "/publish",method = RequestMethod.GET)
    public String  publishNotice() {

        return "publishNotice";
    }
} // end class NoticeController

package com.wxy.web.rest.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxy.web.common.domain.Question;
import com.wxy.web.common.domain.QuestionAnswer;
import com.wxy.web.common.domain.User;
import com.wxy.web.rest.command.AnswerCommand;
import com.wxy.web.rest.command.BaseCommand;
import com.wxy.web.rest.command.QuestionAnswerCommand;
import com.wxy.web.rest.command.QuestionCommand;
import com.wxy.web.rest.service.QuestionAnswerService;
import com.wxy.web.rest.service.QuestionService;
import com.wxy.web.rest.service.UserService;


/**
 * Created by qiuwang on 5/18/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/18/2016 01:12
 */
@Controller
@RequestMapping("/question")
public class QuestionAnswerController {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final String DEFAULT_HEADER_IMAGE_PATH = "/img/default-avatar.png";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired QuestionAnswerService questionAnswerService;

  /** TODO: DOCUMENT ME! */
  @Autowired QuestionService questionService;

  /** TODO: DOCUMENT ME! */
  @Autowired UserService userService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * anserQuestion.
   *
   * @param   session     HttpSession
   * @param   answer      String
   * @param   questionId  Long
   *
   * @return  BaseCommand
   */
  @RequestMapping("/questionAnswer/comment")
  @ResponseBody public BaseCommand anserQuestion(HttpSession session, String answer, Long questionId) {
    QuestionAnswer questionAnswer = new QuestionAnswer();
    User           loginedUser    = (User) session.getAttribute("user");
    questionAnswer.setUser(loginedUser);
    questionAnswer.setAnswer(answer);
    questionAnswer.setQuestion(questionService.findById(questionId));
    questionAnswer = questionAnswerService.save(questionAnswer, loginedUser);


    AnswerCommand answerCommand = new AnswerCommand();
    answerCommand.setAnswer(questionAnswer.getAnswer());
    answerCommand.setCommentDate(new SimpleDateFormat("yyyy.MM-dd HH:mm:ss").format(questionAnswer.getCreateDate()));

    String userNickname  = "匿名";
    String headerImgPath = DEFAULT_HEADER_IMAGE_PATH;

    if (!Objects.isNull(questionAnswer.getUser().getBaseUserInfo())) {
      if (!StringUtils.isEmpty(questionAnswer.getUser().getBaseUserInfo().getNickname())) {
        userNickname = questionAnswer.getUser().getBaseUserInfo().getNickname();
      }

      if (!StringUtils.isEmpty(questionAnswer.getUser().getBaseUserInfo().getHeaderImgPath())) {
        headerImgPath = questionAnswer.getUser().getBaseUserInfo().getHeaderImgPath();
      }

    }

    answerCommand.setNickname(userNickname);
    answerCommand.setHeaderImgPath(headerImgPath);

    return new BaseCommand(answerCommand, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findMoreQuestion.
   *
   * @param   title    String
   * @param   pageNum  Integer
   * @param   model    Model
   *
   * @return  String
   */
  @RequestMapping("/findMoreQuestion")
  @ResponseBody public Map<String, Object> findMoreQuestion(String title, Integer pageNum, Model model) {
    Map<String, Object> resMap = queryQuestionsByPage(pageNum, title);

    return resMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goQuestionAnswer.
   *
   * @param   questionId  Long
   * @param   model       Model
   *
   * @return  String
   */
  @RequestMapping("/answer/{questionId}")
  public String goQuestionAnswer(@PathVariable Long questionId, Model model) {
    Question              question              = questionService.findById(questionId);
    QuestionAnswerCommand questionAnswerCommand = new QuestionAnswerCommand();
    questionAnswerCommand.setContent(question.getContent());
    questionAnswerCommand.setTitle(question.getTitle());
    questionAnswerCommand.setQuestionId(questionId);

    Set<AnswerCommand> answerCommands = new HashSet<>();

    question.getQuestionAnswers().forEach(answer -> {
      AnswerCommand answerCommand = new AnswerCommand();
      answerCommand.setAnswer(answer.getAnswer());
      answerCommand.setCommentDate(new SimpleDateFormat("yyyy.MM-dd HH:mm:ss").format(answer.getCreateDate()));

      String userNickname  = "匿名";
      String headerImgPath = DEFAULT_HEADER_IMAGE_PATH;

      if (!Objects.isNull(answer.getUser().getBaseUserInfo())) {
        if (!StringUtils.isEmpty(answer.getUser().getBaseUserInfo().getNickname())) {
          userNickname = answer.getUser().getBaseUserInfo().getNickname();
        }

        if (!StringUtils.isEmpty(answer.getUser().getBaseUserInfo().getHeaderImgPath())) {
          headerImgPath = answer.getUser().getBaseUserInfo().getHeaderImgPath();
        }

      }

      answerCommand.setNickname(userNickname);
      answerCommand.setHeaderImgPath(headerImgPath);
      answerCommands.add(answerCommand);
    });
    questionAnswerCommand.setAnswerCommands(answerCommands);
    model.addAttribute("questionAnswerInfo", questionAnswerCommand);

    return "questionAnswer";
  } // end method goQuestionAnswer

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goQuestionList.
   *
   * @param   title    String
   * @param   pageNum  Integer
   * @param   model    Model
   *
   * @return  ModelAndView
   */
  @RequestMapping("/list")
  public String goQuestionList(String title, Integer pageNum, Model model) {
    Map<String, Object> resMap = queryQuestionsByPage(pageNum, title);

    model.addAttribute("questionList", resMap.get("questionList"));
    model.addAttribute("hasMore", resMap.get("hasMore"));
    model.addAttribute("nextPageNum", resMap.get("nextPageNum"));
    model.addAttribute("searchTitle", title);

    return "questionList";
  } // end method goQuestionList

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goQuestionList.
   *
   * @return  ModelAndView
   */
  @RequestMapping(
    value  = "/publish",
    method = RequestMethod.GET
  )
  public String goQuestionPublish() {
    return "publishQuestion";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * goQuestionList.
   *
   * @param   question  Question
   * @param   session   HttpSession
   *
   * @return  ModelAndView
   */
  @RequestMapping(
    value  = "/publish",
    method = RequestMethod.POST
  )
  @ResponseBody public BaseCommand publishQuestion(Question question, HttpSession session) {
    User user = userService.findById(((User) session.getAttribute("user")).getId());
    question.setUser(user);
    questionService.create(question, user);

    return new BaseCommand("发布成功", true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Map<String, Object> queryQuestionsByPage(Integer pageNum, String title) {
    Map<String, Object>   resMap           = new HashMap<>();
    List<QuestionCommand> questionCommands = new ArrayList<>();

    if (Objects.isNull(pageNum)) {
      pageNum = 1;
    }

    Page<Question> questionPage = questionService.findQuestionsForPage(pageNum, title);
    questionPage.getContent().forEach(
      question -> {
        QuestionCommand questionCommand = new QuestionCommand();
        questionCommand.setTitle(
          (question.getTitle().length() > 30) ? (question.getTitle().substring(0, 30) + "...") : question.getTitle());
        questionCommand.setContent(
          (question.getContent().length() > 200) ? (question.getContent().substring(0, 200) + "...")
                                                 : question.getContent());

        if ((question.getUser().getBaseUserInfo() == null)
              || (question.getUser().getBaseUserInfo().getHeaderImgPath() == null)) {
          questionCommand.setHeaderImgPath(DEFAULT_HEADER_IMAGE_PATH);
        } else {
          questionCommand.setHeaderImgPath(question.getUser().getBaseUserInfo().getHeaderImgPath());
        }

        questionCommand.setQuestionId(question.getId());
        questionCommands.add(questionCommand);
      });

    resMap.put("questionList", questionCommands);

    if (questionPage.getTotalPages() > pageNum) {
      resMap.put("hasMore", true);
      resMap.put("nextPageNum", pageNum + 1);
    } else {
      resMap.put("hasMore", false);
    }

    return resMap;


  } // end method queryQuestionsByPage
} // end class QuestionAnswerController

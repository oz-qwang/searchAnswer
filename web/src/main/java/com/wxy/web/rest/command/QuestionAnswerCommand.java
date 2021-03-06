package com.wxy.web.rest.command;

import java.util.List;
import java.util.Set;

import com.wxy.web.common.domain.QuestionAnswer;


/**
 * Created by xinyu wei on 5/22/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/22/2016 20:57
 */
public class QuestionAnswerCommand {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Set<AnswerCommand> answerCommands;

  private String content;

  private Long questionId;

  private String title;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer commands.
   *
   * @return  Set
   */
  public Set<AnswerCommand> getAnswerCommands() {
    return answerCommands;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content.
   *
   * @return  String
   */
  public String getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question id.
   *
   * @return  Long
   */
  public Long getQuestionId() {
    return questionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for title.
   *
   * @return  String
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer commands.
   *
   * @param  answerCommands  Set
   */
  public void setAnswerCommands(Set<AnswerCommand> answerCommands) {
    this.answerCommands = answerCommands;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content.
   *
   * @param  content  String
   */
  public void setContent(String content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question id.
   *
   * @param  questionId  Long
   */
  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for title.
   *
   * @param  title  String
   */
  public void setTitle(String title) {
    this.title = title;
  }
} // end class QuestionAnswerCommand

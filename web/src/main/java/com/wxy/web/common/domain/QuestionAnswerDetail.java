package com.wxy.web.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Created by xinyu wei on 5/15/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/15/2016 02:02
 */
@Entity public class QuestionAnswerDetail extends baseDomain {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(name = "questionAnswerId")
  @ManyToOne private QuestionAnswer questionAnswer;

  @Column(length = 1000)
  private String replyConent;


  @JoinColumn(name = "userId")
  @ManyToOne private User user;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for question answer.
   *
   * @return  QuestionAnswer
   */
  public QuestionAnswer getQuestionAnswer() {
    return questionAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reply conent.
   *
   * @return  String
   */
  public String getReplyConent() {
    return replyConent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question answer.
   *
   * @param  questionAnswer  QuestionAnswer
   */
  public void setQuestionAnswer(QuestionAnswer questionAnswer) {
    this.questionAnswer = questionAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reply conent.
   *
   * @param  replyConent  String
   */
  public void setReplyConent(String replyConent) {
    this.replyConent = replyConent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }
} // end class QuestionAnswerDetail

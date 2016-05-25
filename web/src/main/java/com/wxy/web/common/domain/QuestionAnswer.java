package com.wxy.web.common.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * Created by xinyu wei on 5/15/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/15/2016 01:40
 */
@Entity public class QuestionAnswer extends baseDomain {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(length = 1000)
  private String answer;

  @JoinColumn(name = "questionId")
  @ManyToOne private Question question;

  @OneToMany(
    mappedBy = "questionAnswer",
    cascade  = CascadeType.ALL
  )
  private Set<QuestionAnswerDetail> questionAnswerDetails = new LinkedHashSet<>();


  @JoinColumn(name = "userId")
  @ManyToOne private User user;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer.
   *
   * @return  String
   */
  public String getAnswer() {
    return answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question.
   *
   * @return  Question
   */
  public Question getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question answer details.
   *
   * @return  Set
   */
  public Set<QuestionAnswerDetail> getQuestionAnswerDetails() {
    return questionAnswerDetails;
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
   * setter method for answer.
   *
   * @param  answer  String
   */
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question.
   *
   * @param  question  Question
   */
  public void setQuestion(Question question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question answer details.
   *
   * @param  questionAnswerDetails  Set
   */
  public void setQuestionAnswerDetails(Set<QuestionAnswerDetail> questionAnswerDetails) {
    this.questionAnswerDetails = questionAnswerDetails;
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
} // end class QuestionAnswer

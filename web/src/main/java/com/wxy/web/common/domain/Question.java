package com.wxy.web.common.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.wxy.web.system.jpa.converter.StringBooleanConverter;


/**
 * Created by xinyu wei on 5/15/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/15/2016 01:08
 */
@Entity public class Question extends baseDomain {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(length = 2000)
  private String content;

  @OneToMany(
    cascade  = CascadeType.ALL,
    mappedBy = "question"
  )
  private Set<QuestionAnswer> questionAnswers = new LinkedHashSet<>();

  @Column(length = 200)
  private String title;

  @JoinColumn(name = "userId")
  @ManyToOne private User user;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for question answers.
   *
   * @return  Set
   */
  public Set<QuestionAnswer> getQuestionAnswers() {
    return questionAnswers;
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
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
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
   * setter method for question answers.
   *
   * @param  questionAnswers  Set
   */
  public void setQuestionAnswers(Set<QuestionAnswer> questionAnswers) {
    this.questionAnswers = questionAnswers;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }
} // end class Question

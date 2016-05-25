package com.wxy.web.common.domain;


import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.wxy.web.common.domain.code.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/21/2016 10:29
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class User {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @OneToOne(
    mappedBy = "user",
    cascade  = CascadeType.ALL
  )
  private BaseUserInfo baseUserInfo;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Long id;

  @Column private String password;

  @OneToMany(
    mappedBy = "user",
    cascade  = CascadeType.ALL
  )
  private Set<QuestionAnswerDetail> questionAnswerDetails = new LinkedHashSet<>();

  @OneToMany(
    mappedBy = "user",
    cascade  = CascadeType.ALL
  )
  private Set<QuestionAnswer> questionAnswers = new LinkedHashSet<>();


  @OneToMany(
    mappedBy = "user",
    cascade  = CascadeType.ALL
  )
  private Set<Question> questions = new LinkedHashSet<>();

  @JoinColumn(name = "roleId")
  @ManyToOne private Role role;

  @OneToMany(
    mappedBy = "user",
    cascade  = CascadeType.ALL
  )
  private Set<UserLoginLog> userLoginLogs = new LinkedHashSet<>();

  @Column private String username;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for base user info.
   *
   * @return  BaseUserInfo
   */
  public BaseUserInfo getBaseUserInfo() {
    return baseUserInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for password.
   *
   * @return  String
   */
  public String getPassword() {
    return password;
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
   * getter method for question answers.
   *
   * @return  Set
   */
  public Set<QuestionAnswer> getQuestionAnswers() {
    return questionAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for questions.
   *
   * @return  Set
   */
  public Set<Question> getQuestions() {
    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user login logs.
   *
   * @return  Set
   */
  public Set<UserLoginLog> getUserLoginLogs() {
    return userLoginLogs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for username.
   *
   * @return  String
   */
  public String getUsername() {
    return username;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for base user info.
   *
   * @param  baseUserInfo  BaseUserInfo
   */
  public void setBaseUserInfo(BaseUserInfo baseUserInfo) {
    this.baseUserInfo = baseUserInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for password.
   *
   * @param  password  String
   */
  public void setPassword(String password) {
    this.password = password;
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
   * setter method for question answers.
   *
   * @param  questionAnswers  Set
   */
  public void setQuestionAnswers(Set<QuestionAnswer> questionAnswers) {
    this.questionAnswers = questionAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for questions.
   *
   * @param  questions  Set
   */
  public void setQuestions(Set<Question> questions) {
    this.questions = questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user login logs.
   *
   * @param  userLoginLogs  Set
   */
  public void setUserLoginLogs(Set<UserLoginLog> userLoginLogs) {
    this.userLoginLogs = userLoginLogs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for username.
   *
   * @param  username  String
   */
  public void setUsername(String username) {
    this.username = username;
  }
} // end class User

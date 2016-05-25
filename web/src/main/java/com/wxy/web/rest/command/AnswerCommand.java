package com.wxy.web.rest.command;

import java.util.Date;


/**
 * Created by xinyu wei on 5/22/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/22/2016 21:08
 */
public class AnswerCommand {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String answer;

  private String commentDate;

  private String headerImgPath;

  private String nickname;

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
   * getter method for comment date.
   *
   * @return  String
   */
  public String getCommentDate() {
    return commentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for header img path.
   *
   * @return  String
   */
  public String getHeaderImgPath() {
    return headerImgPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nickname.
   *
   * @return  String
   */
  public String getNickname() {
    return nickname;
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
   * setter method for comment date.
   *
   * @param  commentDate  String
   */
  public void setCommentDate(String commentDate) {
    this.commentDate = commentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for header img path.
   *
   * @param  headerImgPath  String
   */
  public void setHeaderImgPath(String headerImgPath) {
    this.headerImgPath = headerImgPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nickname.
   *
   * @param  nickname  String
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
} // end class AnswerCommand

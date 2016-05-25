package com.wxy.web.rest.command;

/**
 * Created by xinyu wei on 5/22/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/22/2016 16:48
 */
public class QuestionCommand {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String content;

  private String headerImgPath;

  private Long questionId;

  private String title;

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
   * getter method for header img path.
   *
   * @return  String
   */
  public String getHeaderImgPath() {
    return headerImgPath;
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
   * setter method for content.
   *
   * @param  content  String
   */
  public void setContent(String content) {
    this.content = content;
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
} // end class QuestionCommand

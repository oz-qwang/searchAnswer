package com.wxy.web.common.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * Created by xinyu wei on 5/22/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/23/2016 00:00
 */
@Entity
public class Notice extends baseDomain {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(length = 1000)
  private String content;

  @Column(length = 100)
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
   * setter method for title.
   *
   * @param  title  String
   */
  public void setTitle(String title) {
    this.title = title;
  }
} // end class Notice

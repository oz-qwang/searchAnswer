package com.wxy.web.rest.command;

import java.util.List;

import com.wxy.web.common.domain.UserLoginLog;


/**
 * Created by qiuwang on 5/23/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/23/2016 21:53
 */
public class UserLoginLogPageCommand {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private List<UserLoginLogCommand> rows;

  private Long total;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserLoginLogPageCommand object.
   */
  public UserLoginLogPageCommand() { }

  /**
   * Creates a new UserLoginLogPageCommand object.
   *
   * @param  rows   List
   * @param  total  Long
   */
  public UserLoginLogPageCommand(List<UserLoginLogCommand> rows, Long total) {
    this.rows  = rows;
    this.total = total;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for rows.
   *
   * @return  List
   */
  public List<UserLoginLogCommand> getRows() {
    return rows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total.
   *
   * @return  Long
   */
  public Long getTotal() {
    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rows.
   *
   * @param  rows  List
   */
  public void setRows(List<UserLoginLogCommand> rows) {
    this.rows = rows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total.
   *
   * @param  total  Long
   */
  public void setTotal(Long total) {
    this.total = total;
  }
} // end class UserLoginLogPageCommand

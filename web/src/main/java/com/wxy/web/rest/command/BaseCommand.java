package com.wxy.web.rest.command;

import java.io.Serializable;

import java.util.Map;


/**
 * Created by qiuwang on 5/12/16.
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/12/2016 00:56
 */
public class BaseCommand {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Object data;

  private Boolean success;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseCommand object.
   */
  public BaseCommand() { }


  /**
   * Creates a new BaseCommand object.
   *
   * @param  success  Boolean
   */
  public BaseCommand(Boolean success) {
    this.success = success;
  }

  /**
   * Creates a new BaseCommand object.
   *
   * @param  data     Object
   * @param  success  Boolean
   */
  public BaseCommand(Object data, Boolean success) {
    this.data    = data;
    this.success = success;
  }

  /**
   * Creates a new BaseCommand object.
   *
   * @param  data     Object
   * @param  message  String
   * @param  success  Boolean
   */
  public BaseCommand(Object data, String message, Boolean success) {
    this.data    = data;
    this.success = success;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for data.
   *
   * @return  Object
   */
  public Object getData() {
    return data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message.
   *
   * @return  String
   */

  /**
   * getter method for success.
   *
   * @return  Boolean
   */
  public Boolean getSuccess() {
    return success;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data.
   *
   * @param  data  Map
   */
  public void setData(Map data) {
    this.data = data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data.
   *
   * @param  data  Object
   */
  public void setData(Object data) {
    this.data = data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for success.
   *
   * @param  success  Boolean
   */
  public void setSuccess(Boolean success) {
    this.success = success;
  }
} // end class BaseCommand

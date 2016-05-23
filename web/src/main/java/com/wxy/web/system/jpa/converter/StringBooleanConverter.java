package com.wxy.web.system.jpa.converter;

import javax.persistence.AttributeConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version  05/15/2016 01:35
 */
public class StringBooleanConverter implements AttributeConverter<Boolean, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * @see  javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Boolean)
   */
  @Override public String convertToDatabaseColumn(Boolean b) {
    if (b == null) {
      return null;
    }

    if (b.booleanValue()) {
      return "Y";
    }

    return "N";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.String)
   */
  @Override public Boolean convertToEntityAttribute(String s) {
    if (s == null) {
      return null;
    }

    if (s.equals("Y") || s.equals("y")) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

} // end class StringBooleanConverter

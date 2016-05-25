package com.wxy.web.rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:564629989@qq.com">XinYu Wei</a>
 * @version  04/26/2016 00:32
 */
@Controller @RequestMapping public class UploaedImgController {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private Environment environment;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for image.
   *
   * @param  imgName   String
   * @param  response  HttpServletResponse
   */
  @RequestMapping(value = "/upload/{imgName:.+}")
  public void getImage(@PathVariable("imgName") String imgName, HttpServletResponse response) {
    response.setContentType("image/gif;image/png");

    try(OutputStream out = response.getOutputStream();
          FileInputStream fis = new FileInputStream(
              new File(environment.getProperty("custom.uploadpath") + File.separator + imgName));
    ) {
      byte[] b = new byte[fis.available()];
      fis.read(b);
      out.write(b);
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

} // end class UploaedImgController

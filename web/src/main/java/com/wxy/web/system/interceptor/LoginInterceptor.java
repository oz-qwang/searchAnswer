package com.wxy.web.system.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * Created by qiuwang on 5/15/16.
 *
 * @author <a href="mailto:qiu.wang@ozstrategy.com">Qiu Wang</a>
 * @version 05/15/2016 03:32
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    //~ Static fields/initializers ---------------------------------------------------------------------------------------

    private static final String[] SKIPED_URLS = {"/login", "/userLogin", "/userRegist"};

    //~ Instance fields --------------------------------------------------------------------------------------------------

    private final Log logger = LogFactory.getLog(this.getClass());

    //~ Methods ----------------------------------------------------------------------------------------------------------

    /**
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (Objects.isNull(request.getSession().getAttribute("user"))) {
            Boolean skiped = false;

            String servletPath = request.getServletPath();

            for (String url : SKIPED_URLS) {
                if (url.equals(servletPath)) {
                    skiped = true;
                }
            }

            if (!skiped) {
                response.sendRedirect(request.getContextPath() + "/login");

                return false;
            }

        }

        return true;

    } // end method preHandle
} // end class LoginInterceptor

package com.blyx.fs.web.interceptor;

import com.blyx.fs.common.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.MimeHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

/**
 * @description 登陆拦截器
 * @author quyang5
 * @date 2020.09.02
 *
 * */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;
    /**
     * @description 在请求处理之前进行调用（Controller方法调用之前）
     * @return true : 请求将会继续执行后面的操作
     *         false: 被请求时，拦截器执行到此处将不会继续操作
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {


        try {
            String url=request.getContextPath();


        } catch (Exception e) {

        }
        return true;
    }

}

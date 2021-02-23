package com.blyx.fs.web.interceptor;

import com.blyx.fs.common.enums.BizCodeEnum;
import com.blyx.fs.common.exception.BizException;
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
import java.util.ArrayList;
import java.util.List;

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

        log.info("LoginInterceptor.preHandle......");

        String url=request.getRequestURI();

        if(url.startsWith("/userOrder/")){
            return true;
        }

        if(url.startsWith("/workerLogin/")){
            return true;
        }

        if(url.startsWith("/userAddress/")){
            return true;
        }

        String token =request.getHeader("token");


        if(!redisUtil.hasKey(token)){
            throw new BizException(BizCodeEnum.WORKER_LOGIN_TOKEN_IS_NOT_EXISTS.getCode(),BizCodeEnum.WORKER_LOGIN_TOKEN_IS_NOT_EXISTS.getMsg());
        }

        return true;

    }

    /**
     * 修改header信息，key-value键值对儿加入到header中
     * @param request
     * @param key
     * @param value
     */
    private void reflectSetparam(HttpServletRequest request, String key, String value){
        Class<? extends HttpServletRequest> requestClass = request.getClass();
        try {
            Field request1 = requestClass.getDeclaredField("request");
            request1.setAccessible(true);
            Object o = request1.get(request);
            Field coyoteRequest = o.getClass().getDeclaredField("coyoteRequest");
            coyoteRequest.setAccessible(true);
            Object o1 = coyoteRequest.get(o);
            Field headers = o1.getClass().getDeclaredField("headers");
            headers.setAccessible(true);
            MimeHeaders o2 = (MimeHeaders)headers.get(o1);
            o2.addValue(key).setString(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
        } finally {
            if (writer != null)
                writer.close();
        }
    }


    /**
     * @description 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * @description 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

}

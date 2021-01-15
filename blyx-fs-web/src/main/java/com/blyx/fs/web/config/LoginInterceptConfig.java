package com.blyx.fs.web.config;

import com.blyx.fs.web.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description 登陆配置类，可在此类添加被拦截路径，也可过滤不需要拦截的路径
 * @author quyang5
 * @date 2020.09.02
 * */
@Configuration
@Slf4j
public class LoginInterceptConfig implements WebMvcConfigurer {


    /**
     * 这里需要先将限流拦截器入住，不然无法获取到拦截器中的redistemplate
     * @return
     */
    @Bean
    public LoginInterceptor getLoginIntercept() {
        return new LoginInterceptor();
    }


    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(getLoginIntercept());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
                "你的登陆路径",            //登录
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css",             //css静态资源
                "/**/*.woff",
                "/**/*.ttf"
        );
    }
}

package com.itheima.WebConfig;

import com.itheima.Interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
//只有配置了拦截器在什么时候会生效，才有用，否则无用。
@Configuration
public class webConfig implements WebMvcConfigurer {


    @Autowired
    private TokenInterceptor tokenInterceptor;

   @Override
    public void addInterceptors(InterceptorRegistry registry) {

       registry.addInterceptor(tokenInterceptor)
               .addPathPatterns("/**") // 拦截所有请
               .excludePathPatterns("/login"); // 不拦截哪些请求
   }
}

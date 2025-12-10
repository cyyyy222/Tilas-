package com.itheima.Interceptor;

import com.itheima.utils.CurrentHolder;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//token拦截器，校验，对拦截器的三个方法进行重写
//直接implement handler的拦截器就可以，而且只需要对第一个方法进行重写就可以
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception{

        String token = request.getHeader("token");//获取token
        if(token==null||token.equals("")){
            log.info("令牌为空，登录请求，放行，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return true;//直接放行
        }
      //否则解析令牌
        try{
            Claims claims =JwtUtils.parseJWT(token);
            Integer empId=Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            //调用方法，将id放到内存中
            log.info("当前登陆的员工id为{}，存入thread",empId);
        }catch (Exception e) {
            log.info("令牌非法, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }//异常说明不能通过
        log.info("令牌合法，放行");

        return true;
    }
    //实现了该方法，其他就不需要了
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        CurrentHolder.remove(); // 此时才清除，AOP 已经拿到 ID 了
        log.info("请求结束，清除 ThreadLocal 中的员工 ID");
    }

}

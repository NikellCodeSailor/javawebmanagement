package com.lzy.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lzy.pojo.Result;
import com.lzy.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginChekInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求url
        String url = request.getRequestURL().toString();
        log.info("url：{}",url);

        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("/login")) return true;

        //3.获取请求头中的令牌（token）
        String jwt = request.getHeader("token");
        log.info("请求头：{}",jwt);

        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(jwt)){
            Result error = Result.error("NOT_LOGIN");
            //转成json格式并响应浏览器
            String json = JSONObject.toJSONString(error);
            //响应
            response.getWriter().write(json);
            return false;
        }

        //5.解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            Result error = Result.error("NOT_LOGIN");
            //转成json格式并响应浏览器
            String json = JSONObject.toJSONString(error);
            //响应
            response.getWriter().write(json);
            return false;
        }

        //6.放行
        return true;
    }
}

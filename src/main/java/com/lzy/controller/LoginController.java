package com.lzy.controller;

import com.lzy.pojo.Emp;
import com.lzy.pojo.Result;
import com.lzy.service.EmpService;
import com.lzy.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;
    /**
     * 登录验证
     */
    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("登录，参数：{}",emp);

        Emp e =  empService.login(emp);
        //登录成功获取令牌
        if(e != null){
            HashMap<String , Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("password",e.getPassword());
            String JwtClaims = JwtUtils.generateJwt(claims);

            return Result.success(JwtClaims);
        }
        //登录失败
        return Result.error("用户名或密码错误");
    }

}

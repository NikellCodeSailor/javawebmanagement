package com.lzy;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Demo {

    //获取令牌
    @Test
    public void genjJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","Tmo");
        String jwt = Jwts.builder()
                .setClaims(claims)//自定义内容
                .signWith(SignatureAlgorithm.HS256,"webLzy")//算法签名
                .setExpiration(new Date(System.currentTimeMillis()+ 12*3600*1000))
                .compact();
        log.info("令牌:{}",jwt);
    }


    @Test
    //解析令牌
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定令牌
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsIm5hbWUiOiLmsaTlp4YiLCJpZCI6MTksImV4cCI6MTcyMDg0MDIxN30.Bj_j7vgfcedlEs039lST8GnEF2WCJZ5GFe8Egmfj-MA")//解析令牌
                .getBody();//获取解析的Json格式
        log.info("{}",claims);

    }
}

package com.lzy;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@Slf4j
        /*@SpringBootTest*/
class SpringbootWebManagementApplicationTests {

    @Test
    public void genjJwt() {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tmo");
        String jwt = Jwts.builder()
                .setClaims(claims)//自定义内容
                .signWith(SignatureAlgorithm.HS256, "webLzy")//算法签名
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .compact();
        log.info("令牌:{}", jwt);
    }
}



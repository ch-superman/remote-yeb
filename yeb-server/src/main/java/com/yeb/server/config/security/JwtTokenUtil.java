package com.yeb.server.config.security;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * @Author:Ch
 * @Date:2021/02/27/14:55
 * @Description: JwtToken工具类
 */
@Component
public class JwtTokenUtil {

    //    用户名
    private static final String CLAIM_KEY_USERNAME = "sub";
    //    创建时间
    private static final String CLAIM_KEY_CREATED = "creted";

    @Value("${jwt.secret}")
    private  String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
    * @Description: 根据用户信息生成Token
    * @param: [userDetails]
    * @return: java.lang.String
    */
    public  String generateToken(UserDetails userDetails){

        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,userDetails.getPassword());
        return generateToken(claims);
    }


    /**
    * @Description:
    * @param: [token]
    * @return: java.lang.String
    */
    public String  getUserNameFromToken(String token){

        String username;

        try {
            Claims  claims = getClaimsFormToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
    * @Description: 验证token是否有效
    * @param: [token, userDetails]
    * @return: boolean
    */

    public boolean validateToken(String token,UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return  username.equals(userDetails.getUsername()) && !isTokenExpired(token);

    }

    /**
    * @Description: 判断token是否可以被刷新
    * @param: [token]
    * @return: boolean
    */
    public boolean canRefresh(String token){
        return  !isTokenExpired(token);
    }

    /**
    * @Description: 刷新token
    * @param: [token]
    * @return: java.lang.String
    */
    public String refreshToken(String token){

        Claims claims = getClaimsFormToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }


    /**
    * @Description: 判断Token是否失效
    * @param: [token]
    * @return: boolean
    */

    private boolean isTokenExpired(String token) {

       Date expireDate =  getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
    * @Description: 从Token中获取失效时间
    * @param: [token]
    * @return: java.util.Date
    */

    private Date getExpiredDateFromToken(String token) {

        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }


    /**
    * @Description: 从Token获取荷载
    * @param: [token]
    * @return: io.jsonwebtoken.Claims
    */

    private Claims getClaimsFormToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }


    /**
    * @Description: 根据负载生成JWT TOKEN
    * @param: [claims]
    * @return: java.lang.String
    */
    private  String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
    * @Description: 生成Token失效时间
    * @param: []
    * @return: java.util.Date
    */
    private Date generateExpirationDate() {

        return new Date(System.currentTimeMillis()+expiration*1000);

    }

}

package com.yeb.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA
 *
 * @Author:Ch
 * @Date:2021/02/27/17:43
 * @Description: 公共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;

    /**
    * @Description: 成功返回结果
    * @param: [message]
    * @return: com.yeb.server.pojo.RespBean
    */

    public static RespBean success(String message){

        return  new RespBean(200,message,null);
    }

    /**
    * @Description: 成功返回结果
    * @param: [message, obj]
    * @return: com.yeb.server.pojo.RespBean
    */
    public static RespBean success(String message,Object obj){

        return  new RespBean(200,message,obj);
    }

    /**
    * @Description: 失败返回结果
    * @param: [message]
    * @return: com.yeb.server.pojo.RespBean
    */

    public static RespBean error(String message){
        return  new RespBean(500,message,null);
    }

    /**
    * @Description: 失败返回结果
    * @param: [message, obj]
    * @return: com.yeb.server.pojo.RespBean
    */
    public static RespBean error(String message,Object obj){

        return  new RespBean(500,message,obj);

    }
}

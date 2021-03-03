package com.yeb.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.Admin;
import com.yeb.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-02-26
 */
public interface IAdminService extends IService<Admin> {
    /**
    * @Description: 登录之后返回token
    * @param: [username, password, request]
    * @return: com.yeb.server.pojo.RespBean
    */

    RespBean login(String username,String password,String code, HttpServletRequest request);


    /**
    * @Description: 根据用户名获取用户
    * @param: [username]
    * @return: com.yeb.server.pojo.Admin
    */

    Admin getAdminByUserName(String username);
}

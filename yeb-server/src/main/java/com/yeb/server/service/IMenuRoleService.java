package com.yeb.server.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.server.pojo.Admin;
import com.yeb.server.pojo.MenuRole;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-02-26
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * <p>
     *  Mapper 接口
     * </p>
     *
     * @author zhoubin
     * @since 2021-02-26
     */
    interface AdminMapper extends BaseMapper<Admin> {

    }
}

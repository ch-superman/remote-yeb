package com.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeb.server.mapper.OplogMapper;
import com.yeb.server.pojo.Oplog;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2021-02-26
 */
@Service
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IService<Oplog> {

}

package com.yeb.server.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeb.server.mapper.PositionMapper;
import com.yeb.server.pojo.Position;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IService<Position> {

}

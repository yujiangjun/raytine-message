package com.raytine.message.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raytine.message.model.Session;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionListMapper extends BaseMapper<Session> {
}
package com.raytine.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.raytine.message.mapper.SessionListMapper;
import com.raytine.message.model.Session;
import com.raytine.message.service.SessionListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionListServiceImpl extends ServiceImpl<SessionListMapper, Session> implements SessionListService{

    @Override
    public List<Session> getMySessionList(String myId) {
        LambdaQueryWrapper<Session> queryWrapper = new QueryWrapper<Session>().lambda()
                .eq(Session::getTargetId, myId)
                .or(query->query.eq(Session::getSendId,myId))
                .orderByDesc(Session::getSessionTime);
        return list(queryWrapper);
    }
}

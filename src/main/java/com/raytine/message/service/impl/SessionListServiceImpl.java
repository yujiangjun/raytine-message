package com.raytine.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.raytine.message.mapper.SessionListMapper;
import com.raytine.message.model.Session;
import com.raytine.message.service.SessionListService;
import org.springframework.stereotype.Service;
@Service
public class SessionListServiceImpl extends ServiceImpl<SessionListMapper, Session> implements SessionListService{


}

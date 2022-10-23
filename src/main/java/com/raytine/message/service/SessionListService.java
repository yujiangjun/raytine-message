package com.raytine.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.raytine.message.model.Session;

import java.util.List;

public interface SessionListService extends IService<Session> {


    List<Session> getMySessionList(String myId);
}

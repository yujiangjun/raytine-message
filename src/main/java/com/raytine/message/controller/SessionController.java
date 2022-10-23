package com.raytine.message.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raytine.message.model.Session;
import com.raytine.message.service.SessionListService;
import com.raytine.message.vo.Resp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController extends BaseController{

    private final SessionListService sessionListService;

    public SessionController(SessionListService sessionListService) {
        this.sessionListService = sessionListService;
    }

    @PostMapping("addUpdate")
    public Resp<Void> addUpdateSession(@RequestBody Session session){
        LambdaQueryWrapper<Session> queryWrapper = new QueryWrapper<Session>().lambda().eq(Session::getSendId, session.getSendId()).eq(Session::getTargetId, session.getTargetId()).last("limit 1");
        Session one = sessionListService.getOne(queryWrapper);
        if (one!=null){
            session.setId(one.getId());
        }
        sessionListService.saveOrUpdate(session);
        return success(null);
    }

    @GetMapping("/getMySessionList")
    public Resp<List<Session>> getMySessionList(String myId){
        return success(sessionListService.getMySessionList(myId));
    }
}

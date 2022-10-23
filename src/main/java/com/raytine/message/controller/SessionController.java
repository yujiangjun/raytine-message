package com.raytine.message.controller;

import com.raytine.message.model.Session;
import com.raytine.message.service.SessionListService;
import com.raytine.message.vo.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController extends BaseController{

    private final SessionListService sessionListService;

    public SessionController(SessionListService sessionListService) {
        this.sessionListService = sessionListService;
    }

    @PostMapping("addUpdate")
    public Resp<Void> addUpdateSession(@RequestBody Session session){
        sessionListService.saveOrUpdate(session);
        return success(null);
    }
}

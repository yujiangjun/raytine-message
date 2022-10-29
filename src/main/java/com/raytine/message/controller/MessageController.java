package com.raytine.message.controller;

import com.raytine.message.vo.Resp;
import com.raytine.message.vo.UnReadCountVo;
import com.raytine.message.vo.UnReadUserCountVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.raytine.message.constants.Constants.UNREAD_MSG_COUNT;

@RestController
@RequestMapping("/message")
public class MessageController extends BaseController{

    final StringRedisTemplate stringRedisTemplate;

    public MessageController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/getMyUnReadCountTotal")
    public Resp<Integer> getMyUnReadCountTotal(String userId){
        Set<String> keys = stringRedisTemplate.keys(UNREAD_MSG_COUNT + userId+"*");
        int total=0;
        for (String key : keys) {
            int count = Integer.parseInt(Objects.requireNonNull(stringRedisTemplate.opsForValue().get(key)));
            total+=count;
        }
       return success(total);
    }
    @GetMapping("/getMyUnReadCountList")
    public Resp<List<UnReadUserCountVo>> getMyUnReadCountList(String userId){
        Set<String> keys = stringRedisTemplate.keys(UNREAD_MSG_COUNT + userId+"*");
        List<UnReadUserCountVo> userCountVos = new ArrayList<>();
        for (String key : keys) {
            int count = Integer.parseInt(Objects.requireNonNull(stringRedisTemplate.opsForValue().get(key)));
            String[] split = key.split("_");
            userCountVos.add(UnReadUserCountVo.builder().count(count).sendUserId(split[split.length-1]).build());
        }
        return success(userCountVos);
    }
}

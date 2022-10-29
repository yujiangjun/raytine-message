package com.raytine.message.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnReadUserCountVo {
    /**
     * 发送用户id
     */
    private String sendUserId;
    /**
     * 未读数量
     */
    private Integer count;
}

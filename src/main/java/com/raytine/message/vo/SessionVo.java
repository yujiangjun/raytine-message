package com.raytine.message.vo;

import com.raytine.message.model.Session;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SessionVo extends Session {
    private String sendUserName;
    private String sendUserAvatar;
}

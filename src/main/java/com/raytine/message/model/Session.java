package com.raytine.message.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("session_list")
public class Session {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer sendId;

    private Integer targetId;

    private Integer chatType;

    private String msgContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sessionTime = new Date();
    private String sendUserName;
    private String sendUserAvatar;
}
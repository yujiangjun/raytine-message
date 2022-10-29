package com.raytine.message.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UnReadCountVo {
    private Integer total;
    private List<UnReadUserCountVo> userCountList;
}

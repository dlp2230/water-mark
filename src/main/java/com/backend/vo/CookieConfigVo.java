package com.backend.vo;

import com.backend.vo.base.BaseConditionVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class CookieConfigVo extends BaseConditionVo {
    private String cookie;
    private Integer platform;
}

package com.backend.model;

import com.backend.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class CookieConfig extends BaseVo implements Serializable {
    private static final long serialVersionUID = 7238198006412851176L;
    private String cookie;
    private Integer platform;
    private Date createTime;
    private Date updateTime;

}

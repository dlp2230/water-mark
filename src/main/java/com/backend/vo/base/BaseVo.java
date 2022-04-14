package com.backend.vo.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author denglixing
 * @version V1.0
 * @date 2022年4月11日
 */
@Data
public abstract class BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    private Date createTime;
    private Date updateTime;

}

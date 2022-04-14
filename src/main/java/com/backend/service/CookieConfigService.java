package com.backend.service;

import com.backend.model.CookieConfig;
import com.backend.vo.CookieConfigVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CookieConfigService extends IService<CookieConfig> {
    List<CookieConfig> selectApis(IPage<CookieConfig> page, CookieConfigVo cookieConfigVo);
    int deleteBatch(Integer[] ids);

    CookieConfig selectByPlatformInfo(Integer platform);
}

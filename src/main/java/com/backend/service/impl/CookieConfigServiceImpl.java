package com.backend.service.impl;

import com.backend.mapper.CookieConfigMapper;
import com.backend.model.CookieConfig;
import com.backend.service.CookieConfigService;
import com.backend.vo.CookieConfigVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CookieConfigServiceImpl extends ServiceImpl<CookieConfigMapper, CookieConfig> implements CookieConfigService {

    private final CookieConfigMapper cookieConfigMapper;
    @Override
    public List<CookieConfig> selectApis(IPage<CookieConfig> page, CookieConfigVo cookieConfigVo) {
        List<CookieConfig> list = cookieConfigMapper.selectApis(page, cookieConfigVo);
        return list;
    }

    @Override
    @CacheEvict(value="apis",allEntries = true)
    public int deleteBatch(Integer[] ids){
        return cookieConfigMapper.deleteBatch(ids);
    }

    @Override
    public CookieConfig selectByPlatformInfo(Integer platform) {
        return cookieConfigMapper.selectByPlatformInfo(platform);
    }

}

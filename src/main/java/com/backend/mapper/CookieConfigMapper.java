package com.backend.mapper;

import com.backend.vo.CookieConfigVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.backend.model.CookieConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CookieConfigMapper extends BaseMapper<CookieConfig>{
    List<CookieConfig> selectApis(@Param("page") IPage<CookieConfig> page, @Param("vo") CookieConfigVo vo);

    int deleteBatch(Integer[] ids);

    CookieConfig selectByPlatformInfo(Integer platform);
}

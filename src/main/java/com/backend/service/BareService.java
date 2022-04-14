package com.backend.service;


import com.backend.parse.BareParser;
import com.backend.parse.ParserFactory;
import com.backend.common.result.BareResult;
import com.backend.common.utils.BizException;
import com.backend.common.utils.ErrorCode;
import com.backend.common.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BareService {

    @Resource
    private ParserFactory parserFactory;

    /**
     * 获取无水印资源地址列表
     *
     * @param link 复制的链接
     */
    public BareResult parse(String link) throws Exception {
        BareParser parser = parserFactory.getParser(link);
        if (parser == null) {
            throw new BizException(ErrorCode.NOT_SUPPORTED_PLATFORM_ERROR.value(), ErrorCode.NOT_SUPPORTED_PLATFORM_ERROR.msg());
        }
        return parser.parse(StringUtil.filterUrl(link));
    }
}
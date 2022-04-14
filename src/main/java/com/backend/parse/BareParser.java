package com.backend.parse;

import com.backend.common.result.BareResult;

/**
 * 解析器接口
 */
public interface BareParser {

    /**
     * 获取无水印资源信息
     *
     * @param link 复制的链接
     * @return 无水印资源信息
     */
    BareResult parse(String link) throws Exception;
}

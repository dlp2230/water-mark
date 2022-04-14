package com.backend.parse.parser;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.backend.model.CookieConfig;
import com.backend.parse.BareParser;
import com.backend.parse.enums.MediaType;
import com.backend.common.result.BareResult;
import com.backend.service.CookieConfigService;
import com.backend.common.utils.StringUtil;
import com.backend.common.utils.UrlUtil;
import com.backend.common.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 小红书解析器
 */
@Component
public class XiaoHongShuParser implements BareParser {
    @Resource
    private CookieConfigService cookieConfigService;
    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {
        // 获取小红书cookie
        CookieConfig cookieConfig = cookieConfigService.selectByPlatformInfo(1);
        String xshCookie = cookieConfig.getCookie();
        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Image> images = new ArrayList<>();
        result.setImages(images);

        String realUrl = UrlUtil.getRealUrl(UserAgentUtil.getOne(), url);
        String redirectPath = StringUtil.getQueryParams(realUrl).get("redirectPath").get(0);

        // 获取html内容
        String html = Jsoup
                .connect(redirectPath)
                .header("cookie", xshCookie)
                .userAgent(UserAgentUtil.getOne())
                .ignoreContentType(true)
                .execute()
                .body();
        // 获取json数据
        String jsonStr = regexJson(html);
        JSONObject contentObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONObject("noteData");
        // 标题
        result.setTitle(contentObject.getStr("title"));

        JSONArray imageArray = contentObject.getJSONArray("imageList");
        // 图片信息
        for (int i = 0; i < imageArray.size(); i++) {
            JSONObject item = imageArray.getJSONObject(i);
            images.add(new BareResult.Image(
                    "http://ci.xiaohongshu.com/" + item.getStr("traceId"),
                    item.getInt("width"),
                    item.getInt("height")
            ));
        }

        return result;
    }

    /**
     * 方法描述: 正则获取数据json
     *
     * @param html 网页内容
     */
    public static String regexJson(String html) {
        // 匹配网址
        String regex = "<script>window.__INITIAL_STATE__=\\{(.*?)\\}</script>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html);
        if (m.find()) {
            return html.substring(m.start(), m.end())
                    .replace("<script>window.__INITIAL_STATE__=", "")
                    .replace("</script>", "")
                    .replace("undefined", "null");
        }
        return "";
    }
}

package com.liser.myblog.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liser.myblog.common.wrap.WrapMapper;
import com.liser.myblog.common.wrap.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 随机壁纸
 * @author: LiMG
 * @create: 2020-03-03 23:39:40
 **/
@Slf4j
@RestController
@RequestMapping("/wallPaper")
public class WallPaperController {

    /**
     * 图片地址前缀
     */
    private static final String IMAGE_PREFIX = "https://cn.bing.com";

    @GetMapping("/getImageUrl")
    public Wrapper getImageUrl() {
        String result = HttpUtil.get("https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN");
        if (StrUtil.isNotEmpty(result)) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            JSONArray images = jsonObject.getJSONArray("images");
            if (null != images && images.size() > 0) {
                JSONObject image = images.getJSONObject(0);
                if (null != image) {
                    return WrapMapper.success(IMAGE_PREFIX + image.getString("url"));
                }
            }
        }
        return WrapMapper.success(null);
    }

}

package com.liser.myblog.controller;

import com.liser.myblog.common.wrap.WrapMapper;
import com.liser.myblog.common.wrap.Wrapper;
import com.liser.myblog.model.dto.ArticleSaveDTO;
import com.liser.myblog.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 文章相关接口
 * @author: LiMG
 * @create: 2020-04-06 15:51:25
 **/
@Slf4j
@RestController
@RequestMapping("/article")
@Api(value = "ArticleController", tags = "文章相关接口", description = "ArticleController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/saveArticleInfo")
    @ApiOperation(notes = "保存文章信息", httpMethod = "POST", value = "保存文章信息")
    public Wrapper saveArticleInfo(@RequestBody ArticleSaveDTO articleSaveDTO) {
        return WrapMapper.success(articleService.saveArticleInfo(articleSaveDTO));
    }

    @GetMapping("/getArticleInfo")
    @ApiOperation(notes = "根据ID获取文章详情", httpMethod = "GET", value = "根据ID获取文章详情")
    public Wrapper getArticleInfo(@RequestParam("id") String id) {
        return WrapMapper.success(articleService.getArticleInfo(id));
    }

}

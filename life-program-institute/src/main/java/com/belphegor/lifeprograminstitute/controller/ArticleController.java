package com.belphegor.lifeprograminstitute.controller;


import com.belphegor.common.entity.PageDTO;
import com.belphegor.common.entity.ResponseEntity;
import com.belphegor.common.enums.RespCodeEnum;
import com.belphegor.lifeprograminstitute.dto.ArticleDTO;
import com.belphegor.lifeprograminstitute.service.ArticleService;
import com.belphegor.lifeprograminstitute.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/belphegor/article",produces = "application/json;charset=UTF-8")
public class ArticleController extends BaseController{

    @Autowired
    private SkillService skillService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addArticle(String title,String content,String desc,String userSkillId){
        if(StringUtils.isEmpty(title)){
            return ResponseEntity.failed(RespCodeEnum.INVALIDPARAM);
        }
        if(StringUtils.isEmpty(content)){
            return ResponseEntity.failed(RespCodeEnum.INVALIDPARAM);
        }
        if(!skillService.isUserAlongWithSkill(userSkillId,user.getUserId())){
            return ResponseEntity.failed(RespCodeEnum.INVALIDPARAM);
        }
        boolean success = articleService.saveArticle(title,desc,content,userSkillId,user);
        if(success){
            return ResponseEntity.success();
        }
        return ResponseEntity.failed(RespCodeEnum.DEALFAILED);
    }

    @RequestMapping(value = "/editArticle",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity editArticle(String title,String content,String desc,String articleId){
        if(StringUtils.isEmpty(title)){
            return ResponseEntity.failed(RespCodeEnum.INVALIDPARAM);
        }
        if(StringUtils.isEmpty(content)){
            return ResponseEntity.failed(RespCodeEnum.INVALIDPARAM);
        }
        boolean success = articleService.editArticle(title,content,desc,articleId);
        if(success){
            return ResponseEntity.success();
        }
        return ResponseEntity.failed(RespCodeEnum.DEALFAILED);
    }

    @RequestMapping(value = "/queryArticleList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity queryArticleList(String userSkillId, PageDTO page){
        List<ArticleDTO> list = articleService.getArticleListByUserId(user.getUserId(),userSkillId,page);
        Integer total = articleService.getArticleListCountByUserId(user.getUserId(),userSkillId);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("total",total);
        return ResponseEntity.success(map);
    }
}

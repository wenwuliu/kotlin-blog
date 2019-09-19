package com.belphegor.lifeprograminstitute.service;

import com.belphegor.lifeprograminstitute.dto.ArticleDTO;
import com.belphegor.lifeprograminstitute.entity.Article;

import java.util.List;

public interface ArticleService {

    public boolean saveArticle(String title,String desc,String content,String userSkillId);

    public Article getArticleById(String articleId);

    public List<ArticleDTO> getArticleListByUserId(String userId);

    boolean editArticle(String title, String content, String desc, String articleId);
}

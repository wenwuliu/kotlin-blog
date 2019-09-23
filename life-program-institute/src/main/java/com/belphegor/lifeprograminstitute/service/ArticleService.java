package com.belphegor.lifeprograminstitute.service;

import com.belphegor.common.entity.PageDTO;
import com.belphegor.lifeprograminstitute.dto.ArticleDTO;
import com.belphegor.lifeprograminstitute.entity.Article;
import com.belphegor.lifeprograminstitute.entity.User;

import java.util.List;

public interface ArticleService {

    public boolean saveArticle(String title, String desc, String content, String userSkillId, User user);

    public Article getArticleById(String articleId);

    public List<ArticleDTO> getArticleListByUserId(String userId, String userSkillId, PageDTO pageDTO);

    boolean editArticle(String title, String content, String desc, String articleId);

    Integer getArticleListCountByUserId(String userId, String userSkillId);
}

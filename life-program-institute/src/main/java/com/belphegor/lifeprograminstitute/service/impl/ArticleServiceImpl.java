package com.belphegor.lifeprograminstitute.service.impl;

import com.belphegor.common.utils.CommonUtils;
import com.belphegor.lifeprograminstitute.dao.ArticleDAO;
import com.belphegor.lifeprograminstitute.dao.UserSkillDAO;
import com.belphegor.lifeprograminstitute.dto.ArticleDTO;
import com.belphegor.lifeprograminstitute.entity.Article;
import com.belphegor.lifeprograminstitute.entity.UserSkill;
import com.belphegor.lifeprograminstitute.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDAO articleDAO;

    @Autowired
    UserSkillDAO userSkillDAO;

    @Override
    public boolean saveArticle(String title,String desc,String content,String userSkillId) {
        UserSkill userSkill = userSkillDAO.selectByPrimaryKey(userSkillId);
        userSkill.setExp(userSkill.getExp() + 1);
        int success = userSkillDAO.updateByPrimaryKey(userSkill);
        if(success <= 0){
            return false;
        }
        Article article = new Article();
        article.setArticleName(title);
        article.setArticleContent(content);
        article.setArticleDesc(desc);
        article.setUserSkillId(userSkillId);
        article.setArticleId(CommonUtils.getUUID());
        success = articleDAO.insert(article);
        if(success > 0){
            return true;
        }
        return false;
    }

    @Override
    public Article getArticleById(String articleId) {
        return articleDAO.selectByPrimaryKey(articleId);
    }

    @Override
    public List<ArticleDTO> getArticleListByUserId(String userId) {
        return articleDAO.selectByUserId(userId);
    }

    @Override
    public boolean editArticle(String title, String content, String desc, String articleId) {
        Article article = articleDAO.selectByPrimaryKey(articleId);
        if(article == null || StringUtils.isEmpty(title) || StringUtils.isEmpty(content)){
            return false;
        }
        article.setArticleName(title);
        article.setArticleContent(content);
        article.setArticleDesc(desc);
        int success = articleDAO.updateByPrimaryKey(article);
        if(success > 0){
            return true;
        }
        return false;
    }
}

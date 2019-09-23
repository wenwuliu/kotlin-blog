package com.belphegor.lifeprograminstitute.dao;

import com.belphegor.common.entity.PageDTO;
import com.belphegor.common.mybatis.BaseDAO;
import com.belphegor.lifeprograminstitute.dao.mapper.ArticleMapper;
import com.belphegor.lifeprograminstitute.dto.ArticleDTO;
import com.belphegor.lifeprograminstitute.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDAO extends BaseDAO<Article, ArticleMapper> {
    public List<ArticleDTO> selectByUserId(String userId, String userSkillId, PageDTO page) {
        return mapper.selectByUserId(userId,userSkillId,page);
    }

    public Integer selectCountByUserId(String userId, String userSkillId) {
        return mapper.selectCountByUserId(userId,userSkillId);
    }
}

package com.belphegor.lifeprograminstitute.dao;

import com.belphegor.common.mybatis.BaseDAO;
import com.belphegor.lifeprograminstitute.dao.mapper.ArticleMapper;
import com.belphegor.lifeprograminstitute.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleDAO extends BaseDAO<Article, ArticleMapper> {
}

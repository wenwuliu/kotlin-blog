package com.belphegor.lifeprograminstitute.dao.mapper;

import com.belphegor.common.entity.PageDTO;
import com.belphegor.common.mybatis.BaseMapper;
import com.belphegor.lifeprograminstitute.dto.ArticleDTO;
import com.belphegor.lifeprograminstitute.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    List<ArticleDTO> selectByUserId(@Param("userId") String userId, @Param("userSkillId")String userSkillId,
                                    @Param("page")PageDTO pageDTO);

    Integer selectCountByUserId(@Param("userId") String userId, @Param("userSkillId") String userSkillId);
}
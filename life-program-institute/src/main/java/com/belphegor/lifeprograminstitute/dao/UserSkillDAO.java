package com.belphegor.lifeprograminstitute.dao;

import com.belphegor.common.mybatis.BaseDAO;
import com.belphegor.lifeprograminstitute.dao.mapper.UserSkillMapper;
import com.belphegor.lifeprograminstitute.dto.SkillDTO;
import com.belphegor.lifeprograminstitute.entity.UserSkill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSkillDAO extends BaseDAO<UserSkill, UserSkillMapper> {
    public List<SkillDTO> selectByUserId(String userId) {
        return mapper.selectByUserId(userId);
    }
}

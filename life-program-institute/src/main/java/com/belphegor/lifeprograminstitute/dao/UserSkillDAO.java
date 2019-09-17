package com.belphegor.lifeprograminstitute.dao;

import com.belphegor.common.mybatis.BaseDAO;
import com.belphegor.lifeprograminstitute.dao.mapper.UserSkillMapper;
import com.belphegor.lifeprograminstitute.entity.UserSkill;
import org.springframework.stereotype.Component;

@Component
public class UserSkillDAO extends BaseDAO<UserSkill, UserSkillMapper> {
}

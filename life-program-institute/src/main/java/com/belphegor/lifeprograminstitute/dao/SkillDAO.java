package com.belphegor.lifeprograminstitute.dao;

import com.belphegor.common.mybatis.BaseDAO;
import com.belphegor.lifeprograminstitute.dao.mapper.SkillMapper;
import com.belphegor.lifeprograminstitute.entity.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillDAO extends BaseDAO<Skill, SkillMapper> {
}

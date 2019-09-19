package com.belphegor.lifeprograminstitute.dao.mapper;

import com.belphegor.common.mybatis.BaseMapper;
import com.belphegor.lifeprograminstitute.dto.SkillDTO;
import com.belphegor.lifeprograminstitute.entity.UserSkill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSkillMapper extends BaseMapper<UserSkill> {

    List<SkillDTO> selectByUserId(@Param("userId") String userId);

}
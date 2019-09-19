package com.belphegor.lifeprograminstitute.service;

import com.belphegor.lifeprograminstitute.dto.SkillDTO;
import com.belphegor.lifeprograminstitute.entity.Skill;
import com.belphegor.lifeprograminstitute.entity.User;

import java.util.List;

public interface SkillService {
    public boolean addSkill(Skill skill, User user);

    public List<SkillDTO> getSkillByUserId(String userId);

    public boolean isUserAlongWithSkill(String userSkillId,String userId);
}

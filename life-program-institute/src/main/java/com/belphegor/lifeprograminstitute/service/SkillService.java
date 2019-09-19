package com.belphegor.lifeprograminstitute.service;

import com.belphegor.lifeprograminstitute.entity.Skill;
import com.belphegor.lifeprograminstitute.entity.User;

public interface SkillService {
    public boolean addSkill(Skill skill, User user);
}

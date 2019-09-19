package com.belphegor.lifeprograminstitute.service.impl;

import com.belphegor.lifeprograminstitute.dao.SkillDAO;
import com.belphegor.lifeprograminstitute.dao.UserSkillDAO;
import com.belphegor.lifeprograminstitute.entity.Skill;
import com.belphegor.lifeprograminstitute.entity.User;
import com.belphegor.lifeprograminstitute.service.SkillService;
import com.belphegor.lifeprograminstitute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDAO skillDAO;

    @Autowired
    private UserSkillDAO userSkillDAO;

    @Autowired
    private UserService userService;

    @Override
    public boolean addSkill(Skill skill, User user) {
        if(skill == null){
            return false;
        }
        if(!userService.validateUser(user)){
            return false;
        }
        if(skill.getSkillId() != null){


        }

    }
}

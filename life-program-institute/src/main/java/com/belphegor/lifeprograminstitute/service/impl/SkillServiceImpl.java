package com.belphegor.lifeprograminstitute.service.impl;

import com.belphegor.common.utils.CommonUtils;
import com.belphegor.lifeprograminstitute.dao.SkillDAO;
import com.belphegor.lifeprograminstitute.dao.UserSkillDAO;
import com.belphegor.lifeprograminstitute.dto.SkillDTO;
import com.belphegor.lifeprograminstitute.entity.Skill;
import com.belphegor.lifeprograminstitute.entity.User;
import com.belphegor.lifeprograminstitute.entity.UserSkill;
import com.belphegor.lifeprograminstitute.service.SkillService;
import com.belphegor.lifeprograminstitute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if(skill.getSkillId() == null){
            skill.setSkillId(CommonUtils.getUUID());
            int success = skillDAO.insert(skill);
            if(success <= 0){
                return false;
            }
        }

        UserSkill userSkill = new UserSkill();
        userSkill.setExp(0);
        userSkill.setSkillId(skill.getSkillId());
        userSkill.setUserId(user.getUserId());
        userSkill.setUserSkillId(CommonUtils.getUUID());
        int success = userSkillDAO.insert(userSkill);
        if(success > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<SkillDTO> getSkillByUserId(String userId) {
        return userSkillDAO.selectByUserId(userId);
    }

    @Override
    public boolean isUserAlongWithSkill(String userSkillId, String userId) {
        UserSkill userSkill = userSkillDAO.selectByPrimaryKey(userSkillId);
        if(userSkill == null){
            return false;
        }
        if(userSkill.getUserId().equals(userId)){
            return true;
        }
        return false;
    }
}

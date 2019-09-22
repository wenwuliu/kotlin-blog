package com.belphegor.lifeprograminstitute.controller;

import com.belphegor.common.entity.ResponseEntity;
import com.belphegor.common.enums.RespCodeEnum;
import com.belphegor.lifeprograminstitute.dto.SkillDTO;
import com.belphegor.lifeprograminstitute.entity.Skill;
import com.belphegor.lifeprograminstitute.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/belphegor/skill",produces = "application/json;charset=UTF-8")
public class UserSkillController extends BaseController{

    @Autowired
    SkillService skillService;


    @RequestMapping(value = "/addSkill",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addSkills(String skillId,String skillName,String skillDesc){
            if (StringUtils.isEmpty(skillName)){
                return ResponseEntity.failed(RespCodeEnum.INVALIDPARAM);
            }
             Skill skill = new Skill();
             skill.setSkillId(skillId);
             skill.setSkillName(skillName);
             skill.setSkillDesc(skillDesc);
             boolean success = skillService.addSkill(skill,user);
             if(success){
                 return ResponseEntity.success();
             }
             return ResponseEntity.failed(RespCodeEnum.DEALFAILED);
    }

    @RequestMapping(value = "/getSkillList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getSkillList(){
        List<SkillDTO> list = skillService.getSkillByUserId(user.getUserId());
        return ResponseEntity.success(list);
    }
}

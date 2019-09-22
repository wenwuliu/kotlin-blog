package com.belphegor.lifeprograminstitute.dto;

public class SkillDTO {
    private String userSkillId;
    private Integer exp;
    private String skillName;
    private String skillDesc;

    public String getUserSkillId() {
        return userSkillId;
    }

    public void setUserSkillId(String userSkillId) {
        this.userSkillId = userSkillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }
}

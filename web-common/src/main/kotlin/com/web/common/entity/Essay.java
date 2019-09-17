package com.web.common.entity;

public class Essay {
    private Integer id;

    private String essayId;

    private String essayTitle;

    private String essayContents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEssayId() {
        return essayId;
    }

    public void setEssayId(String essayId) {
        this.essayId = essayId == null ? null : essayId.trim();
    }

    public String getEssayTitle() {
        return essayTitle;
    }

    public void setEssayTitle(String essayTitle) {
        this.essayTitle = essayTitle == null ? null : essayTitle.trim();
    }

    public String getEssayContents() {
        return essayContents;
    }

    public void setEssayContents(String essayContents) {
        this.essayContents = essayContents == null ? null : essayContents.trim();
    }
}
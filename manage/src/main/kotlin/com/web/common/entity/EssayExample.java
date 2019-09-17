package com.web.common.entity;

import java.util.ArrayList;
import java.util.List;

public class EssayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EssayExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEssayIdIsNull() {
            addCriterion("essay_id is null");
            return (Criteria) this;
        }

        public Criteria andEssayIdIsNotNull() {
            addCriterion("essay_id is not null");
            return (Criteria) this;
        }

        public Criteria andEssayIdEqualTo(String value) {
            addCriterion("essay_id =", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdNotEqualTo(String value) {
            addCriterion("essay_id <>", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdGreaterThan(String value) {
            addCriterion("essay_id >", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdGreaterThanOrEqualTo(String value) {
            addCriterion("essay_id >=", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdLessThan(String value) {
            addCriterion("essay_id <", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdLessThanOrEqualTo(String value) {
            addCriterion("essay_id <=", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdLike(String value) {
            addCriterion("essay_id like", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdNotLike(String value) {
            addCriterion("essay_id not like", value, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdIn(List<String> values) {
            addCriterion("essay_id in", values, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdNotIn(List<String> values) {
            addCriterion("essay_id not in", values, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdBetween(String value1, String value2) {
            addCriterion("essay_id between", value1, value2, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayIdNotBetween(String value1, String value2) {
            addCriterion("essay_id not between", value1, value2, "essayId");
            return (Criteria) this;
        }

        public Criteria andEssayTitleIsNull() {
            addCriterion("essay_title is null");
            return (Criteria) this;
        }

        public Criteria andEssayTitleIsNotNull() {
            addCriterion("essay_title is not null");
            return (Criteria) this;
        }

        public Criteria andEssayTitleEqualTo(String value) {
            addCriterion("essay_title =", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleNotEqualTo(String value) {
            addCriterion("essay_title <>", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleGreaterThan(String value) {
            addCriterion("essay_title >", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleGreaterThanOrEqualTo(String value) {
            addCriterion("essay_title >=", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleLessThan(String value) {
            addCriterion("essay_title <", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleLessThanOrEqualTo(String value) {
            addCriterion("essay_title <=", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleLike(String value) {
            addCriterion("essay_title like", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleNotLike(String value) {
            addCriterion("essay_title not like", value, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleIn(List<String> values) {
            addCriterion("essay_title in", values, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleNotIn(List<String> values) {
            addCriterion("essay_title not in", values, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleBetween(String value1, String value2) {
            addCriterion("essay_title between", value1, value2, "essayTitle");
            return (Criteria) this;
        }

        public Criteria andEssayTitleNotBetween(String value1, String value2) {
            addCriterion("essay_title not between", value1, value2, "essayTitle");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
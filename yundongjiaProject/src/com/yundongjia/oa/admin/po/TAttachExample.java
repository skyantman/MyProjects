package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TAttachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAttachExample() {
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

        public Criteria andAttachidIsNull() {
            addCriterion("attachId is null");
            return (Criteria) this;
        }

        public Criteria andAttachidIsNotNull() {
            addCriterion("attachId is not null");
            return (Criteria) this;
        }

        public Criteria andAttachidEqualTo(Integer value) {
            addCriterion("attachId =", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidNotEqualTo(Integer value) {
            addCriterion("attachId <>", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidGreaterThan(Integer value) {
            addCriterion("attachId >", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidGreaterThanOrEqualTo(Integer value) {
            addCriterion("attachId >=", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidLessThan(Integer value) {
            addCriterion("attachId <", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidLessThanOrEqualTo(Integer value) {
            addCriterion("attachId <=", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidIn(List<Integer> values) {
            addCriterion("attachId in", values, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidNotIn(List<Integer> values) {
            addCriterion("attachId not in", values, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidBetween(Integer value1, Integer value2) {
            addCriterion("attachId between", value1, value2, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidNotBetween(Integer value1, Integer value2) {
            addCriterion("attachId not between", value1, value2, "attachid");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andImgordernumIsNull() {
            addCriterion("imgOrderNum is null");
            return (Criteria) this;
        }

        public Criteria andImgordernumIsNotNull() {
            addCriterion("imgOrderNum is not null");
            return (Criteria) this;
        }

        public Criteria andImgordernumEqualTo(Integer value) {
            addCriterion("imgOrderNum =", value, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumNotEqualTo(Integer value) {
            addCriterion("imgOrderNum <>", value, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumGreaterThan(Integer value) {
            addCriterion("imgOrderNum >", value, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("imgOrderNum >=", value, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumLessThan(Integer value) {
            addCriterion("imgOrderNum <", value, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumLessThanOrEqualTo(Integer value) {
            addCriterion("imgOrderNum <=", value, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumIn(List<Integer> values) {
            addCriterion("imgOrderNum in", values, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumNotIn(List<Integer> values) {
            addCriterion("imgOrderNum not in", values, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumBetween(Integer value1, Integer value2) {
            addCriterion("imgOrderNum between", value1, value2, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgordernumNotBetween(Integer value1, Integer value2) {
            addCriterion("imgOrderNum not between", value1, value2, "imgordernum");
            return (Criteria) this;
        }

        public Criteria andImgwidthIsNull() {
            addCriterion("imgwidth is null");
            return (Criteria) this;
        }

        public Criteria andImgwidthIsNotNull() {
            addCriterion("imgwidth is not null");
            return (Criteria) this;
        }

        public Criteria andImgwidthEqualTo(String value) {
            addCriterion("imgwidth =", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthNotEqualTo(String value) {
            addCriterion("imgwidth <>", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthGreaterThan(String value) {
            addCriterion("imgwidth >", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthGreaterThanOrEqualTo(String value) {
            addCriterion("imgwidth >=", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthLessThan(String value) {
            addCriterion("imgwidth <", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthLessThanOrEqualTo(String value) {
            addCriterion("imgwidth <=", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthLike(String value) {
            addCriterion("imgwidth like", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthNotLike(String value) {
            addCriterion("imgwidth not like", value, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthIn(List<String> values) {
            addCriterion("imgwidth in", values, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthNotIn(List<String> values) {
            addCriterion("imgwidth not in", values, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthBetween(String value1, String value2) {
            addCriterion("imgwidth between", value1, value2, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgwidthNotBetween(String value1, String value2) {
            addCriterion("imgwidth not between", value1, value2, "imgwidth");
            return (Criteria) this;
        }

        public Criteria andImgheightIsNull() {
            addCriterion("imgheight is null");
            return (Criteria) this;
        }

        public Criteria andImgheightIsNotNull() {
            addCriterion("imgheight is not null");
            return (Criteria) this;
        }

        public Criteria andImgheightEqualTo(String value) {
            addCriterion("imgheight =", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightNotEqualTo(String value) {
            addCriterion("imgheight <>", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightGreaterThan(String value) {
            addCriterion("imgheight >", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightGreaterThanOrEqualTo(String value) {
            addCriterion("imgheight >=", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightLessThan(String value) {
            addCriterion("imgheight <", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightLessThanOrEqualTo(String value) {
            addCriterion("imgheight <=", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightLike(String value) {
            addCriterion("imgheight like", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightNotLike(String value) {
            addCriterion("imgheight not like", value, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightIn(List<String> values) {
            addCriterion("imgheight in", values, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightNotIn(List<String> values) {
            addCriterion("imgheight not in", values, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightBetween(String value1, String value2) {
            addCriterion("imgheight between", value1, value2, "imgheight");
            return (Criteria) this;
        }

        public Criteria andImgheightNotBetween(String value1, String value2) {
            addCriterion("imgheight not between", value1, value2, "imgheight");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("isDel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isDel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("isDel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("isDel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("isDel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("isDel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("isDel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("isDel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("isDel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("isDel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("isDel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andAttachtypeIsNull() {
            addCriterion("attachType is null");
            return (Criteria) this;
        }

        public Criteria andAttachtypeIsNotNull() {
            addCriterion("attachType is not null");
            return (Criteria) this;
        }

        public Criteria andAttachtypeEqualTo(Integer value) {
            addCriterion("attachType =", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeNotEqualTo(Integer value) {
            addCriterion("attachType <>", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeGreaterThan(Integer value) {
            addCriterion("attachType >", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("attachType >=", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeLessThan(Integer value) {
            addCriterion("attachType <", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeLessThanOrEqualTo(Integer value) {
            addCriterion("attachType <=", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeIn(List<Integer> values) {
            addCriterion("attachType in", values, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeNotIn(List<Integer> values) {
            addCriterion("attachType not in", values, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeBetween(Integer value1, Integer value2) {
            addCriterion("attachType between", value1, value2, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("attachType not between", value1, value2, "attachtype");
            return (Criteria) this;
        }

        public Criteria andProidIsNull() {
            addCriterion("proId is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("proId is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(Integer value) {
            addCriterion("proId =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(Integer value) {
            addCriterion("proId <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(Integer value) {
            addCriterion("proId >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proId >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(Integer value) {
            addCriterion("proId <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(Integer value) {
            addCriterion("proId <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<Integer> values) {
            addCriterion("proId in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<Integer> values) {
            addCriterion("proId not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(Integer value1, Integer value2) {
            addCriterion("proId between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(Integer value1, Integer value2) {
            addCriterion("proId not between", value1, value2, "proid");
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
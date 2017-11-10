package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TFacilityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFacilityExample() {
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

        public Criteria andFacilityidIsNull() {
            addCriterion("facilityId is null");
            return (Criteria) this;
        }

        public Criteria andFacilityidIsNotNull() {
            addCriterion("facilityId is not null");
            return (Criteria) this;
        }

        public Criteria andFacilityidEqualTo(Integer value) {
            addCriterion("facilityId =", value, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidNotEqualTo(Integer value) {
            addCriterion("facilityId <>", value, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidGreaterThan(Integer value) {
            addCriterion("facilityId >", value, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("facilityId >=", value, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidLessThan(Integer value) {
            addCriterion("facilityId <", value, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidLessThanOrEqualTo(Integer value) {
            addCriterion("facilityId <=", value, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidIn(List<Integer> values) {
            addCriterion("facilityId in", values, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidNotIn(List<Integer> values) {
            addCriterion("facilityId not in", values, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidBetween(Integer value1, Integer value2) {
            addCriterion("facilityId between", value1, value2, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilityidNotBetween(Integer value1, Integer value2) {
            addCriterion("facilityId not between", value1, value2, "facilityid");
            return (Criteria) this;
        }

        public Criteria andFacilitynameIsNull() {
            addCriterion("facilityName is null");
            return (Criteria) this;
        }

        public Criteria andFacilitynameIsNotNull() {
            addCriterion("facilityName is not null");
            return (Criteria) this;
        }

        public Criteria andFacilitynameEqualTo(String value) {
            addCriterion("facilityName =", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameNotEqualTo(String value) {
            addCriterion("facilityName <>", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameGreaterThan(String value) {
            addCriterion("facilityName >", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameGreaterThanOrEqualTo(String value) {
            addCriterion("facilityName >=", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameLessThan(String value) {
            addCriterion("facilityName <", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameLessThanOrEqualTo(String value) {
            addCriterion("facilityName <=", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameLike(String value) {
            addCriterion("facilityName like", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameNotLike(String value) {
            addCriterion("facilityName not like", value, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameIn(List<String> values) {
            addCriterion("facilityName in", values, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameNotIn(List<String> values) {
            addCriterion("facilityName not in", values, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameBetween(String value1, String value2) {
            addCriterion("facilityName between", value1, value2, "facilityname");
            return (Criteria) this;
        }

        public Criteria andFacilitynameNotBetween(String value1, String value2) {
            addCriterion("facilityName not between", value1, value2, "facilityname");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
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
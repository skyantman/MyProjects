package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOpeartionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOpeartionExample() {
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

        public Criteria andOpeartionIdIsNull() {
            addCriterion("opeartion_id is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdIsNotNull() {
            addCriterion("opeartion_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdEqualTo(Integer value) {
            addCriterion("opeartion_id =", value, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdNotEqualTo(Integer value) {
            addCriterion("opeartion_id <>", value, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdGreaterThan(Integer value) {
            addCriterion("opeartion_id >", value, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("opeartion_id >=", value, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdLessThan(Integer value) {
            addCriterion("opeartion_id <", value, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdLessThanOrEqualTo(Integer value) {
            addCriterion("opeartion_id <=", value, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdIn(List<Integer> values) {
            addCriterion("opeartion_id in", values, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdNotIn(List<Integer> values) {
            addCriterion("opeartion_id not in", values, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_id between", value1, value2, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_id not between", value1, value2, "opeartionId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdIsNull() {
            addCriterion("opeartion_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdIsNotNull() {
            addCriterion("opeartion_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdEqualTo(Integer value) {
            addCriterion("opeartion_admin_id =", value, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdNotEqualTo(Integer value) {
            addCriterion("opeartion_admin_id <>", value, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdGreaterThan(Integer value) {
            addCriterion("opeartion_admin_id >", value, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("opeartion_admin_id >=", value, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdLessThan(Integer value) {
            addCriterion("opeartion_admin_id <", value, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("opeartion_admin_id <=", value, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdIn(List<Integer> values) {
            addCriterion("opeartion_admin_id in", values, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdNotIn(List<Integer> values) {
            addCriterion("opeartion_admin_id not in", values, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_admin_id between", value1, value2, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_admin_id not between", value1, value2, "opeartionAdminId");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateIsNull() {
            addCriterion("opeartion_createdate is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateIsNotNull() {
            addCriterion("opeartion_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateEqualTo(Date value) {
            addCriterion("opeartion_createdate =", value, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateNotEqualTo(Date value) {
            addCriterion("opeartion_createdate <>", value, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateGreaterThan(Date value) {
            addCriterion("opeartion_createdate >", value, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("opeartion_createdate >=", value, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateLessThan(Date value) {
            addCriterion("opeartion_createdate <", value, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("opeartion_createdate <=", value, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateIn(List<Date> values) {
            addCriterion("opeartion_createdate in", values, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateNotIn(List<Date> values) {
            addCriterion("opeartion_createdate not in", values, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateBetween(Date value1, Date value2) {
            addCriterion("opeartion_createdate between", value1, value2, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("opeartion_createdate not between", value1, value2, "opeartionCreatedate");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoIsNull() {
            addCriterion("opeartion_info is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoIsNotNull() {
            addCriterion("opeartion_info is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoEqualTo(String value) {
            addCriterion("opeartion_info =", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoNotEqualTo(String value) {
            addCriterion("opeartion_info <>", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoGreaterThan(String value) {
            addCriterion("opeartion_info >", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("opeartion_info >=", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoLessThan(String value) {
            addCriterion("opeartion_info <", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoLessThanOrEqualTo(String value) {
            addCriterion("opeartion_info <=", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoLike(String value) {
            addCriterion("opeartion_info like", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoNotLike(String value) {
            addCriterion("opeartion_info not like", value, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoIn(List<String> values) {
            addCriterion("opeartion_info in", values, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoNotIn(List<String> values) {
            addCriterion("opeartion_info not in", values, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoBetween(String value1, String value2) {
            addCriterion("opeartion_info between", value1, value2, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionInfoNotBetween(String value1, String value2) {
            addCriterion("opeartion_info not between", value1, value2, "opeartionInfo");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeIsNull() {
            addCriterion("opeartion_type is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeIsNotNull() {
            addCriterion("opeartion_type is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeEqualTo(Integer value) {
            addCriterion("opeartion_type =", value, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeNotEqualTo(Integer value) {
            addCriterion("opeartion_type <>", value, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeGreaterThan(Integer value) {
            addCriterion("opeartion_type >", value, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("opeartion_type >=", value, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeLessThan(Integer value) {
            addCriterion("opeartion_type <", value, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("opeartion_type <=", value, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeIn(List<Integer> values) {
            addCriterion("opeartion_type in", values, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeNotIn(List<Integer> values) {
            addCriterion("opeartion_type not in", values, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_type between", value1, value2, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_type not between", value1, value2, "opeartionType");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdIsNull() {
            addCriterion("opeartion_by_id is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdIsNotNull() {
            addCriterion("opeartion_by_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdEqualTo(Integer value) {
            addCriterion("opeartion_by_id =", value, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdNotEqualTo(Integer value) {
            addCriterion("opeartion_by_id <>", value, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdGreaterThan(Integer value) {
            addCriterion("opeartion_by_id >", value, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("opeartion_by_id >=", value, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdLessThan(Integer value) {
            addCriterion("opeartion_by_id <", value, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdLessThanOrEqualTo(Integer value) {
            addCriterion("opeartion_by_id <=", value, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdIn(List<Integer> values) {
            addCriterion("opeartion_by_id in", values, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdNotIn(List<Integer> values) {
            addCriterion("opeartion_by_id not in", values, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_by_id between", value1, value2, "opeartionById");
            return (Criteria) this;
        }

        public Criteria andOpeartionByIdNotBetween(Integer value1, Integer value2) {
            addCriterion("opeartion_by_id not between", value1, value2, "opeartionById");
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
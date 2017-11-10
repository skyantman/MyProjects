package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAuthExample() {
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

        public Criteria andAuthIdIsNull() {
            addCriterion("auth_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNotNull() {
            addCriterion("auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIdEqualTo(Integer value) {
            addCriterion("auth_id =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotEqualTo(Integer value) {
            addCriterion("auth_id <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThan(Integer value) {
            addCriterion("auth_id >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("auth_id >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThan(Integer value) {
            addCriterion("auth_id <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThanOrEqualTo(Integer value) {
            addCriterion("auth_id <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIn(List<Integer> values) {
            addCriterion("auth_id in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotIn(List<Integer> values) {
            addCriterion("auth_id not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdBetween(Integer value1, Integer value2) {
            addCriterion("auth_id between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("auth_id not between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNull() {
            addCriterion("auth_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNotNull() {
            addCriterion("auth_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNameEqualTo(String value) {
            addCriterion("auth_name =", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotEqualTo(String value) {
            addCriterion("auth_name <>", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThan(String value) {
            addCriterion("auth_name >", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThanOrEqualTo(String value) {
            addCriterion("auth_name >=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThan(String value) {
            addCriterion("auth_name <", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThanOrEqualTo(String value) {
            addCriterion("auth_name <=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLike(String value) {
            addCriterion("auth_name like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotLike(String value) {
            addCriterion("auth_name not like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameIn(List<String> values) {
            addCriterion("auth_name in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotIn(List<String> values) {
            addCriterion("auth_name not in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameBetween(String value1, String value2) {
            addCriterion("auth_name between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotBetween(String value1, String value2) {
            addCriterion("auth_name not between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthMarkIsNull() {
            addCriterion("auth_mark is null");
            return (Criteria) this;
        }

        public Criteria andAuthMarkIsNotNull() {
            addCriterion("auth_mark is not null");
            return (Criteria) this;
        }

        public Criteria andAuthMarkEqualTo(String value) {
            addCriterion("auth_mark =", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkNotEqualTo(String value) {
            addCriterion("auth_mark <>", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkGreaterThan(String value) {
            addCriterion("auth_mark >", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkGreaterThanOrEqualTo(String value) {
            addCriterion("auth_mark >=", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkLessThan(String value) {
            addCriterion("auth_mark <", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkLessThanOrEqualTo(String value) {
            addCriterion("auth_mark <=", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkLike(String value) {
            addCriterion("auth_mark like", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkNotLike(String value) {
            addCriterion("auth_mark not like", value, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkIn(List<String> values) {
            addCriterion("auth_mark in", values, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkNotIn(List<String> values) {
            addCriterion("auth_mark not in", values, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkBetween(String value1, String value2) {
            addCriterion("auth_mark between", value1, value2, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthMarkNotBetween(String value1, String value2) {
            addCriterion("auth_mark not between", value1, value2, "authMark");
            return (Criteria) this;
        }

        public Criteria andAuthCommIsNull() {
            addCriterion("auth_comm is null");
            return (Criteria) this;
        }

        public Criteria andAuthCommIsNotNull() {
            addCriterion("auth_comm is not null");
            return (Criteria) this;
        }

        public Criteria andAuthCommEqualTo(String value) {
            addCriterion("auth_comm =", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommNotEqualTo(String value) {
            addCriterion("auth_comm <>", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommGreaterThan(String value) {
            addCriterion("auth_comm >", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommGreaterThanOrEqualTo(String value) {
            addCriterion("auth_comm >=", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommLessThan(String value) {
            addCriterion("auth_comm <", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommLessThanOrEqualTo(String value) {
            addCriterion("auth_comm <=", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommLike(String value) {
            addCriterion("auth_comm like", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommNotLike(String value) {
            addCriterion("auth_comm not like", value, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommIn(List<String> values) {
            addCriterion("auth_comm in", values, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommNotIn(List<String> values) {
            addCriterion("auth_comm not in", values, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommBetween(String value1, String value2) {
            addCriterion("auth_comm between", value1, value2, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCommNotBetween(String value1, String value2) {
            addCriterion("auth_comm not between", value1, value2, "authComm");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateIsNull() {
            addCriterion("auth_create_date is null");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateIsNotNull() {
            addCriterion("auth_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateEqualTo(Date value) {
            addCriterion("auth_create_date =", value, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateNotEqualTo(Date value) {
            addCriterion("auth_create_date <>", value, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateGreaterThan(Date value) {
            addCriterion("auth_create_date >", value, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("auth_create_date >=", value, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateLessThan(Date value) {
            addCriterion("auth_create_date <", value, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("auth_create_date <=", value, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateIn(List<Date> values) {
            addCriterion("auth_create_date in", values, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateNotIn(List<Date> values) {
            addCriterion("auth_create_date not in", values, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateBetween(Date value1, Date value2) {
            addCriterion("auth_create_date between", value1, value2, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("auth_create_date not between", value1, value2, "authCreateDate");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridIsNull() {
            addCriterion("auth_operatorid is null");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridIsNotNull() {
            addCriterion("auth_operatorid is not null");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridEqualTo(Integer value) {
            addCriterion("auth_operatorid =", value, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridNotEqualTo(Integer value) {
            addCriterion("auth_operatorid <>", value, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridGreaterThan(Integer value) {
            addCriterion("auth_operatorid >", value, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("auth_operatorid >=", value, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridLessThan(Integer value) {
            addCriterion("auth_operatorid <", value, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridLessThanOrEqualTo(Integer value) {
            addCriterion("auth_operatorid <=", value, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridIn(List<Integer> values) {
            addCriterion("auth_operatorid in", values, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridNotIn(List<Integer> values) {
            addCriterion("auth_operatorid not in", values, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridBetween(Integer value1, Integer value2) {
            addCriterion("auth_operatorid between", value1, value2, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOperatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("auth_operatorid not between", value1, value2, "authOperatorid");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumIsNull() {
            addCriterion("auth_ordernum is null");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumIsNotNull() {
            addCriterion("auth_ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumEqualTo(Integer value) {
            addCriterion("auth_ordernum =", value, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumNotEqualTo(Integer value) {
            addCriterion("auth_ordernum <>", value, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumGreaterThan(Integer value) {
            addCriterion("auth_ordernum >", value, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("auth_ordernum >=", value, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumLessThan(Integer value) {
            addCriterion("auth_ordernum <", value, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("auth_ordernum <=", value, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumIn(List<Integer> values) {
            addCriterion("auth_ordernum in", values, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumNotIn(List<Integer> values) {
            addCriterion("auth_ordernum not in", values, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("auth_ordernum between", value1, value2, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("auth_ordernum not between", value1, value2, "authOrdernum");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdIsNull() {
            addCriterion("auth_menu_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdIsNotNull() {
            addCriterion("auth_menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdEqualTo(Integer value) {
            addCriterion("auth_menu_id =", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdNotEqualTo(Integer value) {
            addCriterion("auth_menu_id <>", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdGreaterThan(Integer value) {
            addCriterion("auth_menu_id >", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("auth_menu_id >=", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdLessThan(Integer value) {
            addCriterion("auth_menu_id <", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("auth_menu_id <=", value, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdIn(List<Integer> values) {
            addCriterion("auth_menu_id in", values, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdNotIn(List<Integer> values) {
            addCriterion("auth_menu_id not in", values, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("auth_menu_id between", value1, value2, "authMenuId");
            return (Criteria) this;
        }

        public Criteria andAuthMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("auth_menu_id not between", value1, value2, "authMenuId");
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
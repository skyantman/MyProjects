package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TMemberRouteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMemberRouteExample() {
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

        public Criteria andRowidIsNull() {
            addCriterion("rowId is null");
            return (Criteria) this;
        }

        public Criteria andRowidIsNotNull() {
            addCriterion("rowId is not null");
            return (Criteria) this;
        }

        public Criteria andRowidEqualTo(Integer value) {
            addCriterion("rowId =", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidNotEqualTo(Integer value) {
            addCriterion("rowId <>", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidGreaterThan(Integer value) {
            addCriterion("rowId >", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rowId >=", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidLessThan(Integer value) {
            addCriterion("rowId <", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidLessThanOrEqualTo(Integer value) {
            addCriterion("rowId <=", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidIn(List<Integer> values) {
            addCriterion("rowId in", values, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidNotIn(List<Integer> values) {
            addCriterion("rowId not in", values, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidBetween(Integer value1, Integer value2) {
            addCriterion("rowId between", value1, value2, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidNotBetween(Integer value1, Integer value2) {
            addCriterion("rowId not between", value1, value2, "rowid");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("memberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("memberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("memberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("memberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("memberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("memberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("memberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("memberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("memberId not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andRoutenumIsNull() {
            addCriterion("routeNum is null");
            return (Criteria) this;
        }

        public Criteria andRoutenumIsNotNull() {
            addCriterion("routeNum is not null");
            return (Criteria) this;
        }

        public Criteria andRoutenumEqualTo(Integer value) {
            addCriterion("routeNum =", value, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumNotEqualTo(Integer value) {
            addCriterion("routeNum <>", value, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumGreaterThan(Integer value) {
            addCriterion("routeNum >", value, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("routeNum >=", value, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumLessThan(Integer value) {
            addCriterion("routeNum <", value, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumLessThanOrEqualTo(Integer value) {
            addCriterion("routeNum <=", value, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumIn(List<Integer> values) {
            addCriterion("routeNum in", values, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumNotIn(List<Integer> values) {
            addCriterion("routeNum not in", values, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumBetween(Integer value1, Integer value2) {
            addCriterion("routeNum between", value1, value2, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutenumNotBetween(Integer value1, Integer value2) {
            addCriterion("routeNum not between", value1, value2, "routenum");
            return (Criteria) this;
        }

        public Criteria andRoutedateIsNull() {
            addCriterion("routeDate is null");
            return (Criteria) this;
        }

        public Criteria andRoutedateIsNotNull() {
            addCriterion("routeDate is not null");
            return (Criteria) this;
        }

        public Criteria andRoutedateEqualTo(String value) {
            addCriterion("routeDate =", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateNotEqualTo(String value) {
            addCriterion("routeDate <>", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateGreaterThan(String value) {
            addCriterion("routeDate >", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateGreaterThanOrEqualTo(String value) {
            addCriterion("routeDate >=", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateLessThan(String value) {
            addCriterion("routeDate <", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateLessThanOrEqualTo(String value) {
            addCriterion("routeDate <=", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateLike(String value) {
            addCriterion("routeDate like", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateNotLike(String value) {
            addCriterion("routeDate not like", value, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateIn(List<String> values) {
            addCriterion("routeDate in", values, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateNotIn(List<String> values) {
            addCriterion("routeDate not in", values, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateBetween(String value1, String value2) {
            addCriterion("routeDate between", value1, value2, "routedate");
            return (Criteria) this;
        }

        public Criteria andRoutedateNotBetween(String value1, String value2) {
            addCriterion("routeDate not between", value1, value2, "routedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(String value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(String value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(String value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(String value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLike(String value) {
            addCriterion("updateDate like", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotLike(String value) {
            addCriterion("updateDate not like", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<String> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<String> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(String value1, String value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(String value1, String value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
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
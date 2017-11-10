package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TMemberShowtimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMemberShowtimeExample() {
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

        public Criteria andTimeidIsNull() {
            addCriterion("timeId is null");
            return (Criteria) this;
        }

        public Criteria andTimeidIsNotNull() {
            addCriterion("timeId is not null");
            return (Criteria) this;
        }

        public Criteria andTimeidEqualTo(Integer value) {
            addCriterion("timeId =", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidNotEqualTo(Integer value) {
            addCriterion("timeId <>", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidGreaterThan(Integer value) {
            addCriterion("timeId >", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeId >=", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidLessThan(Integer value) {
            addCriterion("timeId <", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidLessThanOrEqualTo(Integer value) {
            addCriterion("timeId <=", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidIn(List<Integer> values) {
            addCriterion("timeId in", values, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidNotIn(List<Integer> values) {
            addCriterion("timeId not in", values, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidBetween(Integer value1, Integer value2) {
            addCriterion("timeId between", value1, value2, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidNotBetween(Integer value1, Integer value2) {
            addCriterion("timeId not between", value1, value2, "timeid");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeIsNull() {
            addCriterion("showstarttime is null");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeIsNotNull() {
            addCriterion("showstarttime is not null");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeEqualTo(String value) {
            addCriterion("showstarttime =", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeNotEqualTo(String value) {
            addCriterion("showstarttime <>", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeGreaterThan(String value) {
            addCriterion("showstarttime >", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("showstarttime >=", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeLessThan(String value) {
            addCriterion("showstarttime <", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeLessThanOrEqualTo(String value) {
            addCriterion("showstarttime <=", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeLike(String value) {
            addCriterion("showstarttime like", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeNotLike(String value) {
            addCriterion("showstarttime not like", value, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeIn(List<String> values) {
            addCriterion("showstarttime in", values, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeNotIn(List<String> values) {
            addCriterion("showstarttime not in", values, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeBetween(String value1, String value2) {
            addCriterion("showstarttime between", value1, value2, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowstarttimeNotBetween(String value1, String value2) {
            addCriterion("showstarttime not between", value1, value2, "showstarttime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeIsNull() {
            addCriterion("showendtime is null");
            return (Criteria) this;
        }

        public Criteria andShowendtimeIsNotNull() {
            addCriterion("showendtime is not null");
            return (Criteria) this;
        }

        public Criteria andShowendtimeEqualTo(String value) {
            addCriterion("showendtime =", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeNotEqualTo(String value) {
            addCriterion("showendtime <>", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeGreaterThan(String value) {
            addCriterion("showendtime >", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("showendtime >=", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeLessThan(String value) {
            addCriterion("showendtime <", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeLessThanOrEqualTo(String value) {
            addCriterion("showendtime <=", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeLike(String value) {
            addCriterion("showendtime like", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeNotLike(String value) {
            addCriterion("showendtime not like", value, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeIn(List<String> values) {
            addCriterion("showendtime in", values, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeNotIn(List<String> values) {
            addCriterion("showendtime not in", values, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeBetween(String value1, String value2) {
            addCriterion("showendtime between", value1, value2, "showendtime");
            return (Criteria) this;
        }

        public Criteria andShowendtimeNotBetween(String value1, String value2) {
            addCriterion("showendtime not between", value1, value2, "showendtime");
            return (Criteria) this;
        }

        public Criteria andTimespanIsNull() {
            addCriterion("timespan is null");
            return (Criteria) this;
        }

        public Criteria andTimespanIsNotNull() {
            addCriterion("timespan is not null");
            return (Criteria) this;
        }

        public Criteria andTimespanEqualTo(String value) {
            addCriterion("timespan =", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanNotEqualTo(String value) {
            addCriterion("timespan <>", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanGreaterThan(String value) {
            addCriterion("timespan >", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanGreaterThanOrEqualTo(String value) {
            addCriterion("timespan >=", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanLessThan(String value) {
            addCriterion("timespan <", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanLessThanOrEqualTo(String value) {
            addCriterion("timespan <=", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanLike(String value) {
            addCriterion("timespan like", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanNotLike(String value) {
            addCriterion("timespan not like", value, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanIn(List<String> values) {
            addCriterion("timespan in", values, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanNotIn(List<String> values) {
            addCriterion("timespan not in", values, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanBetween(String value1, String value2) {
            addCriterion("timespan between", value1, value2, "timespan");
            return (Criteria) this;
        }

        public Criteria andTimespanNotBetween(String value1, String value2) {
            addCriterion("timespan not between", value1, value2, "timespan");
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

        public Criteria andStudioidIsNull() {
            addCriterion("studioId is null");
            return (Criteria) this;
        }

        public Criteria andStudioidIsNotNull() {
            addCriterion("studioId is not null");
            return (Criteria) this;
        }

        public Criteria andStudioidEqualTo(Integer value) {
            addCriterion("studioId =", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidNotEqualTo(Integer value) {
            addCriterion("studioId <>", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidGreaterThan(Integer value) {
            addCriterion("studioId >", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studioId >=", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidLessThan(Integer value) {
            addCriterion("studioId <", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidLessThanOrEqualTo(Integer value) {
            addCriterion("studioId <=", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidIn(List<Integer> values) {
            addCriterion("studioId in", values, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidNotIn(List<Integer> values) {
            addCriterion("studioId not in", values, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidBetween(Integer value1, Integer value2) {
            addCriterion("studioId between", value1, value2, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidNotBetween(Integer value1, Integer value2) {
            addCriterion("studioId not between", value1, value2, "studioid");
            return (Criteria) this;
        }

        public Criteria andIsshowoverIsNull() {
            addCriterion("isshowover is null");
            return (Criteria) this;
        }

        public Criteria andIsshowoverIsNotNull() {
            addCriterion("isshowover is not null");
            return (Criteria) this;
        }

        public Criteria andIsshowoverEqualTo(String value) {
            addCriterion("isshowover =", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverNotEqualTo(String value) {
            addCriterion("isshowover <>", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverGreaterThan(String value) {
            addCriterion("isshowover >", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverGreaterThanOrEqualTo(String value) {
            addCriterion("isshowover >=", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverLessThan(String value) {
            addCriterion("isshowover <", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverLessThanOrEqualTo(String value) {
            addCriterion("isshowover <=", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverLike(String value) {
            addCriterion("isshowover like", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverNotLike(String value) {
            addCriterion("isshowover not like", value, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverIn(List<String> values) {
            addCriterion("isshowover in", values, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverNotIn(List<String> values) {
            addCriterion("isshowover not in", values, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverBetween(String value1, String value2) {
            addCriterion("isshowover between", value1, value2, "isshowover");
            return (Criteria) this;
        }

        public Criteria andIsshowoverNotBetween(String value1, String value2) {
            addCriterion("isshowover not between", value1, value2, "isshowover");
            return (Criteria) this;
        }

        public Criteria andMillisecondIsNull() {
            addCriterion("millisecond is null");
            return (Criteria) this;
        }

        public Criteria andMillisecondIsNotNull() {
            addCriterion("millisecond is not null");
            return (Criteria) this;
        }

        public Criteria andMillisecondEqualTo(String value) {
            addCriterion("millisecond =", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondNotEqualTo(String value) {
            addCriterion("millisecond <>", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondGreaterThan(String value) {
            addCriterion("millisecond >", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondGreaterThanOrEqualTo(String value) {
            addCriterion("millisecond >=", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondLessThan(String value) {
            addCriterion("millisecond <", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondLessThanOrEqualTo(String value) {
            addCriterion("millisecond <=", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondLike(String value) {
            addCriterion("millisecond like", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondNotLike(String value) {
            addCriterion("millisecond not like", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondIn(List<String> values) {
            addCriterion("millisecond in", values, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondNotIn(List<String> values) {
            addCriterion("millisecond not in", values, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondBetween(String value1, String value2) {
            addCriterion("millisecond between", value1, value2, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondNotBetween(String value1, String value2) {
            addCriterion("millisecond not between", value1, value2, "millisecond");
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
package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TPrivateLessonTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPrivateLessonTimeExample() {
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

        public Criteria andCoachidIsNull() {
            addCriterion("coachId is null");
            return (Criteria) this;
        }

        public Criteria andCoachidIsNotNull() {
            addCriterion("coachId is not null");
            return (Criteria) this;
        }

        public Criteria andCoachidEqualTo(Integer value) {
            addCriterion("coachId =", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotEqualTo(Integer value) {
            addCriterion("coachId <>", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThan(Integer value) {
            addCriterion("coachId >", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coachId >=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThan(Integer value) {
            addCriterion("coachId <", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThanOrEqualTo(Integer value) {
            addCriterion("coachId <=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidIn(List<Integer> values) {
            addCriterion("coachId in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotIn(List<Integer> values) {
            addCriterion("coachId not in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidBetween(Integer value1, Integer value2) {
            addCriterion("coachId between", value1, value2, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotBetween(Integer value1, Integer value2) {
            addCriterion("coachId not between", value1, value2, "coachid");
            return (Criteria) this;
        }

        public Criteria andLessondateIsNull() {
            addCriterion("lessonDate is null");
            return (Criteria) this;
        }

        public Criteria andLessondateIsNotNull() {
            addCriterion("lessonDate is not null");
            return (Criteria) this;
        }

        public Criteria andLessondateEqualTo(String value) {
            addCriterion("lessonDate =", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateNotEqualTo(String value) {
            addCriterion("lessonDate <>", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateGreaterThan(String value) {
            addCriterion("lessonDate >", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateGreaterThanOrEqualTo(String value) {
            addCriterion("lessonDate >=", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateLessThan(String value) {
            addCriterion("lessonDate <", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateLessThanOrEqualTo(String value) {
            addCriterion("lessonDate <=", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateLike(String value) {
            addCriterion("lessonDate like", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateNotLike(String value) {
            addCriterion("lessonDate not like", value, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateIn(List<String> values) {
            addCriterion("lessonDate in", values, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateNotIn(List<String> values) {
            addCriterion("lessonDate not in", values, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateBetween(String value1, String value2) {
            addCriterion("lessonDate between", value1, value2, "lessondate");
            return (Criteria) this;
        }

        public Criteria andLessondateNotBetween(String value1, String value2) {
            addCriterion("lessonDate not between", value1, value2, "lessondate");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanIsNull() {
            addCriterion("availableTimeSpan is null");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanIsNotNull() {
            addCriterion("availableTimeSpan is not null");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanEqualTo(String value) {
            addCriterion("availableTimeSpan =", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanNotEqualTo(String value) {
            addCriterion("availableTimeSpan <>", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanGreaterThan(String value) {
            addCriterion("availableTimeSpan >", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanGreaterThanOrEqualTo(String value) {
            addCriterion("availableTimeSpan >=", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanLessThan(String value) {
            addCriterion("availableTimeSpan <", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanLessThanOrEqualTo(String value) {
            addCriterion("availableTimeSpan <=", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanLike(String value) {
            addCriterion("availableTimeSpan like", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanNotLike(String value) {
            addCriterion("availableTimeSpan not like", value, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanIn(List<String> values) {
            addCriterion("availableTimeSpan in", values, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanNotIn(List<String> values) {
            addCriterion("availableTimeSpan not in", values, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanBetween(String value1, String value2) {
            addCriterion("availableTimeSpan between", value1, value2, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andAvailabletimespanNotBetween(String value1, String value2) {
            addCriterion("availableTimeSpan not between", value1, value2, "availabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanIsNull() {
            addCriterion("unAvailableTimeSpan is null");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanIsNotNull() {
            addCriterion("unAvailableTimeSpan is not null");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanEqualTo(String value) {
            addCriterion("unAvailableTimeSpan =", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanNotEqualTo(String value) {
            addCriterion("unAvailableTimeSpan <>", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanGreaterThan(String value) {
            addCriterion("unAvailableTimeSpan >", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanGreaterThanOrEqualTo(String value) {
            addCriterion("unAvailableTimeSpan >=", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanLessThan(String value) {
            addCriterion("unAvailableTimeSpan <", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanLessThanOrEqualTo(String value) {
            addCriterion("unAvailableTimeSpan <=", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanLike(String value) {
            addCriterion("unAvailableTimeSpan like", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanNotLike(String value) {
            addCriterion("unAvailableTimeSpan not like", value, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanIn(List<String> values) {
            addCriterion("unAvailableTimeSpan in", values, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanNotIn(List<String> values) {
            addCriterion("unAvailableTimeSpan not in", values, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanBetween(String value1, String value2) {
            addCriterion("unAvailableTimeSpan between", value1, value2, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andUnavailabletimespanNotBetween(String value1, String value2) {
            addCriterion("unAvailableTimeSpan not between", value1, value2, "unavailabletimespan");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("createDate like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("createDate not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCloseweekIsNull() {
            addCriterion("closeWeek is null");
            return (Criteria) this;
        }

        public Criteria andCloseweekIsNotNull() {
            addCriterion("closeWeek is not null");
            return (Criteria) this;
        }

        public Criteria andCloseweekEqualTo(String value) {
            addCriterion("closeWeek =", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekNotEqualTo(String value) {
            addCriterion("closeWeek <>", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekGreaterThan(String value) {
            addCriterion("closeWeek >", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekGreaterThanOrEqualTo(String value) {
            addCriterion("closeWeek >=", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekLessThan(String value) {
            addCriterion("closeWeek <", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekLessThanOrEqualTo(String value) {
            addCriterion("closeWeek <=", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekLike(String value) {
            addCriterion("closeWeek like", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekNotLike(String value) {
            addCriterion("closeWeek not like", value, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekIn(List<String> values) {
            addCriterion("closeWeek in", values, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekNotIn(List<String> values) {
            addCriterion("closeWeek not in", values, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekBetween(String value1, String value2) {
            addCriterion("closeWeek between", value1, value2, "closeweek");
            return (Criteria) this;
        }

        public Criteria andCloseweekNotBetween(String value1, String value2) {
            addCriterion("closeWeek not between", value1, value2, "closeweek");
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
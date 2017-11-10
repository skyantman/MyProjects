package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TCoachStudioRefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCoachStudioRefExample() {
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
package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TSupplierLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSupplierLoginExample() {
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

        public Criteria andSupplierloginidIsNull() {
            addCriterion("supplierLoginId is null");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidIsNotNull() {
            addCriterion("supplierLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidEqualTo(Integer value) {
            addCriterion("supplierLoginId =", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidNotEqualTo(Integer value) {
            addCriterion("supplierLoginId <>", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidGreaterThan(Integer value) {
            addCriterion("supplierLoginId >", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplierLoginId >=", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidLessThan(Integer value) {
            addCriterion("supplierLoginId <", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidLessThanOrEqualTo(Integer value) {
            addCriterion("supplierLoginId <=", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidIn(List<Integer> values) {
            addCriterion("supplierLoginId in", values, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidNotIn(List<Integer> values) {
            addCriterion("supplierLoginId not in", values, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidBetween(Integer value1, Integer value2) {
            addCriterion("supplierLoginId between", value1, value2, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("supplierLoginId not between", value1, value2, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneIsNull() {
            addCriterion("loginMobilePhone is null");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneIsNotNull() {
            addCriterion("loginMobilePhone is not null");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneEqualTo(String value) {
            addCriterion("loginMobilePhone =", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneNotEqualTo(String value) {
            addCriterion("loginMobilePhone <>", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneGreaterThan(String value) {
            addCriterion("loginMobilePhone >", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneGreaterThanOrEqualTo(String value) {
            addCriterion("loginMobilePhone >=", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneLessThan(String value) {
            addCriterion("loginMobilePhone <", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneLessThanOrEqualTo(String value) {
            addCriterion("loginMobilePhone <=", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneLike(String value) {
            addCriterion("loginMobilePhone like", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneNotLike(String value) {
            addCriterion("loginMobilePhone not like", value, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneIn(List<String> values) {
            addCriterion("loginMobilePhone in", values, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneNotIn(List<String> values) {
            addCriterion("loginMobilePhone not in", values, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneBetween(String value1, String value2) {
            addCriterion("loginMobilePhone between", value1, value2, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginmobilephoneNotBetween(String value1, String value2) {
            addCriterion("loginMobilePhone not between", value1, value2, "loginmobilephone");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIsNull() {
            addCriterion("loginPWD is null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIsNotNull() {
            addCriterion("loginPWD is not null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdEqualTo(String value) {
            addCriterion("loginPWD =", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotEqualTo(String value) {
            addCriterion("loginPWD <>", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThan(String value) {
            addCriterion("loginPWD >", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("loginPWD >=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThan(String value) {
            addCriterion("loginPWD <", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThanOrEqualTo(String value) {
            addCriterion("loginPWD <=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLike(String value) {
            addCriterion("loginPWD like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotLike(String value) {
            addCriterion("loginPWD not like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIn(List<String> values) {
            addCriterion("loginPWD in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotIn(List<String> values) {
            addCriterion("loginPWD not in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdBetween(String value1, String value2) {
            addCriterion("loginPWD between", value1, value2, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotBetween(String value1, String value2) {
            addCriterion("loginPWD not between", value1, value2, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLogindateIsNull() {
            addCriterion("loginDate is null");
            return (Criteria) this;
        }

        public Criteria andLogindateIsNotNull() {
            addCriterion("loginDate is not null");
            return (Criteria) this;
        }

        public Criteria andLogindateEqualTo(String value) {
            addCriterion("loginDate =", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateNotEqualTo(String value) {
            addCriterion("loginDate <>", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateGreaterThan(String value) {
            addCriterion("loginDate >", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateGreaterThanOrEqualTo(String value) {
            addCriterion("loginDate >=", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateLessThan(String value) {
            addCriterion("loginDate <", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateLessThanOrEqualTo(String value) {
            addCriterion("loginDate <=", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateLike(String value) {
            addCriterion("loginDate like", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateNotLike(String value) {
            addCriterion("loginDate not like", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateIn(List<String> values) {
            addCriterion("loginDate in", values, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateNotIn(List<String> values) {
            addCriterion("loginDate not in", values, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateBetween(String value1, String value2) {
            addCriterion("loginDate between", value1, value2, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateNotBetween(String value1, String value2) {
            addCriterion("loginDate not between", value1, value2, "logindate");
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
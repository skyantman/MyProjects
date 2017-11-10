package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAdminAuthRefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAdminAuthRefExample() {
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

        public Criteria andAdminAuthIdIsNull() {
            addCriterion("admin_auth_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdIsNotNull() {
            addCriterion("admin_auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdEqualTo(Integer value) {
            addCriterion("admin_auth_id =", value, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdNotEqualTo(Integer value) {
            addCriterion("admin_auth_id <>", value, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdGreaterThan(Integer value) {
            addCriterion("admin_auth_id >", value, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_id >=", value, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdLessThan(Integer value) {
            addCriterion("admin_auth_id <", value, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_id <=", value, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdIn(List<Integer> values) {
            addCriterion("admin_auth_id in", values, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdNotIn(List<Integer> values) {
            addCriterion("admin_auth_id not in", values, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_id between", value1, value2, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_id not between", value1, value2, "adminAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdIsNull() {
            addCriterion("admin_auth_auth_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdIsNotNull() {
            addCriterion("admin_auth_auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdEqualTo(Integer value) {
            addCriterion("admin_auth_auth_id =", value, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdNotEqualTo(Integer value) {
            addCriterion("admin_auth_auth_id <>", value, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdGreaterThan(Integer value) {
            addCriterion("admin_auth_auth_id >", value, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_auth_id >=", value, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdLessThan(Integer value) {
            addCriterion("admin_auth_auth_id <", value, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_auth_id <=", value, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdIn(List<Integer> values) {
            addCriterion("admin_auth_auth_id in", values, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdNotIn(List<Integer> values) {
            addCriterion("admin_auth_auth_id not in", values, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_auth_id between", value1, value2, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAuthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_auth_id not between", value1, value2, "adminAuthAuthId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdIsNull() {
            addCriterion("admin_auth_role_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdIsNotNull() {
            addCriterion("admin_auth_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdEqualTo(Integer value) {
            addCriterion("admin_auth_role_id =", value, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdNotEqualTo(Integer value) {
            addCriterion("admin_auth_role_id <>", value, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdGreaterThan(Integer value) {
            addCriterion("admin_auth_role_id >", value, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_role_id >=", value, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdLessThan(Integer value) {
            addCriterion("admin_auth_role_id <", value, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_role_id <=", value, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdIn(List<Integer> values) {
            addCriterion("admin_auth_role_id in", values, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdNotIn(List<Integer> values) {
            addCriterion("admin_auth_role_id not in", values, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_role_id between", value1, value2, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_role_id not between", value1, value2, "adminAuthRoleId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdIsNull() {
            addCriterion("admin_auth_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdIsNotNull() {
            addCriterion("admin_auth_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdEqualTo(Integer value) {
            addCriterion("admin_auth_admin_id =", value, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_auth_admin_id <>", value, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdGreaterThan(Integer value) {
            addCriterion("admin_auth_admin_id >", value, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_admin_id >=", value, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdLessThan(Integer value) {
            addCriterion("admin_auth_admin_id <", value, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_admin_id <=", value, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdIn(List<Integer> values) {
            addCriterion("admin_auth_admin_id in", values, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_auth_admin_id not in", values, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_admin_id between", value1, value2, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_admin_id not between", value1, value2, "adminAuthAdminId");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateIsNull() {
            addCriterion("admin_auth_create_date is null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateIsNotNull() {
            addCriterion("admin_auth_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateEqualTo(Date value) {
            addCriterion("admin_auth_create_date =", value, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateNotEqualTo(Date value) {
            addCriterion("admin_auth_create_date <>", value, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateGreaterThan(Date value) {
            addCriterion("admin_auth_create_date >", value, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("admin_auth_create_date >=", value, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateLessThan(Date value) {
            addCriterion("admin_auth_create_date <", value, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("admin_auth_create_date <=", value, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateIn(List<Date> values) {
            addCriterion("admin_auth_create_date in", values, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateNotIn(List<Date> values) {
            addCriterion("admin_auth_create_date not in", values, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateBetween(Date value1, Date value2) {
            addCriterion("admin_auth_create_date between", value1, value2, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("admin_auth_create_date not between", value1, value2, "adminAuthCreateDate");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridIsNull() {
            addCriterion("admin_auth_operatorid is null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridIsNotNull() {
            addCriterion("admin_auth_operatorid is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridEqualTo(Integer value) {
            addCriterion("admin_auth_operatorid =", value, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridNotEqualTo(Integer value) {
            addCriterion("admin_auth_operatorid <>", value, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridGreaterThan(Integer value) {
            addCriterion("admin_auth_operatorid >", value, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_operatorid >=", value, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridLessThan(Integer value) {
            addCriterion("admin_auth_operatorid <", value, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridLessThanOrEqualTo(Integer value) {
            addCriterion("admin_auth_operatorid <=", value, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridIn(List<Integer> values) {
            addCriterion("admin_auth_operatorid in", values, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridNotIn(List<Integer> values) {
            addCriterion("admin_auth_operatorid not in", values, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_operatorid between", value1, value2, "adminAuthOperatorid");
            return (Criteria) this;
        }

        public Criteria andAdminAuthOperatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_auth_operatorid not between", value1, value2, "adminAuthOperatorid");
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
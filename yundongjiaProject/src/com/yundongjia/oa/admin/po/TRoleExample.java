package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdIsNull() {
            addCriterion("role_studio_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdIsNotNull() {
            addCriterion("role_studio_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdEqualTo(Integer value) {
            addCriterion("role_studio_id =", value, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdNotEqualTo(Integer value) {
            addCriterion("role_studio_id <>", value, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdGreaterThan(Integer value) {
            addCriterion("role_studio_id >", value, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_studio_id >=", value, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdLessThan(Integer value) {
            addCriterion("role_studio_id <", value, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_studio_id <=", value, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdIn(List<Integer> values) {
            addCriterion("role_studio_id in", values, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdNotIn(List<Integer> values) {
            addCriterion("role_studio_id not in", values, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdBetween(Integer value1, Integer value2) {
            addCriterion("role_studio_id between", value1, value2, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleStudioIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_studio_id not between", value1, value2, "roleStudioId");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelIsNull() {
            addCriterion("role_isdel is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelIsNotNull() {
            addCriterion("role_isdel is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelEqualTo(String value) {
            addCriterion("role_isdel =", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelNotEqualTo(String value) {
            addCriterion("role_isdel <>", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelGreaterThan(String value) {
            addCriterion("role_isdel >", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelGreaterThanOrEqualTo(String value) {
            addCriterion("role_isdel >=", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelLessThan(String value) {
            addCriterion("role_isdel <", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelLessThanOrEqualTo(String value) {
            addCriterion("role_isdel <=", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelLike(String value) {
            addCriterion("role_isdel like", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelNotLike(String value) {
            addCriterion("role_isdel not like", value, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelIn(List<String> values) {
            addCriterion("role_isdel in", values, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelNotIn(List<String> values) {
            addCriterion("role_isdel not in", values, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelBetween(String value1, String value2) {
            addCriterion("role_isdel between", value1, value2, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleIsdelNotBetween(String value1, String value2) {
            addCriterion("role_isdel not between", value1, value2, "roleIsdel");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkIsNull() {
            addCriterion("role_remark is null");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkIsNotNull() {
            addCriterion("role_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkEqualTo(String value) {
            addCriterion("role_remark =", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotEqualTo(String value) {
            addCriterion("role_remark <>", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkGreaterThan(String value) {
            addCriterion("role_remark >", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("role_remark >=", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkLessThan(String value) {
            addCriterion("role_remark <", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkLessThanOrEqualTo(String value) {
            addCriterion("role_remark <=", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkLike(String value) {
            addCriterion("role_remark like", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotLike(String value) {
            addCriterion("role_remark not like", value, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkIn(List<String> values) {
            addCriterion("role_remark in", values, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotIn(List<String> values) {
            addCriterion("role_remark not in", values, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkBetween(String value1, String value2) {
            addCriterion("role_remark between", value1, value2, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleRemarkNotBetween(String value1, String value2) {
            addCriterion("role_remark not between", value1, value2, "roleRemark");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseIsNull() {
            addCriterion("role_isclose is null");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseIsNotNull() {
            addCriterion("role_isclose is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseEqualTo(String value) {
            addCriterion("role_isclose =", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseNotEqualTo(String value) {
            addCriterion("role_isclose <>", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseGreaterThan(String value) {
            addCriterion("role_isclose >", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseGreaterThanOrEqualTo(String value) {
            addCriterion("role_isclose >=", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseLessThan(String value) {
            addCriterion("role_isclose <", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseLessThanOrEqualTo(String value) {
            addCriterion("role_isclose <=", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseLike(String value) {
            addCriterion("role_isclose like", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseNotLike(String value) {
            addCriterion("role_isclose not like", value, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseIn(List<String> values) {
            addCriterion("role_isclose in", values, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseNotIn(List<String> values) {
            addCriterion("role_isclose not in", values, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseBetween(String value1, String value2) {
            addCriterion("role_isclose between", value1, value2, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleIscloseNotBetween(String value1, String value2) {
            addCriterion("role_isclose not between", value1, value2, "roleIsclose");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridIsNull() {
            addCriterion("role_operatorid is null");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridIsNotNull() {
            addCriterion("role_operatorid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridEqualTo(Integer value) {
            addCriterion("role_operatorid =", value, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridNotEqualTo(Integer value) {
            addCriterion("role_operatorid <>", value, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridGreaterThan(Integer value) {
            addCriterion("role_operatorid >", value, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_operatorid >=", value, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridLessThan(Integer value) {
            addCriterion("role_operatorid <", value, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridLessThanOrEqualTo(Integer value) {
            addCriterion("role_operatorid <=", value, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridIn(List<Integer> values) {
            addCriterion("role_operatorid in", values, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridNotIn(List<Integer> values) {
            addCriterion("role_operatorid not in", values, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridBetween(Integer value1, Integer value2) {
            addCriterion("role_operatorid between", value1, value2, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleOperatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("role_operatorid not between", value1, value2, "roleOperatorid");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateIsNull() {
            addCriterion("role_createdate is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateIsNotNull() {
            addCriterion("role_createdate is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateEqualTo(String value) {
            addCriterion("role_createdate =", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateNotEqualTo(String value) {
            addCriterion("role_createdate <>", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateGreaterThan(String value) {
            addCriterion("role_createdate >", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("role_createdate >=", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateLessThan(String value) {
            addCriterion("role_createdate <", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateLessThanOrEqualTo(String value) {
            addCriterion("role_createdate <=", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateLike(String value) {
            addCriterion("role_createdate like", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateNotLike(String value) {
            addCriterion("role_createdate not like", value, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateIn(List<String> values) {
            addCriterion("role_createdate in", values, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateNotIn(List<String> values) {
            addCriterion("role_createdate not in", values, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateBetween(String value1, String value2) {
            addCriterion("role_createdate between", value1, value2, "roleCreatedate");
            return (Criteria) this;
        }

        public Criteria andRoleCreatedateNotBetween(String value1, String value2) {
            addCriterion("role_createdate not between", value1, value2, "roleCreatedate");
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
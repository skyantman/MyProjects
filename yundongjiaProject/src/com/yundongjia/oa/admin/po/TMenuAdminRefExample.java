package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMenuAdminRefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMenuAdminRefExample() {
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

        public Criteria andMenuAdminIdIsNull() {
            addCriterion("menu_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdIsNotNull() {
            addCriterion("menu_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdEqualTo(Integer value) {
            addCriterion("menu_admin_id =", value, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdNotEqualTo(Integer value) {
            addCriterion("menu_admin_id <>", value, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdGreaterThan(Integer value) {
            addCriterion("menu_admin_id >", value, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_id >=", value, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdLessThan(Integer value) {
            addCriterion("menu_admin_id <", value, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_id <=", value, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdIn(List<Integer> values) {
            addCriterion("menu_admin_id in", values, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdNotIn(List<Integer> values) {
            addCriterion("menu_admin_id not in", values, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_id between", value1, value2, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_id not between", value1, value2, "menuAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdIsNull() {
            addCriterion("menu_admin_menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdIsNotNull() {
            addCriterion("menu_admin_menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdEqualTo(Integer value) {
            addCriterion("menu_admin_menu_id =", value, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_admin_menu_id <>", value, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdGreaterThan(Integer value) {
            addCriterion("menu_admin_menu_id >", value, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_menu_id >=", value, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdLessThan(Integer value) {
            addCriterion("menu_admin_menu_id <", value, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_menu_id <=", value, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdIn(List<Integer> values) {
            addCriterion("menu_admin_menu_id in", values, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_admin_menu_id not in", values, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_menu_id between", value1, value2, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_menu_id not between", value1, value2, "menuAdminMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdIsNull() {
            addCriterion("menu_admin_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdIsNotNull() {
            addCriterion("menu_admin_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id =", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdNotEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id <>", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdGreaterThan(Integer value) {
            addCriterion("menu_admin_admin_id >", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id >=", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdLessThan(Integer value) {
            addCriterion("menu_admin_admin_id <", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_admin_id <=", value, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdIn(List<Integer> values) {
            addCriterion("menu_admin_admin_id in", values, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdNotIn(List<Integer> values) {
            addCriterion("menu_admin_admin_id not in", values, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_admin_id between", value1, value2, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_admin_id not between", value1, value2, "menuAdminAdminId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdIsNull() {
            addCriterion("menu_admin_role_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdIsNotNull() {
            addCriterion("menu_admin_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdEqualTo(String value) {
            addCriterion("menu_admin_role_id =", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdNotEqualTo(String value) {
            addCriterion("menu_admin_role_id <>", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdGreaterThan(String value) {
            addCriterion("menu_admin_role_id >", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_admin_role_id >=", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdLessThan(String value) {
            addCriterion("menu_admin_role_id <", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdLessThanOrEqualTo(String value) {
            addCriterion("menu_admin_role_id <=", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdLike(String value) {
            addCriterion("menu_admin_role_id like", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdNotLike(String value) {
            addCriterion("menu_admin_role_id not like", value, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdIn(List<String> values) {
            addCriterion("menu_admin_role_id in", values, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdNotIn(List<String> values) {
            addCriterion("menu_admin_role_id not in", values, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdBetween(String value1, String value2) {
            addCriterion("menu_admin_role_id between", value1, value2, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminRoleIdNotBetween(String value1, String value2) {
            addCriterion("menu_admin_role_id not between", value1, value2, "menuAdminRoleId");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeIsNull() {
            addCriterion("menu_admin_type is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeIsNotNull() {
            addCriterion("menu_admin_type is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeEqualTo(Byte value) {
            addCriterion("menu_admin_type =", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeNotEqualTo(Byte value) {
            addCriterion("menu_admin_type <>", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeGreaterThan(Byte value) {
            addCriterion("menu_admin_type >", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("menu_admin_type >=", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeLessThan(Byte value) {
            addCriterion("menu_admin_type <", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeLessThanOrEqualTo(Byte value) {
            addCriterion("menu_admin_type <=", value, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeIn(List<Byte> values) {
            addCriterion("menu_admin_type in", values, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeNotIn(List<Byte> values) {
            addCriterion("menu_admin_type not in", values, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeBetween(Byte value1, Byte value2) {
            addCriterion("menu_admin_type between", value1, value2, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("menu_admin_type not between", value1, value2, "menuAdminType");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateIsNull() {
            addCriterion("menu_admin_create_date is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateIsNotNull() {
            addCriterion("menu_admin_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateEqualTo(Date value) {
            addCriterion("menu_admin_create_date =", value, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateNotEqualTo(Date value) {
            addCriterion("menu_admin_create_date <>", value, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateGreaterThan(Date value) {
            addCriterion("menu_admin_create_date >", value, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("menu_admin_create_date >=", value, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateLessThan(Date value) {
            addCriterion("menu_admin_create_date <", value, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("menu_admin_create_date <=", value, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateIn(List<Date> values) {
            addCriterion("menu_admin_create_date in", values, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateNotIn(List<Date> values) {
            addCriterion("menu_admin_create_date not in", values, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateBetween(Date value1, Date value2) {
            addCriterion("menu_admin_create_date between", value1, value2, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("menu_admin_create_date not between", value1, value2, "menuAdminCreateDate");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridIsNull() {
            addCriterion("menu_admin_operatorid is null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridIsNotNull() {
            addCriterion("menu_admin_operatorid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridEqualTo(Integer value) {
            addCriterion("menu_admin_operatorid =", value, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridNotEqualTo(Integer value) {
            addCriterion("menu_admin_operatorid <>", value, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridGreaterThan(Integer value) {
            addCriterion("menu_admin_operatorid >", value, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_operatorid >=", value, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridLessThan(Integer value) {
            addCriterion("menu_admin_operatorid <", value, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridLessThanOrEqualTo(Integer value) {
            addCriterion("menu_admin_operatorid <=", value, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridIn(List<Integer> values) {
            addCriterion("menu_admin_operatorid in", values, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridNotIn(List<Integer> values) {
            addCriterion("menu_admin_operatorid not in", values, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_operatorid between", value1, value2, "menuAdminOperatorid");
            return (Criteria) this;
        }

        public Criteria andMenuAdminOperatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_admin_operatorid not between", value1, value2, "menuAdminOperatorid");
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
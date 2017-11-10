package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TAdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAdminExample() {
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

        public Criteria andBackuseridIsNull() {
            addCriterion("backuserId is null");
            return (Criteria) this;
        }

        public Criteria andBackuseridIsNotNull() {
            addCriterion("backuserId is not null");
            return (Criteria) this;
        }

        public Criteria andBackuseridEqualTo(Integer value) {
            addCriterion("backuserId =", value, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridNotEqualTo(Integer value) {
            addCriterion("backuserId <>", value, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridGreaterThan(Integer value) {
            addCriterion("backuserId >", value, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("backuserId >=", value, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridLessThan(Integer value) {
            addCriterion("backuserId <", value, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridLessThanOrEqualTo(Integer value) {
            addCriterion("backuserId <=", value, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridIn(List<Integer> values) {
            addCriterion("backuserId in", values, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridNotIn(List<Integer> values) {
            addCriterion("backuserId not in", values, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridBetween(Integer value1, Integer value2) {
            addCriterion("backuserId between", value1, value2, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("backuserId not between", value1, value2, "backuserid");
            return (Criteria) this;
        }

        public Criteria andBackusernameIsNull() {
            addCriterion("backuserName is null");
            return (Criteria) this;
        }

        public Criteria andBackusernameIsNotNull() {
            addCriterion("backuserName is not null");
            return (Criteria) this;
        }

        public Criteria andBackusernameEqualTo(String value) {
            addCriterion("backuserName =", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameNotEqualTo(String value) {
            addCriterion("backuserName <>", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameGreaterThan(String value) {
            addCriterion("backuserName >", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameGreaterThanOrEqualTo(String value) {
            addCriterion("backuserName >=", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameLessThan(String value) {
            addCriterion("backuserName <", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameLessThanOrEqualTo(String value) {
            addCriterion("backuserName <=", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameLike(String value) {
            addCriterion("backuserName like", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameNotLike(String value) {
            addCriterion("backuserName not like", value, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameIn(List<String> values) {
            addCriterion("backuserName in", values, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameNotIn(List<String> values) {
            addCriterion("backuserName not in", values, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameBetween(String value1, String value2) {
            addCriterion("backuserName between", value1, value2, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackusernameNotBetween(String value1, String value2) {
            addCriterion("backuserName not between", value1, value2, "backusername");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdIsNull() {
            addCriterion("backuserPwd is null");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdIsNotNull() {
            addCriterion("backuserPwd is not null");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdEqualTo(String value) {
            addCriterion("backuserPwd =", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdNotEqualTo(String value) {
            addCriterion("backuserPwd <>", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdGreaterThan(String value) {
            addCriterion("backuserPwd >", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdGreaterThanOrEqualTo(String value) {
            addCriterion("backuserPwd >=", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdLessThan(String value) {
            addCriterion("backuserPwd <", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdLessThanOrEqualTo(String value) {
            addCriterion("backuserPwd <=", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdLike(String value) {
            addCriterion("backuserPwd like", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdNotLike(String value) {
            addCriterion("backuserPwd not like", value, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdIn(List<String> values) {
            addCriterion("backuserPwd in", values, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdNotIn(List<String> values) {
            addCriterion("backuserPwd not in", values, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdBetween(String value1, String value2) {
            addCriterion("backuserPwd between", value1, value2, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserpwdNotBetween(String value1, String value2) {
            addCriterion("backuserPwd not between", value1, value2, "backuserpwd");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidIsNull() {
            addCriterion("backuserRoleId is null");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidIsNotNull() {
            addCriterion("backuserRoleId is not null");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidEqualTo(Integer value) {
            addCriterion("backuserRoleId =", value, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidNotEqualTo(Integer value) {
            addCriterion("backuserRoleId <>", value, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidGreaterThan(Integer value) {
            addCriterion("backuserRoleId >", value, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("backuserRoleId >=", value, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidLessThan(Integer value) {
            addCriterion("backuserRoleId <", value, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidLessThanOrEqualTo(Integer value) {
            addCriterion("backuserRoleId <=", value, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidIn(List<Integer> values) {
            addCriterion("backuserRoleId in", values, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidNotIn(List<Integer> values) {
            addCriterion("backuserRoleId not in", values, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidBetween(Integer value1, Integer value2) {
            addCriterion("backuserRoleId between", value1, value2, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackuserroleidNotBetween(Integer value1, Integer value2) {
            addCriterion("backuserRoleId not between", value1, value2, "backuserroleid");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneIsNull() {
            addCriterion("backuserMobliePhone is null");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneIsNotNull() {
            addCriterion("backuserMobliePhone is not null");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneEqualTo(String value) {
            addCriterion("backuserMobliePhone =", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneNotEqualTo(String value) {
            addCriterion("backuserMobliePhone <>", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneGreaterThan(String value) {
            addCriterion("backuserMobliePhone >", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneGreaterThanOrEqualTo(String value) {
            addCriterion("backuserMobliePhone >=", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneLessThan(String value) {
            addCriterion("backuserMobliePhone <", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneLessThanOrEqualTo(String value) {
            addCriterion("backuserMobliePhone <=", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneLike(String value) {
            addCriterion("backuserMobliePhone like", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneNotLike(String value) {
            addCriterion("backuserMobliePhone not like", value, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneIn(List<String> values) {
            addCriterion("backuserMobliePhone in", values, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneNotIn(List<String> values) {
            addCriterion("backuserMobliePhone not in", values, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneBetween(String value1, String value2) {
            addCriterion("backuserMobliePhone between", value1, value2, "backusermobliephone");
            return (Criteria) this;
        }

        public Criteria andBackusermobliephoneNotBetween(String value1, String value2) {
            addCriterion("backuserMobliePhone not between", value1, value2, "backusermobliephone");
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
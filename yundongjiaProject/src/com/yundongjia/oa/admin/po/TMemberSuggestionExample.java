package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TMemberSuggestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMemberSuggestionExample() {
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

        public Criteria andSuggestionidIsNull() {
            addCriterion("suggestionId is null");
            return (Criteria) this;
        }

        public Criteria andSuggestionidIsNotNull() {
            addCriterion("suggestionId is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestionidEqualTo(Integer value) {
            addCriterion("suggestionId =", value, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidNotEqualTo(Integer value) {
            addCriterion("suggestionId <>", value, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidGreaterThan(Integer value) {
            addCriterion("suggestionId >", value, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("suggestionId >=", value, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidLessThan(Integer value) {
            addCriterion("suggestionId <", value, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidLessThanOrEqualTo(Integer value) {
            addCriterion("suggestionId <=", value, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidIn(List<Integer> values) {
            addCriterion("suggestionId in", values, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidNotIn(List<Integer> values) {
            addCriterion("suggestionId not in", values, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidBetween(Integer value1, Integer value2) {
            addCriterion("suggestionId between", value1, value2, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andSuggestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("suggestionId not between", value1, value2, "suggestionid");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoIsNull() {
            addCriterion("mobilePhoneNo is null");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoIsNotNull() {
            addCriterion("mobilePhoneNo is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoEqualTo(String value) {
            addCriterion("mobilePhoneNo =", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoNotEqualTo(String value) {
            addCriterion("mobilePhoneNo <>", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoGreaterThan(String value) {
            addCriterion("mobilePhoneNo >", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoGreaterThanOrEqualTo(String value) {
            addCriterion("mobilePhoneNo >=", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoLessThan(String value) {
            addCriterion("mobilePhoneNo <", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoLessThanOrEqualTo(String value) {
            addCriterion("mobilePhoneNo <=", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoLike(String value) {
            addCriterion("mobilePhoneNo like", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoNotLike(String value) {
            addCriterion("mobilePhoneNo not like", value, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoIn(List<String> values) {
            addCriterion("mobilePhoneNo in", values, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoNotIn(List<String> values) {
            addCriterion("mobilePhoneNo not in", values, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoBetween(String value1, String value2) {
            addCriterion("mobilePhoneNo between", value1, value2, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephonenoNotBetween(String value1, String value2) {
            addCriterion("mobilePhoneNo not between", value1, value2, "mobilephoneno");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoIsNull() {
            addCriterion("suggestionInfo is null");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoIsNotNull() {
            addCriterion("suggestionInfo is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoEqualTo(String value) {
            addCriterion("suggestionInfo =", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoNotEqualTo(String value) {
            addCriterion("suggestionInfo <>", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoGreaterThan(String value) {
            addCriterion("suggestionInfo >", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoGreaterThanOrEqualTo(String value) {
            addCriterion("suggestionInfo >=", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoLessThan(String value) {
            addCriterion("suggestionInfo <", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoLessThanOrEqualTo(String value) {
            addCriterion("suggestionInfo <=", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoLike(String value) {
            addCriterion("suggestionInfo like", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoNotLike(String value) {
            addCriterion("suggestionInfo not like", value, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoIn(List<String> values) {
            addCriterion("suggestionInfo in", values, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoNotIn(List<String> values) {
            addCriterion("suggestionInfo not in", values, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoBetween(String value1, String value2) {
            addCriterion("suggestionInfo between", value1, value2, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andSuggestioninfoNotBetween(String value1, String value2) {
            addCriterion("suggestionInfo not between", value1, value2, "suggestioninfo");
            return (Criteria) this;
        }

        public Criteria andLikeridIsNull() {
            addCriterion("likerId is null");
            return (Criteria) this;
        }

        public Criteria andLikeridIsNotNull() {
            addCriterion("likerId is not null");
            return (Criteria) this;
        }

        public Criteria andLikeridEqualTo(Integer value) {
            addCriterion("likerId =", value, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridNotEqualTo(Integer value) {
            addCriterion("likerId <>", value, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridGreaterThan(Integer value) {
            addCriterion("likerId >", value, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("likerId >=", value, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridLessThan(Integer value) {
            addCriterion("likerId <", value, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridLessThanOrEqualTo(Integer value) {
            addCriterion("likerId <=", value, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridIn(List<Integer> values) {
            addCriterion("likerId in", values, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridNotIn(List<Integer> values) {
            addCriterion("likerId not in", values, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridBetween(Integer value1, Integer value2) {
            addCriterion("likerId between", value1, value2, "likerid");
            return (Criteria) this;
        }

        public Criteria andLikeridNotBetween(Integer value1, Integer value2) {
            addCriterion("likerId not between", value1, value2, "likerid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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
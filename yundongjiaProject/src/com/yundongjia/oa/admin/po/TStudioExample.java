package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TStudioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStudioExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andStudionameIsNull() {
            addCriterion("studioName is null");
            return (Criteria) this;
        }

        public Criteria andStudionameIsNotNull() {
            addCriterion("studioName is not null");
            return (Criteria) this;
        }

        public Criteria andStudionameEqualTo(String value) {
            addCriterion("studioName =", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotEqualTo(String value) {
            addCriterion("studioName <>", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameGreaterThan(String value) {
            addCriterion("studioName >", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameGreaterThanOrEqualTo(String value) {
            addCriterion("studioName >=", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameLessThan(String value) {
            addCriterion("studioName <", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameLessThanOrEqualTo(String value) {
            addCriterion("studioName <=", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameLike(String value) {
            addCriterion("studioName like", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotLike(String value) {
            addCriterion("studioName not like", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameIn(List<String> values) {
            addCriterion("studioName in", values, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotIn(List<String> values) {
            addCriterion("studioName not in", values, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameBetween(String value1, String value2) {
            addCriterion("studioName between", value1, value2, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotBetween(String value1, String value2) {
            addCriterion("studioName not between", value1, value2, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeIsNull() {
            addCriterion("studioOpentime is null");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeIsNotNull() {
            addCriterion("studioOpentime is not null");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeEqualTo(String value) {
            addCriterion("studioOpentime =", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeNotEqualTo(String value) {
            addCriterion("studioOpentime <>", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeGreaterThan(String value) {
            addCriterion("studioOpentime >", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeGreaterThanOrEqualTo(String value) {
            addCriterion("studioOpentime >=", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeLessThan(String value) {
            addCriterion("studioOpentime <", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeLessThanOrEqualTo(String value) {
            addCriterion("studioOpentime <=", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeLike(String value) {
            addCriterion("studioOpentime like", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeNotLike(String value) {
            addCriterion("studioOpentime not like", value, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeIn(List<String> values) {
            addCriterion("studioOpentime in", values, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeNotIn(List<String> values) {
            addCriterion("studioOpentime not in", values, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeBetween(String value1, String value2) {
            addCriterion("studioOpentime between", value1, value2, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioopentimeNotBetween(String value1, String value2) {
            addCriterion("studioOpentime not between", value1, value2, "studioopentime");
            return (Criteria) this;
        }

        public Criteria andStudioaddrIsNull() {
            addCriterion("studioAddr is null");
            return (Criteria) this;
        }

        public Criteria andStudioaddrIsNotNull() {
            addCriterion("studioAddr is not null");
            return (Criteria) this;
        }

        public Criteria andStudioaddrEqualTo(String value) {
            addCriterion("studioAddr =", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrNotEqualTo(String value) {
            addCriterion("studioAddr <>", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrGreaterThan(String value) {
            addCriterion("studioAddr >", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrGreaterThanOrEqualTo(String value) {
            addCriterion("studioAddr >=", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrLessThan(String value) {
            addCriterion("studioAddr <", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrLessThanOrEqualTo(String value) {
            addCriterion("studioAddr <=", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrLike(String value) {
            addCriterion("studioAddr like", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrNotLike(String value) {
            addCriterion("studioAddr not like", value, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrIn(List<String> values) {
            addCriterion("studioAddr in", values, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrNotIn(List<String> values) {
            addCriterion("studioAddr not in", values, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrBetween(String value1, String value2) {
            addCriterion("studioAddr between", value1, value2, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudioaddrNotBetween(String value1, String value2) {
            addCriterion("studioAddr not between", value1, value2, "studioaddr");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceIsNull() {
            addCriterion("studioIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceIsNotNull() {
            addCriterion("studioIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceEqualTo(String value) {
            addCriterion("studioIntroduce =", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceNotEqualTo(String value) {
            addCriterion("studioIntroduce <>", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceGreaterThan(String value) {
            addCriterion("studioIntroduce >", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceGreaterThanOrEqualTo(String value) {
            addCriterion("studioIntroduce >=", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceLessThan(String value) {
            addCriterion("studioIntroduce <", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceLessThanOrEqualTo(String value) {
            addCriterion("studioIntroduce <=", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceLike(String value) {
            addCriterion("studioIntroduce like", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceNotLike(String value) {
            addCriterion("studioIntroduce not like", value, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceIn(List<String> values) {
            addCriterion("studioIntroduce in", values, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceNotIn(List<String> values) {
            addCriterion("studioIntroduce not in", values, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceBetween(String value1, String value2) {
            addCriterion("studioIntroduce between", value1, value2, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudiointroduceNotBetween(String value1, String value2) {
            addCriterion("studioIntroduce not between", value1, value2, "studiointroduce");
            return (Criteria) this;
        }

        public Criteria andStudioequipIsNull() {
            addCriterion("studioEquip is null");
            return (Criteria) this;
        }

        public Criteria andStudioequipIsNotNull() {
            addCriterion("studioEquip is not null");
            return (Criteria) this;
        }

        public Criteria andStudioequipEqualTo(String value) {
            addCriterion("studioEquip =", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipNotEqualTo(String value) {
            addCriterion("studioEquip <>", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipGreaterThan(String value) {
            addCriterion("studioEquip >", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipGreaterThanOrEqualTo(String value) {
            addCriterion("studioEquip >=", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipLessThan(String value) {
            addCriterion("studioEquip <", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipLessThanOrEqualTo(String value) {
            addCriterion("studioEquip <=", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipLike(String value) {
            addCriterion("studioEquip like", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipNotLike(String value) {
            addCriterion("studioEquip not like", value, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipIn(List<String> values) {
            addCriterion("studioEquip in", values, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipNotIn(List<String> values) {
            addCriterion("studioEquip not in", values, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipBetween(String value1, String value2) {
            addCriterion("studioEquip between", value1, value2, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudioequipNotBetween(String value1, String value2) {
            addCriterion("studioEquip not between", value1, value2, "studioequip");
            return (Criteria) this;
        }

        public Criteria andStudiotelIsNull() {
            addCriterion("studioTel is null");
            return (Criteria) this;
        }

        public Criteria andStudiotelIsNotNull() {
            addCriterion("studioTel is not null");
            return (Criteria) this;
        }

        public Criteria andStudiotelEqualTo(String value) {
            addCriterion("studioTel =", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelNotEqualTo(String value) {
            addCriterion("studioTel <>", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelGreaterThan(String value) {
            addCriterion("studioTel >", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelGreaterThanOrEqualTo(String value) {
            addCriterion("studioTel >=", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelLessThan(String value) {
            addCriterion("studioTel <", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelLessThanOrEqualTo(String value) {
            addCriterion("studioTel <=", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelLike(String value) {
            addCriterion("studioTel like", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelNotLike(String value) {
            addCriterion("studioTel not like", value, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelIn(List<String> values) {
            addCriterion("studioTel in", values, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelNotIn(List<String> values) {
            addCriterion("studioTel not in", values, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelBetween(String value1, String value2) {
            addCriterion("studioTel between", value1, value2, "studiotel");
            return (Criteria) this;
        }

        public Criteria andStudiotelNotBetween(String value1, String value2) {
            addCriterion("studioTel not between", value1, value2, "studiotel");
            return (Criteria) this;
        }

        public Criteria andSupertelIsNull() {
            addCriterion("superTel is null");
            return (Criteria) this;
        }

        public Criteria andSupertelIsNotNull() {
            addCriterion("superTel is not null");
            return (Criteria) this;
        }

        public Criteria andSupertelEqualTo(String value) {
            addCriterion("superTel =", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelNotEqualTo(String value) {
            addCriterion("superTel <>", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelGreaterThan(String value) {
            addCriterion("superTel >", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelGreaterThanOrEqualTo(String value) {
            addCriterion("superTel >=", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelLessThan(String value) {
            addCriterion("superTel <", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelLessThanOrEqualTo(String value) {
            addCriterion("superTel <=", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelLike(String value) {
            addCriterion("superTel like", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelNotLike(String value) {
            addCriterion("superTel not like", value, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelIn(List<String> values) {
            addCriterion("superTel in", values, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelNotIn(List<String> values) {
            addCriterion("superTel not in", values, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelBetween(String value1, String value2) {
            addCriterion("superTel between", value1, value2, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupertelNotBetween(String value1, String value2) {
            addCriterion("superTel not between", value1, value2, "supertel");
            return (Criteria) this;
        }

        public Criteria andSupernameIsNull() {
            addCriterion("superName is null");
            return (Criteria) this;
        }

        public Criteria andSupernameIsNotNull() {
            addCriterion("superName is not null");
            return (Criteria) this;
        }

        public Criteria andSupernameEqualTo(String value) {
            addCriterion("superName =", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameNotEqualTo(String value) {
            addCriterion("superName <>", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameGreaterThan(String value) {
            addCriterion("superName >", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameGreaterThanOrEqualTo(String value) {
            addCriterion("superName >=", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameLessThan(String value) {
            addCriterion("superName <", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameLessThanOrEqualTo(String value) {
            addCriterion("superName <=", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameLike(String value) {
            addCriterion("superName like", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameNotLike(String value) {
            addCriterion("superName not like", value, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameIn(List<String> values) {
            addCriterion("superName in", values, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameNotIn(List<String> values) {
            addCriterion("superName not in", values, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameBetween(String value1, String value2) {
            addCriterion("superName between", value1, value2, "supername");
            return (Criteria) this;
        }

        public Criteria andSupernameNotBetween(String value1, String value2) {
            addCriterion("superName not between", value1, value2, "supername");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andIslineIsNull() {
            addCriterion("isLine is null");
            return (Criteria) this;
        }

        public Criteria andIslineIsNotNull() {
            addCriterion("isLine is not null");
            return (Criteria) this;
        }

        public Criteria andIslineEqualTo(String value) {
            addCriterion("isLine =", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineNotEqualTo(String value) {
            addCriterion("isLine <>", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineGreaterThan(String value) {
            addCriterion("isLine >", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineGreaterThanOrEqualTo(String value) {
            addCriterion("isLine >=", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineLessThan(String value) {
            addCriterion("isLine <", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineLessThanOrEqualTo(String value) {
            addCriterion("isLine <=", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineLike(String value) {
            addCriterion("isLine like", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineNotLike(String value) {
            addCriterion("isLine not like", value, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineIn(List<String> values) {
            addCriterion("isLine in", values, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineNotIn(List<String> values) {
            addCriterion("isLine not in", values, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineBetween(String value1, String value2) {
            addCriterion("isLine between", value1, value2, "isline");
            return (Criteria) this;
        }

        public Criteria andIslineNotBetween(String value1, String value2) {
            addCriterion("isLine not between", value1, value2, "isline");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyIsNull() {
            addCriterion("consumeMoney is null");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyIsNotNull() {
            addCriterion("consumeMoney is not null");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyEqualTo(Double value) {
            addCriterion("consumeMoney =", value, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyNotEqualTo(Double value) {
            addCriterion("consumeMoney <>", value, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyGreaterThan(Double value) {
            addCriterion("consumeMoney >", value, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("consumeMoney >=", value, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyLessThan(Double value) {
            addCriterion("consumeMoney <", value, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyLessThanOrEqualTo(Double value) {
            addCriterion("consumeMoney <=", value, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyIn(List<Double> values) {
            addCriterion("consumeMoney in", values, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyNotIn(List<Double> values) {
            addCriterion("consumeMoney not in", values, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyBetween(Double value1, Double value2) {
            addCriterion("consumeMoney between", value1, value2, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andConsumemoneyNotBetween(Double value1, Double value2) {
            addCriterion("consumeMoney not between", value1, value2, "consumemoney");
            return (Criteria) this;
        }

        public Criteria andRegionsidIsNull() {
            addCriterion("regionsId is null");
            return (Criteria) this;
        }

        public Criteria andRegionsidIsNotNull() {
            addCriterion("regionsId is not null");
            return (Criteria) this;
        }

        public Criteria andRegionsidEqualTo(Integer value) {
            addCriterion("regionsId =", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidNotEqualTo(Integer value) {
            addCriterion("regionsId <>", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidGreaterThan(Integer value) {
            addCriterion("regionsId >", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("regionsId >=", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidLessThan(Integer value) {
            addCriterion("regionsId <", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidLessThanOrEqualTo(Integer value) {
            addCriterion("regionsId <=", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidIn(List<Integer> values) {
            addCriterion("regionsId in", values, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidNotIn(List<Integer> values) {
            addCriterion("regionsId not in", values, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidBetween(Integer value1, Integer value2) {
            addCriterion("regionsId between", value1, value2, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidNotBetween(Integer value1, Integer value2) {
            addCriterion("regionsId not between", value1, value2, "regionsid");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andCommIsNull() {
            addCriterion("comm is null");
            return (Criteria) this;
        }

        public Criteria andCommIsNotNull() {
            addCriterion("comm is not null");
            return (Criteria) this;
        }

        public Criteria andCommEqualTo(String value) {
            addCriterion("comm =", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotEqualTo(String value) {
            addCriterion("comm <>", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThan(String value) {
            addCriterion("comm >", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThanOrEqualTo(String value) {
            addCriterion("comm >=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThan(String value) {
            addCriterion("comm <", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThanOrEqualTo(String value) {
            addCriterion("comm <=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLike(String value) {
            addCriterion("comm like", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotLike(String value) {
            addCriterion("comm not like", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommIn(List<String> values) {
            addCriterion("comm in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotIn(List<String> values) {
            addCriterion("comm not in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommBetween(String value1, String value2) {
            addCriterion("comm between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotBetween(String value1, String value2) {
            addCriterion("comm not between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andCanclelimitIsNull() {
            addCriterion("cancleLimit is null");
            return (Criteria) this;
        }

        public Criteria andCanclelimitIsNotNull() {
            addCriterion("cancleLimit is not null");
            return (Criteria) this;
        }

        public Criteria andCanclelimitEqualTo(Integer value) {
            addCriterion("cancleLimit =", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitNotEqualTo(Integer value) {
            addCriterion("cancleLimit <>", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitGreaterThan(Integer value) {
            addCriterion("cancleLimit >", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancleLimit >=", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitLessThan(Integer value) {
            addCriterion("cancleLimit <", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitLessThanOrEqualTo(Integer value) {
            addCriterion("cancleLimit <=", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitIn(List<Integer> values) {
            addCriterion("cancleLimit in", values, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitNotIn(List<Integer> values) {
            addCriterion("cancleLimit not in", values, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitBetween(Integer value1, Integer value2) {
            addCriterion("cancleLimit between", value1, value2, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitNotBetween(Integer value1, Integer value2) {
            addCriterion("cancleLimit not between", value1, value2, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumIsNull() {
            addCriterion("enterpriseSubNum is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumIsNotNull() {
            addCriterion("enterpriseSubNum is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumEqualTo(Integer value) {
            addCriterion("enterpriseSubNum =", value, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumNotEqualTo(Integer value) {
            addCriterion("enterpriseSubNum <>", value, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumGreaterThan(Integer value) {
            addCriterion("enterpriseSubNum >", value, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterpriseSubNum >=", value, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumLessThan(Integer value) {
            addCriterion("enterpriseSubNum <", value, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumLessThanOrEqualTo(Integer value) {
            addCriterion("enterpriseSubNum <=", value, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumIn(List<Integer> values) {
            addCriterion("enterpriseSubNum in", values, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumNotIn(List<Integer> values) {
            addCriterion("enterpriseSubNum not in", values, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseSubNum between", value1, value2, "enterprisesubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisesubnumNotBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseSubNum not between", value1, value2, "enterprisesubnum");
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

        public Criteria andGradescoreIsNull() {
            addCriterion("gradeScore is null");
            return (Criteria) this;
        }

        public Criteria andGradescoreIsNotNull() {
            addCriterion("gradeScore is not null");
            return (Criteria) this;
        }

        public Criteria andGradescoreEqualTo(Double value) {
            addCriterion("gradeScore =", value, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreNotEqualTo(Double value) {
            addCriterion("gradeScore <>", value, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreGreaterThan(Double value) {
            addCriterion("gradeScore >", value, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreGreaterThanOrEqualTo(Double value) {
            addCriterion("gradeScore >=", value, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreLessThan(Double value) {
            addCriterion("gradeScore <", value, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreLessThanOrEqualTo(Double value) {
            addCriterion("gradeScore <=", value, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreIn(List<Double> values) {
            addCriterion("gradeScore in", values, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreNotIn(List<Double> values) {
            addCriterion("gradeScore not in", values, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreBetween(Double value1, Double value2) {
            addCriterion("gradeScore between", value1, value2, "gradescore");
            return (Criteria) this;
        }

        public Criteria andGradescoreNotBetween(Double value1, Double value2) {
            addCriterion("gradeScore not between", value1, value2, "gradescore");
            return (Criteria) this;
        }

        public Criteria andIsreserveIsNull() {
            addCriterion("isReserve is null");
            return (Criteria) this;
        }

        public Criteria andIsreserveIsNotNull() {
            addCriterion("isReserve is not null");
            return (Criteria) this;
        }

        public Criteria andIsreserveEqualTo(Integer value) {
            addCriterion("isReserve =", value, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveNotEqualTo(Integer value) {
            addCriterion("isReserve <>", value, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveGreaterThan(Integer value) {
            addCriterion("isReserve >", value, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveGreaterThanOrEqualTo(Integer value) {
            addCriterion("isReserve >=", value, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveLessThan(Integer value) {
            addCriterion("isReserve <", value, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveLessThanOrEqualTo(Integer value) {
            addCriterion("isReserve <=", value, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveIn(List<Integer> values) {
            addCriterion("isReserve in", values, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveNotIn(List<Integer> values) {
            addCriterion("isReserve not in", values, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveBetween(Integer value1, Integer value2) {
            addCriterion("isReserve between", value1, value2, "isreserve");
            return (Criteria) this;
        }

        public Criteria andIsreserveNotBetween(Integer value1, Integer value2) {
            addCriterion("isReserve not between", value1, value2, "isreserve");
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
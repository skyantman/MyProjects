package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TMemberCouponRefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMemberCouponRefExample() {
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

        public Criteria andCouponidIsNull() {
            addCriterion("couponId is null");
            return (Criteria) this;
        }

        public Criteria andCouponidIsNotNull() {
            addCriterion("couponId is not null");
            return (Criteria) this;
        }

        public Criteria andCouponidEqualTo(Integer value) {
            addCriterion("couponId =", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidNotEqualTo(Integer value) {
            addCriterion("couponId <>", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidGreaterThan(Integer value) {
            addCriterion("couponId >", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidGreaterThanOrEqualTo(Integer value) {
            addCriterion("couponId >=", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidLessThan(Integer value) {
            addCriterion("couponId <", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidLessThanOrEqualTo(Integer value) {
            addCriterion("couponId <=", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidIn(List<Integer> values) {
            addCriterion("couponId in", values, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidNotIn(List<Integer> values) {
            addCriterion("couponId not in", values, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidBetween(Integer value1, Integer value2) {
            addCriterion("couponId between", value1, value2, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidNotBetween(Integer value1, Integer value2) {
            addCriterion("couponId not between", value1, value2, "couponid");
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
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

        public Criteria andExpirtiondateIsNull() {
            addCriterion("expirtionDate is null");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateIsNotNull() {
            addCriterion("expirtionDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateEqualTo(String value) {
            addCriterion("expirtionDate =", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateNotEqualTo(String value) {
            addCriterion("expirtionDate <>", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateGreaterThan(String value) {
            addCriterion("expirtionDate >", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateGreaterThanOrEqualTo(String value) {
            addCriterion("expirtionDate >=", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateLessThan(String value) {
            addCriterion("expirtionDate <", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateLessThanOrEqualTo(String value) {
            addCriterion("expirtionDate <=", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateLike(String value) {
            addCriterion("expirtionDate like", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateNotLike(String value) {
            addCriterion("expirtionDate not like", value, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateIn(List<String> values) {
            addCriterion("expirtionDate in", values, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateNotIn(List<String> values) {
            addCriterion("expirtionDate not in", values, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateBetween(String value1, String value2) {
            addCriterion("expirtionDate between", value1, value2, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andExpirtiondateNotBetween(String value1, String value2) {
            addCriterion("expirtionDate not between", value1, value2, "expirtiondate");
            return (Criteria) this;
        }

        public Criteria andDiscountamountIsNull() {
            addCriterion("discountAmount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountamountIsNotNull() {
            addCriterion("discountAmount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountamountEqualTo(Double value) {
            addCriterion("discountAmount =", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountNotEqualTo(Double value) {
            addCriterion("discountAmount <>", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountGreaterThan(Double value) {
            addCriterion("discountAmount >", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountGreaterThanOrEqualTo(Double value) {
            addCriterion("discountAmount >=", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountLessThan(Double value) {
            addCriterion("discountAmount <", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountLessThanOrEqualTo(Double value) {
            addCriterion("discountAmount <=", value, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountIn(List<Double> values) {
            addCriterion("discountAmount in", values, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountNotIn(List<Double> values) {
            addCriterion("discountAmount not in", values, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountBetween(Double value1, Double value2) {
            addCriterion("discountAmount between", value1, value2, "discountamount");
            return (Criteria) this;
        }

        public Criteria andDiscountamountNotBetween(Double value1, Double value2) {
            addCriterion("discountAmount not between", value1, value2, "discountamount");
            return (Criteria) this;
        }

        public Criteria andCoupontypeIsNull() {
            addCriterion("couponType is null");
            return (Criteria) this;
        }

        public Criteria andCoupontypeIsNotNull() {
            addCriterion("couponType is not null");
            return (Criteria) this;
        }

        public Criteria andCoupontypeEqualTo(String value) {
            addCriterion("couponType =", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeNotEqualTo(String value) {
            addCriterion("couponType <>", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeGreaterThan(String value) {
            addCriterion("couponType >", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeGreaterThanOrEqualTo(String value) {
            addCriterion("couponType >=", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeLessThan(String value) {
            addCriterion("couponType <", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeLessThanOrEqualTo(String value) {
            addCriterion("couponType <=", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeLike(String value) {
            addCriterion("couponType like", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeNotLike(String value) {
            addCriterion("couponType not like", value, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeIn(List<String> values) {
            addCriterion("couponType in", values, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeNotIn(List<String> values) {
            addCriterion("couponType not in", values, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeBetween(String value1, String value2) {
            addCriterion("couponType between", value1, value2, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCoupontypeNotBetween(String value1, String value2) {
            addCriterion("couponType not between", value1, value2, "coupontype");
            return (Criteria) this;
        }

        public Criteria andCouponmethodIsNull() {
            addCriterion("couponMethod is null");
            return (Criteria) this;
        }

        public Criteria andCouponmethodIsNotNull() {
            addCriterion("couponMethod is not null");
            return (Criteria) this;
        }

        public Criteria andCouponmethodEqualTo(String value) {
            addCriterion("couponMethod =", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodNotEqualTo(String value) {
            addCriterion("couponMethod <>", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodGreaterThan(String value) {
            addCriterion("couponMethod >", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodGreaterThanOrEqualTo(String value) {
            addCriterion("couponMethod >=", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodLessThan(String value) {
            addCriterion("couponMethod <", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodLessThanOrEqualTo(String value) {
            addCriterion("couponMethod <=", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodLike(String value) {
            addCriterion("couponMethod like", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodNotLike(String value) {
            addCriterion("couponMethod not like", value, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodIn(List<String> values) {
            addCriterion("couponMethod in", values, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodNotIn(List<String> values) {
            addCriterion("couponMethod not in", values, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodBetween(String value1, String value2) {
            addCriterion("couponMethod between", value1, value2, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andCouponmethodNotBetween(String value1, String value2) {
            addCriterion("couponMethod not between", value1, value2, "couponmethod");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIsNull() {
            addCriterion("maxMoney is null");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIsNotNull() {
            addCriterion("maxMoney is not null");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyEqualTo(Double value) {
            addCriterion("maxMoney =", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotEqualTo(Double value) {
            addCriterion("maxMoney <>", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyGreaterThan(Double value) {
            addCriterion("maxMoney >", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("maxMoney >=", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyLessThan(Double value) {
            addCriterion("maxMoney <", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyLessThanOrEqualTo(Double value) {
            addCriterion("maxMoney <=", value, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyIn(List<Double> values) {
            addCriterion("maxMoney in", values, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotIn(List<Double> values) {
            addCriterion("maxMoney not in", values, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyBetween(Double value1, Double value2) {
            addCriterion("maxMoney between", value1, value2, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andMaxmoneyNotBetween(Double value1, Double value2) {
            addCriterion("maxMoney not between", value1, value2, "maxmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyIsNull() {
            addCriterion("startMoney is null");
            return (Criteria) this;
        }

        public Criteria andStartmoneyIsNotNull() {
            addCriterion("startMoney is not null");
            return (Criteria) this;
        }

        public Criteria andStartmoneyEqualTo(Double value) {
            addCriterion("startMoney =", value, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyNotEqualTo(Double value) {
            addCriterion("startMoney <>", value, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyGreaterThan(Double value) {
            addCriterion("startMoney >", value, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("startMoney >=", value, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyLessThan(Double value) {
            addCriterion("startMoney <", value, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyLessThanOrEqualTo(Double value) {
            addCriterion("startMoney <=", value, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyIn(List<Double> values) {
            addCriterion("startMoney in", values, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyNotIn(List<Double> values) {
            addCriterion("startMoney not in", values, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyBetween(Double value1, Double value2) {
            addCriterion("startMoney between", value1, value2, "startmoney");
            return (Criteria) this;
        }

        public Criteria andStartmoneyNotBetween(Double value1, Double value2) {
            addCriterion("startMoney not between", value1, value2, "startmoney");
            return (Criteria) this;
        }

        public Criteria andGainmethodIsNull() {
            addCriterion("gainMethod is null");
            return (Criteria) this;
        }

        public Criteria andGainmethodIsNotNull() {
            addCriterion("gainMethod is not null");
            return (Criteria) this;
        }

        public Criteria andGainmethodEqualTo(Integer value) {
            addCriterion("gainMethod =", value, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodNotEqualTo(Integer value) {
            addCriterion("gainMethod <>", value, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodGreaterThan(Integer value) {
            addCriterion("gainMethod >", value, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("gainMethod >=", value, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodLessThan(Integer value) {
            addCriterion("gainMethod <", value, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodLessThanOrEqualTo(Integer value) {
            addCriterion("gainMethod <=", value, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodIn(List<Integer> values) {
            addCriterion("gainMethod in", values, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodNotIn(List<Integer> values) {
            addCriterion("gainMethod not in", values, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodBetween(Integer value1, Integer value2) {
            addCriterion("gainMethod between", value1, value2, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andGainmethodNotBetween(Integer value1, Integer value2) {
            addCriterion("gainMethod not between", value1, value2, "gainmethod");
            return (Criteria) this;
        }

        public Criteria andRealmoneyIsNull() {
            addCriterion("realMoney is null");
            return (Criteria) this;
        }

        public Criteria andRealmoneyIsNotNull() {
            addCriterion("realMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRealmoneyEqualTo(Double value) {
            addCriterion("realMoney =", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyNotEqualTo(Double value) {
            addCriterion("realMoney <>", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyGreaterThan(Double value) {
            addCriterion("realMoney >", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("realMoney >=", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyLessThan(Double value) {
            addCriterion("realMoney <", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyLessThanOrEqualTo(Double value) {
            addCriterion("realMoney <=", value, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyIn(List<Double> values) {
            addCriterion("realMoney in", values, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyNotIn(List<Double> values) {
            addCriterion("realMoney not in", values, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyBetween(Double value1, Double value2) {
            addCriterion("realMoney between", value1, value2, "realmoney");
            return (Criteria) this;
        }

        public Criteria andRealmoneyNotBetween(Double value1, Double value2) {
            addCriterion("realMoney not between", value1, value2, "realmoney");
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
package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCouponExample() {
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

        public Criteria andCouponnameIsNull() {
            addCriterion("couponName is null");
            return (Criteria) this;
        }

        public Criteria andCouponnameIsNotNull() {
            addCriterion("couponName is not null");
            return (Criteria) this;
        }

        public Criteria andCouponnameEqualTo(String value) {
            addCriterion("couponName =", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotEqualTo(String value) {
            addCriterion("couponName <>", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameGreaterThan(String value) {
            addCriterion("couponName >", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameGreaterThanOrEqualTo(String value) {
            addCriterion("couponName >=", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameLessThan(String value) {
            addCriterion("couponName <", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameLessThanOrEqualTo(String value) {
            addCriterion("couponName <=", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameLike(String value) {
            addCriterion("couponName like", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotLike(String value) {
            addCriterion("couponName not like", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameIn(List<String> values) {
            addCriterion("couponName in", values, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotIn(List<String> values) {
            addCriterion("couponName not in", values, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameBetween(String value1, String value2) {
            addCriterion("couponName between", value1, value2, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotBetween(String value1, String value2) {
            addCriterion("couponName not between", value1, value2, "couponname");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(String value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(String value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(String value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(String value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(String value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLike(String value) {
            addCriterion("discount like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotLike(String value) {
            addCriterion("discount not like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<String> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<String> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(String value1, String value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(String value1, String value2) {
            addCriterion("discount not between", value1, value2, "discount");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockIsNull() {
            addCriterion("surplusStock is null");
            return (Criteria) this;
        }

        public Criteria andSurplusstockIsNotNull() {
            addCriterion("surplusStock is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusstockEqualTo(Integer value) {
            addCriterion("surplusStock =", value, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockNotEqualTo(Integer value) {
            addCriterion("surplusStock <>", value, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockGreaterThan(Integer value) {
            addCriterion("surplusStock >", value, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockGreaterThanOrEqualTo(Integer value) {
            addCriterion("surplusStock >=", value, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockLessThan(Integer value) {
            addCriterion("surplusStock <", value, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockLessThanOrEqualTo(Integer value) {
            addCriterion("surplusStock <=", value, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockIn(List<Integer> values) {
            addCriterion("surplusStock in", values, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockNotIn(List<Integer> values) {
            addCriterion("surplusStock not in", values, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockBetween(Integer value1, Integer value2) {
            addCriterion("surplusStock between", value1, value2, "surplusstock");
            return (Criteria) this;
        }

        public Criteria andSurplusstockNotBetween(Integer value1, Integer value2) {
            addCriterion("surplusStock not between", value1, value2, "surplusstock");
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

        public Criteria andValiddayIsNull() {
            addCriterion("validDay is null");
            return (Criteria) this;
        }

        public Criteria andValiddayIsNotNull() {
            addCriterion("validDay is not null");
            return (Criteria) this;
        }

        public Criteria andValiddayEqualTo(Integer value) {
            addCriterion("validDay =", value, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayNotEqualTo(Integer value) {
            addCriterion("validDay <>", value, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayGreaterThan(Integer value) {
            addCriterion("validDay >", value, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayGreaterThanOrEqualTo(Integer value) {
            addCriterion("validDay >=", value, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayLessThan(Integer value) {
            addCriterion("validDay <", value, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayLessThanOrEqualTo(Integer value) {
            addCriterion("validDay <=", value, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayIn(List<Integer> values) {
            addCriterion("validDay in", values, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayNotIn(List<Integer> values) {
            addCriterion("validDay not in", values, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayBetween(Integer value1, Integer value2) {
            addCriterion("validDay between", value1, value2, "validday");
            return (Criteria) this;
        }

        public Criteria andValiddayNotBetween(Integer value1, Integer value2) {
            addCriterion("validDay not between", value1, value2, "validday");
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

        public Criteria andIsdelIsNull() {
            addCriterion("isdel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isdel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("isdel not between", value1, value2, "isdel");
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

        public Criteria andOpeartionadminidIsNull() {
            addCriterion("opeartionAdminId is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidIsNotNull() {
            addCriterion("opeartionAdminId is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidEqualTo(Integer value) {
            addCriterion("opeartionAdminId =", value, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidNotEqualTo(Integer value) {
            addCriterion("opeartionAdminId <>", value, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidGreaterThan(Integer value) {
            addCriterion("opeartionAdminId >", value, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("opeartionAdminId >=", value, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidLessThan(Integer value) {
            addCriterion("opeartionAdminId <", value, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidLessThanOrEqualTo(Integer value) {
            addCriterion("opeartionAdminId <=", value, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidIn(List<Integer> values) {
            addCriterion("opeartionAdminId in", values, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidNotIn(List<Integer> values) {
            addCriterion("opeartionAdminId not in", values, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidBetween(Integer value1, Integer value2) {
            addCriterion("opeartionAdminId between", value1, value2, "opeartionadminid");
            return (Criteria) this;
        }

        public Criteria andOpeartionadminidNotBetween(Integer value1, Integer value2) {
            addCriterion("opeartionAdminId not between", value1, value2, "opeartionadminid");
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
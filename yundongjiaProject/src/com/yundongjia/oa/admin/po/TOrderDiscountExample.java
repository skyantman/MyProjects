package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TOrderDiscountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderDiscountExample() {
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

        public Criteria andRedpackageIsNull() {
            addCriterion("redPackage is null");
            return (Criteria) this;
        }

        public Criteria andRedpackageIsNotNull() {
            addCriterion("redPackage is not null");
            return (Criteria) this;
        }

        public Criteria andRedpackageEqualTo(Double value) {
            addCriterion("redPackage =", value, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageNotEqualTo(Double value) {
            addCriterion("redPackage <>", value, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageGreaterThan(Double value) {
            addCriterion("redPackage >", value, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageGreaterThanOrEqualTo(Double value) {
            addCriterion("redPackage >=", value, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageLessThan(Double value) {
            addCriterion("redPackage <", value, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageLessThanOrEqualTo(Double value) {
            addCriterion("redPackage <=", value, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageIn(List<Double> values) {
            addCriterion("redPackage in", values, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageNotIn(List<Double> values) {
            addCriterion("redPackage not in", values, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageBetween(Double value1, Double value2) {
            addCriterion("redPackage between", value1, value2, "redpackage");
            return (Criteria) this;
        }

        public Criteria andRedpackageNotBetween(Double value1, Double value2) {
            addCriterion("redPackage not between", value1, value2, "redpackage");
            return (Criteria) this;
        }

        public Criteria andSelfcardIsNull() {
            addCriterion("selfCard is null");
            return (Criteria) this;
        }

        public Criteria andSelfcardIsNotNull() {
            addCriterion("selfCard is not null");
            return (Criteria) this;
        }

        public Criteria andSelfcardEqualTo(Double value) {
            addCriterion("selfCard =", value, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardNotEqualTo(Double value) {
            addCriterion("selfCard <>", value, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardGreaterThan(Double value) {
            addCriterion("selfCard >", value, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardGreaterThanOrEqualTo(Double value) {
            addCriterion("selfCard >=", value, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardLessThan(Double value) {
            addCriterion("selfCard <", value, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardLessThanOrEqualTo(Double value) {
            addCriterion("selfCard <=", value, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardIn(List<Double> values) {
            addCriterion("selfCard in", values, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardNotIn(List<Double> values) {
            addCriterion("selfCard not in", values, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardBetween(Double value1, Double value2) {
            addCriterion("selfCard between", value1, value2, "selfcard");
            return (Criteria) this;
        }

        public Criteria andSelfcardNotBetween(Double value1, Double value2) {
            addCriterion("selfCard not between", value1, value2, "selfcard");
            return (Criteria) this;
        }

        public Criteria andCouponIsNull() {
            addCriterion("coupon is null");
            return (Criteria) this;
        }

        public Criteria andCouponIsNotNull() {
            addCriterion("coupon is not null");
            return (Criteria) this;
        }

        public Criteria andCouponEqualTo(Double value) {
            addCriterion("coupon =", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponNotEqualTo(Double value) {
            addCriterion("coupon <>", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponGreaterThan(Double value) {
            addCriterion("coupon >", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponGreaterThanOrEqualTo(Double value) {
            addCriterion("coupon >=", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponLessThan(Double value) {
            addCriterion("coupon <", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponLessThanOrEqualTo(Double value) {
            addCriterion("coupon <=", value, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponIn(List<Double> values) {
            addCriterion("coupon in", values, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponNotIn(List<Double> values) {
            addCriterion("coupon not in", values, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponBetween(Double value1, Double value2) {
            addCriterion("coupon between", value1, value2, "coupon");
            return (Criteria) this;
        }

        public Criteria andCouponNotBetween(Double value1, Double value2) {
            addCriterion("coupon not between", value1, value2, "coupon");
            return (Criteria) this;
        }

        public Criteria andPayditchIsNull() {
            addCriterion("payDitch is null");
            return (Criteria) this;
        }

        public Criteria andPayditchIsNotNull() {
            addCriterion("payDitch is not null");
            return (Criteria) this;
        }

        public Criteria andPayditchEqualTo(Double value) {
            addCriterion("payDitch =", value, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchNotEqualTo(Double value) {
            addCriterion("payDitch <>", value, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchGreaterThan(Double value) {
            addCriterion("payDitch >", value, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchGreaterThanOrEqualTo(Double value) {
            addCriterion("payDitch >=", value, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchLessThan(Double value) {
            addCriterion("payDitch <", value, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchLessThanOrEqualTo(Double value) {
            addCriterion("payDitch <=", value, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchIn(List<Double> values) {
            addCriterion("payDitch in", values, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchNotIn(List<Double> values) {
            addCriterion("payDitch not in", values, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchBetween(Double value1, Double value2) {
            addCriterion("payDitch between", value1, value2, "payditch");
            return (Criteria) this;
        }

        public Criteria andPayditchNotBetween(Double value1, Double value2) {
            addCriterion("payDitch not between", value1, value2, "payditch");
            return (Criteria) this;
        }

        public Criteria andCardidIsNull() {
            addCriterion("cardId is null");
            return (Criteria) this;
        }

        public Criteria andCardidIsNotNull() {
            addCriterion("cardId is not null");
            return (Criteria) this;
        }

        public Criteria andCardidEqualTo(Integer value) {
            addCriterion("cardId =", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotEqualTo(Integer value) {
            addCriterion("cardId <>", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThan(Integer value) {
            addCriterion("cardId >", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cardId >=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThan(Integer value) {
            addCriterion("cardId <", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThanOrEqualTo(Integer value) {
            addCriterion("cardId <=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidIn(List<Integer> values) {
            addCriterion("cardId in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotIn(List<Integer> values) {
            addCriterion("cardId not in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidBetween(Integer value1, Integer value2) {
            addCriterion("cardId between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotBetween(Integer value1, Integer value2) {
            addCriterion("cardId not between", value1, value2, "cardid");
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

        public Criteria andOrderrealmoneyIsNull() {
            addCriterion("orderRealMoney is null");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyIsNotNull() {
            addCriterion("orderRealMoney is not null");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyEqualTo(Double value) {
            addCriterion("orderRealMoney =", value, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyNotEqualTo(Double value) {
            addCriterion("orderRealMoney <>", value, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyGreaterThan(Double value) {
            addCriterion("orderRealMoney >", value, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("orderRealMoney >=", value, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyLessThan(Double value) {
            addCriterion("orderRealMoney <", value, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyLessThanOrEqualTo(Double value) {
            addCriterion("orderRealMoney <=", value, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyIn(List<Double> values) {
            addCriterion("orderRealMoney in", values, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyNotIn(List<Double> values) {
            addCriterion("orderRealMoney not in", values, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyBetween(Double value1, Double value2) {
            addCriterion("orderRealMoney between", value1, value2, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andOrderrealmoneyNotBetween(Double value1, Double value2) {
            addCriterion("orderRealMoney not between", value1, value2, "orderrealmoney");
            return (Criteria) this;
        }

        public Criteria andRetreatdateIsNull() {
            addCriterion("retreatDate is null");
            return (Criteria) this;
        }

        public Criteria andRetreatdateIsNotNull() {
            addCriterion("retreatDate is not null");
            return (Criteria) this;
        }

        public Criteria andRetreatdateEqualTo(String value) {
            addCriterion("retreatDate =", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateNotEqualTo(String value) {
            addCriterion("retreatDate <>", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateGreaterThan(String value) {
            addCriterion("retreatDate >", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateGreaterThanOrEqualTo(String value) {
            addCriterion("retreatDate >=", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateLessThan(String value) {
            addCriterion("retreatDate <", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateLessThanOrEqualTo(String value) {
            addCriterion("retreatDate <=", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateLike(String value) {
            addCriterion("retreatDate like", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateNotLike(String value) {
            addCriterion("retreatDate not like", value, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateIn(List<String> values) {
            addCriterion("retreatDate in", values, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateNotIn(List<String> values) {
            addCriterion("retreatDate not in", values, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateBetween(String value1, String value2) {
            addCriterion("retreatDate between", value1, value2, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andRetreatdateNotBetween(String value1, String value2) {
            addCriterion("retreatDate not between", value1, value2, "retreatdate");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidIsNull() {
            addCriterion("enterpriseCardId is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidIsNotNull() {
            addCriterion("enterpriseCardId is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidEqualTo(Integer value) {
            addCriterion("enterpriseCardId =", value, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidNotEqualTo(Integer value) {
            addCriterion("enterpriseCardId <>", value, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidGreaterThan(Integer value) {
            addCriterion("enterpriseCardId >", value, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterpriseCardId >=", value, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidLessThan(Integer value) {
            addCriterion("enterpriseCardId <", value, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidLessThanOrEqualTo(Integer value) {
            addCriterion("enterpriseCardId <=", value, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidIn(List<Integer> values) {
            addCriterion("enterpriseCardId in", values, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidNotIn(List<Integer> values) {
            addCriterion("enterpriseCardId not in", values, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseCardId between", value1, value2, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardidNotBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseCardId not between", value1, value2, "enterprisecardid");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumIsNull() {
            addCriterion("enterpriseCardSubNum is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumIsNotNull() {
            addCriterion("enterpriseCardSubNum is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumEqualTo(Integer value) {
            addCriterion("enterpriseCardSubNum =", value, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumNotEqualTo(Integer value) {
            addCriterion("enterpriseCardSubNum <>", value, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumGreaterThan(Integer value) {
            addCriterion("enterpriseCardSubNum >", value, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterpriseCardSubNum >=", value, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumLessThan(Integer value) {
            addCriterion("enterpriseCardSubNum <", value, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumLessThanOrEqualTo(Integer value) {
            addCriterion("enterpriseCardSubNum <=", value, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumIn(List<Integer> values) {
            addCriterion("enterpriseCardSubNum in", values, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumNotIn(List<Integer> values) {
            addCriterion("enterpriseCardSubNum not in", values, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseCardSubNum between", value1, value2, "enterprisecardsubnum");
            return (Criteria) this;
        }

        public Criteria andEnterprisecardsubnumNotBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseCardSubNum not between", value1, value2, "enterprisecardsubnum");
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
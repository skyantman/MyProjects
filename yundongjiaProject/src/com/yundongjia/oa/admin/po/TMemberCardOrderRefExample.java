package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TMemberCardOrderRefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMemberCardOrderRefExample() {
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

        public Criteria andCardtypeidIsNull() {
            addCriterion("cardTypeId is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeidIsNotNull() {
            addCriterion("cardTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeidEqualTo(Integer value) {
            addCriterion("cardTypeId =", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidNotEqualTo(Integer value) {
            addCriterion("cardTypeId <>", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidGreaterThan(Integer value) {
            addCriterion("cardTypeId >", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cardTypeId >=", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidLessThan(Integer value) {
            addCriterion("cardTypeId <", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("cardTypeId <=", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidIn(List<Integer> values) {
            addCriterion("cardTypeId in", values, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidNotIn(List<Integer> values) {
            addCriterion("cardTypeId not in", values, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidBetween(Integer value1, Integer value2) {
            addCriterion("cardTypeId between", value1, value2, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("cardTypeId not between", value1, value2, "cardtypeid");
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

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Float value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Float value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Float value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Float value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Float value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Float> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Float> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Float value1, Float value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Float value1, Float value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(Double value) {
            addCriterion("totalMoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(Double value) {
            addCriterion("totalMoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(Double value) {
            addCriterion("totalMoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("totalMoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(Double value) {
            addCriterion("totalMoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(Double value) {
            addCriterion("totalMoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<Double> values) {
            addCriterion("totalMoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<Double> values) {
            addCriterion("totalMoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(Double value1, Double value2) {
            addCriterion("totalMoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(Double value1, Double value2) {
            addCriterion("totalMoney not between", value1, value2, "totalmoney");
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

        public Criteria andCashbackIsNull() {
            addCriterion("cashBack is null");
            return (Criteria) this;
        }

        public Criteria andCashbackIsNotNull() {
            addCriterion("cashBack is not null");
            return (Criteria) this;
        }

        public Criteria andCashbackEqualTo(Double value) {
            addCriterion("cashBack =", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackNotEqualTo(Double value) {
            addCriterion("cashBack <>", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackGreaterThan(Double value) {
            addCriterion("cashBack >", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackGreaterThanOrEqualTo(Double value) {
            addCriterion("cashBack >=", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackLessThan(Double value) {
            addCriterion("cashBack <", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackLessThanOrEqualTo(Double value) {
            addCriterion("cashBack <=", value, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackIn(List<Double> values) {
            addCriterion("cashBack in", values, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackNotIn(List<Double> values) {
            addCriterion("cashBack not in", values, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackBetween(Double value1, Double value2) {
            addCriterion("cashBack between", value1, value2, "cashback");
            return (Criteria) this;
        }

        public Criteria andCashbackNotBetween(Double value1, Double value2) {
            addCriterion("cashBack not between", value1, value2, "cashback");
            return (Criteria) this;
        }

        public Criteria andCardorderIsNull() {
            addCriterion("cardOrder is null");
            return (Criteria) this;
        }

        public Criteria andCardorderIsNotNull() {
            addCriterion("cardOrder is not null");
            return (Criteria) this;
        }

        public Criteria andCardorderEqualTo(String value) {
            addCriterion("cardOrder =", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderNotEqualTo(String value) {
            addCriterion("cardOrder <>", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderGreaterThan(String value) {
            addCriterion("cardOrder >", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderGreaterThanOrEqualTo(String value) {
            addCriterion("cardOrder >=", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderLessThan(String value) {
            addCriterion("cardOrder <", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderLessThanOrEqualTo(String value) {
            addCriterion("cardOrder <=", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderLike(String value) {
            addCriterion("cardOrder like", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderNotLike(String value) {
            addCriterion("cardOrder not like", value, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderIn(List<String> values) {
            addCriterion("cardOrder in", values, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderNotIn(List<String> values) {
            addCriterion("cardOrder not in", values, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderBetween(String value1, String value2) {
            addCriterion("cardOrder between", value1, value2, "cardorder");
            return (Criteria) this;
        }

        public Criteria andCardorderNotBetween(String value1, String value2) {
            addCriterion("cardOrder not between", value1, value2, "cardorder");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("payType is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("payType is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(String value) {
            addCriterion("payType =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(String value) {
            addCriterion("payType <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(String value) {
            addCriterion("payType >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(String value) {
            addCriterion("payType >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(String value) {
            addCriterion("payType <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(String value) {
            addCriterion("payType <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLike(String value) {
            addCriterion("payType like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotLike(String value) {
            addCriterion("payType not like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<String> values) {
            addCriterion("payType in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<String> values) {
            addCriterion("payType not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(String value1, String value2) {
            addCriterion("payType between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(String value1, String value2) {
            addCriterion("payType not between", value1, value2, "paytype");
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

        public Criteria andIsdelIsNull() {
            addCriterion("isDel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isDel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("isDel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("isDel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("isDel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("isDel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("isDel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("isDel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("isDel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("isDel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("isDel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNull() {
            addCriterion("expireDate is null");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNotNull() {
            addCriterion("expireDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredateEqualTo(String value) {
            addCriterion("expireDate =", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotEqualTo(String value) {
            addCriterion("expireDate <>", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThan(String value) {
            addCriterion("expireDate >", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThanOrEqualTo(String value) {
            addCriterion("expireDate >=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThan(String value) {
            addCriterion("expireDate <", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThanOrEqualTo(String value) {
            addCriterion("expireDate <=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLike(String value) {
            addCriterion("expireDate like", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotLike(String value) {
            addCriterion("expireDate not like", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateIn(List<String> values) {
            addCriterion("expireDate in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotIn(List<String> values) {
            addCriterion("expireDate not in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateBetween(String value1, String value2) {
            addCriterion("expireDate between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotBetween(String value1, String value2) {
            addCriterion("expireDate not between", value1, value2, "expiredate");
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

        public Criteria andEnterpriseidIsNull() {
            addCriterion("enterpriseId is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIsNotNull() {
            addCriterion("enterpriseId is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidEqualTo(Integer value) {
            addCriterion("enterpriseId =", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotEqualTo(Integer value) {
            addCriterion("enterpriseId <>", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidGreaterThan(Integer value) {
            addCriterion("enterpriseId >", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterpriseId >=", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidLessThan(Integer value) {
            addCriterion("enterpriseId <", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidLessThanOrEqualTo(Integer value) {
            addCriterion("enterpriseId <=", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIn(List<Integer> values) {
            addCriterion("enterpriseId in", values, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotIn(List<Integer> values) {
            addCriterion("enterpriseId not in", values, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseId between", value1, value2, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotBetween(Integer value1, Integer value2) {
            addCriterion("enterpriseId not between", value1, value2, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andSportscountIsNull() {
            addCriterion("sportsCount is null");
            return (Criteria) this;
        }

        public Criteria andSportscountIsNotNull() {
            addCriterion("sportsCount is not null");
            return (Criteria) this;
        }

        public Criteria andSportscountEqualTo(Integer value) {
            addCriterion("sportsCount =", value, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountNotEqualTo(Integer value) {
            addCriterion("sportsCount <>", value, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountGreaterThan(Integer value) {
            addCriterion("sportsCount >", value, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sportsCount >=", value, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountLessThan(Integer value) {
            addCriterion("sportsCount <", value, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountLessThanOrEqualTo(Integer value) {
            addCriterion("sportsCount <=", value, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountIn(List<Integer> values) {
            addCriterion("sportsCount in", values, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountNotIn(List<Integer> values) {
            addCriterion("sportsCount not in", values, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountBetween(Integer value1, Integer value2) {
            addCriterion("sportsCount between", value1, value2, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSportscountNotBetween(Integer value1, Integer value2) {
            addCriterion("sportsCount not between", value1, value2, "sportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountIsNull() {
            addCriterion("surplusSportsCount is null");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountIsNotNull() {
            addCriterion("surplusSportsCount is not null");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountEqualTo(Integer value) {
            addCriterion("surplusSportsCount =", value, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountNotEqualTo(Integer value) {
            addCriterion("surplusSportsCount <>", value, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountGreaterThan(Integer value) {
            addCriterion("surplusSportsCount >", value, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("surplusSportsCount >=", value, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountLessThan(Integer value) {
            addCriterion("surplusSportsCount <", value, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountLessThanOrEqualTo(Integer value) {
            addCriterion("surplusSportsCount <=", value, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountIn(List<Integer> values) {
            addCriterion("surplusSportsCount in", values, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountNotIn(List<Integer> values) {
            addCriterion("surplusSportsCount not in", values, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountBetween(Integer value1, Integer value2) {
            addCriterion("surplusSportsCount between", value1, value2, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSurplussportscountNotBetween(Integer value1, Integer value2) {
            addCriterion("surplusSportsCount not between", value1, value2, "surplussportscount");
            return (Criteria) this;
        }

        public Criteria andSelfIsNull() {
            addCriterion("self is null");
            return (Criteria) this;
        }

        public Criteria andSelfIsNotNull() {
            addCriterion("self is not null");
            return (Criteria) this;
        }

        public Criteria andSelfEqualTo(String value) {
            addCriterion("self =", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfNotEqualTo(String value) {
            addCriterion("self <>", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfGreaterThan(String value) {
            addCriterion("self >", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfGreaterThanOrEqualTo(String value) {
            addCriterion("self >=", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfLessThan(String value) {
            addCriterion("self <", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfLessThanOrEqualTo(String value) {
            addCriterion("self <=", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfLike(String value) {
            addCriterion("self like", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfNotLike(String value) {
            addCriterion("self not like", value, "self");
            return (Criteria) this;
        }

        public Criteria andSelfIn(List<String> values) {
            addCriterion("self in", values, "self");
            return (Criteria) this;
        }

        public Criteria andSelfNotIn(List<String> values) {
            addCriterion("self not in", values, "self");
            return (Criteria) this;
        }

        public Criteria andSelfBetween(String value1, String value2) {
            addCriterion("self between", value1, value2, "self");
            return (Criteria) this;
        }

        public Criteria andSelfNotBetween(String value1, String value2) {
            addCriterion("self not between", value1, value2, "self");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(String value) {
            addCriterion("orderNum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(String value) {
            addCriterion("orderNum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(String value) {
            addCriterion("orderNum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
            addCriterion("orderNum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(String value) {
            addCriterion("orderNum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(String value) {
            addCriterion("orderNum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLike(String value) {
            addCriterion("orderNum like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotLike(String value) {
            addCriterion("orderNum not like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<String> values) {
            addCriterion("orderNum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<String> values) {
            addCriterion("orderNum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(String value1, String value2) {
            addCriterion("orderNum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(String value1, String value2) {
            addCriterion("orderNum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andPaystatusIsNull() {
            addCriterion("payStatus is null");
            return (Criteria) this;
        }

        public Criteria andPaystatusIsNotNull() {
            addCriterion("payStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPaystatusEqualTo(String value) {
            addCriterion("payStatus =", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotEqualTo(String value) {
            addCriterion("payStatus <>", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThan(String value) {
            addCriterion("payStatus >", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThanOrEqualTo(String value) {
            addCriterion("payStatus >=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThan(String value) {
            addCriterion("payStatus <", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThanOrEqualTo(String value) {
            addCriterion("payStatus <=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLike(String value) {
            addCriterion("payStatus like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotLike(String value) {
            addCriterion("payStatus not like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusIn(List<String> values) {
            addCriterion("payStatus in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotIn(List<String> values) {
            addCriterion("payStatus not in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusBetween(String value1, String value2) {
            addCriterion("payStatus between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotBetween(String value1, String value2) {
            addCriterion("payStatus not between", value1, value2, "paystatus");
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

        public Criteria andMessagestatusIsNull() {
            addCriterion("messageStatus is null");
            return (Criteria) this;
        }

        public Criteria andMessagestatusIsNotNull() {
            addCriterion("messageStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMessagestatusEqualTo(String value) {
            addCriterion("messageStatus =", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotEqualTo(String value) {
            addCriterion("messageStatus <>", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusGreaterThan(String value) {
            addCriterion("messageStatus >", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusGreaterThanOrEqualTo(String value) {
            addCriterion("messageStatus >=", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLessThan(String value) {
            addCriterion("messageStatus <", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLessThanOrEqualTo(String value) {
            addCriterion("messageStatus <=", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLike(String value) {
            addCriterion("messageStatus like", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotLike(String value) {
            addCriterion("messageStatus not like", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusIn(List<String> values) {
            addCriterion("messageStatus in", values, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotIn(List<String> values) {
            addCriterion("messageStatus not in", values, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusBetween(String value1, String value2) {
            addCriterion("messageStatus between", value1, value2, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotBetween(String value1, String value2) {
            addCriterion("messageStatus not between", value1, value2, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumIsNull() {
            addCriterion("mobilePhoneNum is null");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumIsNotNull() {
            addCriterion("mobilePhoneNum is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumEqualTo(String value) {
            addCriterion("mobilePhoneNum =", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumNotEqualTo(String value) {
            addCriterion("mobilePhoneNum <>", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumGreaterThan(String value) {
            addCriterion("mobilePhoneNum >", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumGreaterThanOrEqualTo(String value) {
            addCriterion("mobilePhoneNum >=", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumLessThan(String value) {
            addCriterion("mobilePhoneNum <", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumLessThanOrEqualTo(String value) {
            addCriterion("mobilePhoneNum <=", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumLike(String value) {
            addCriterion("mobilePhoneNum like", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumNotLike(String value) {
            addCriterion("mobilePhoneNum not like", value, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumIn(List<String> values) {
            addCriterion("mobilePhoneNum in", values, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumNotIn(List<String> values) {
            addCriterion("mobilePhoneNum not in", values, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumBetween(String value1, String value2) {
            addCriterion("mobilePhoneNum between", value1, value2, "mobilephonenum");
            return (Criteria) this;
        }

        public Criteria andMobilephonenumNotBetween(String value1, String value2) {
            addCriterion("mobilePhoneNum not between", value1, value2, "mobilephonenum");
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
package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TCardTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCardTypeExample() {
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

        public Criteria andValiddateIsNull() {
            addCriterion("validDate is null");
            return (Criteria) this;
        }

        public Criteria andValiddateIsNotNull() {
            addCriterion("validDate is not null");
            return (Criteria) this;
        }

        public Criteria andValiddateEqualTo(Integer value) {
            addCriterion("validDate =", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateNotEqualTo(Integer value) {
            addCriterion("validDate <>", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateGreaterThan(Integer value) {
            addCriterion("validDate >", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateGreaterThanOrEqualTo(Integer value) {
            addCriterion("validDate >=", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateLessThan(Integer value) {
            addCriterion("validDate <", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateLessThanOrEqualTo(Integer value) {
            addCriterion("validDate <=", value, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateIn(List<Integer> values) {
            addCriterion("validDate in", values, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateNotIn(List<Integer> values) {
            addCriterion("validDate not in", values, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateBetween(Integer value1, Integer value2) {
            addCriterion("validDate between", value1, value2, "validdate");
            return (Criteria) this;
        }

        public Criteria andValiddateNotBetween(Integer value1, Integer value2) {
            addCriterion("validDate not between", value1, value2, "validdate");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNull() {
            addCriterion("cardType is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNotNull() {
            addCriterion("cardType is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeEqualTo(String value) {
            addCriterion("cardType =", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotEqualTo(String value) {
            addCriterion("cardType <>", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThan(String value) {
            addCriterion("cardType >", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("cardType >=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThan(String value) {
            addCriterion("cardType <", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThanOrEqualTo(String value) {
            addCriterion("cardType <=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLike(String value) {
            addCriterion("cardType like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotLike(String value) {
            addCriterion("cardType not like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeIn(List<String> values) {
            addCriterion("cardType in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotIn(List<String> values) {
            addCriterion("cardType not in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeBetween(String value1, String value2) {
            addCriterion("cardType between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotBetween(String value1, String value2) {
            addCriterion("cardType not between", value1, value2, "cardtype");
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

        public Criteria andCardtypenameIsNull() {
            addCriterion("cardTypeName is null");
            return (Criteria) this;
        }

        public Criteria andCardtypenameIsNotNull() {
            addCriterion("cardTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypenameEqualTo(String value) {
            addCriterion("cardTypeName =", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameNotEqualTo(String value) {
            addCriterion("cardTypeName <>", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameGreaterThan(String value) {
            addCriterion("cardTypeName >", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameGreaterThanOrEqualTo(String value) {
            addCriterion("cardTypeName >=", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameLessThan(String value) {
            addCriterion("cardTypeName <", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameLessThanOrEqualTo(String value) {
            addCriterion("cardTypeName <=", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameLike(String value) {
            addCriterion("cardTypeName like", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameNotLike(String value) {
            addCriterion("cardTypeName not like", value, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameIn(List<String> values) {
            addCriterion("cardTypeName in", values, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameNotIn(List<String> values) {
            addCriterion("cardTypeName not in", values, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameBetween(String value1, String value2) {
            addCriterion("cardTypeName between", value1, value2, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCardtypenameNotBetween(String value1, String value2) {
            addCriterion("cardTypeName not between", value1, value2, "cardtypename");
            return (Criteria) this;
        }

        public Criteria andCarddiscountIsNull() {
            addCriterion("cardDiscount is null");
            return (Criteria) this;
        }

        public Criteria andCarddiscountIsNotNull() {
            addCriterion("cardDiscount is not null");
            return (Criteria) this;
        }

        public Criteria andCarddiscountEqualTo(Float value) {
            addCriterion("cardDiscount =", value, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountNotEqualTo(Float value) {
            addCriterion("cardDiscount <>", value, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountGreaterThan(Float value) {
            addCriterion("cardDiscount >", value, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("cardDiscount >=", value, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountLessThan(Float value) {
            addCriterion("cardDiscount <", value, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountLessThanOrEqualTo(Float value) {
            addCriterion("cardDiscount <=", value, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountIn(List<Float> values) {
            addCriterion("cardDiscount in", values, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountNotIn(List<Float> values) {
            addCriterion("cardDiscount not in", values, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountBetween(Float value1, Float value2) {
            addCriterion("cardDiscount between", value1, value2, "carddiscount");
            return (Criteria) this;
        }

        public Criteria andCarddiscountNotBetween(Float value1, Float value2) {
            addCriterion("cardDiscount not between", value1, value2, "carddiscount");
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

        public Criteria andIscashbackIsNull() {
            addCriterion("isCashBack is null");
            return (Criteria) this;
        }

        public Criteria andIscashbackIsNotNull() {
            addCriterion("isCashBack is not null");
            return (Criteria) this;
        }

        public Criteria andIscashbackEqualTo(Integer value) {
            addCriterion("isCashBack =", value, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackNotEqualTo(Integer value) {
            addCriterion("isCashBack <>", value, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackGreaterThan(Integer value) {
            addCriterion("isCashBack >", value, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackGreaterThanOrEqualTo(Integer value) {
            addCriterion("isCashBack >=", value, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackLessThan(Integer value) {
            addCriterion("isCashBack <", value, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackLessThanOrEqualTo(Integer value) {
            addCriterion("isCashBack <=", value, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackIn(List<Integer> values) {
            addCriterion("isCashBack in", values, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackNotIn(List<Integer> values) {
            addCriterion("isCashBack not in", values, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackBetween(Integer value1, Integer value2) {
            addCriterion("isCashBack between", value1, value2, "iscashback");
            return (Criteria) this;
        }

        public Criteria andIscashbackNotBetween(Integer value1, Integer value2) {
            addCriterion("isCashBack not between", value1, value2, "iscashback");
            return (Criteria) this;
        }

        public Criteria andBackmoneyIsNull() {
            addCriterion("backMoney is null");
            return (Criteria) this;
        }

        public Criteria andBackmoneyIsNotNull() {
            addCriterion("backMoney is not null");
            return (Criteria) this;
        }

        public Criteria andBackmoneyEqualTo(Double value) {
            addCriterion("backMoney =", value, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyNotEqualTo(Double value) {
            addCriterion("backMoney <>", value, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyGreaterThan(Double value) {
            addCriterion("backMoney >", value, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("backMoney >=", value, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyLessThan(Double value) {
            addCriterion("backMoney <", value, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyLessThanOrEqualTo(Double value) {
            addCriterion("backMoney <=", value, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyIn(List<Double> values) {
            addCriterion("backMoney in", values, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyNotIn(List<Double> values) {
            addCriterion("backMoney not in", values, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyBetween(Double value1, Double value2) {
            addCriterion("backMoney between", value1, value2, "backmoney");
            return (Criteria) this;
        }

        public Criteria andBackmoneyNotBetween(Double value1, Double value2) {
            addCriterion("backMoney not between", value1, value2, "backmoney");
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

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
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

        public Criteria andIsdelEqualTo(String value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(String value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(String value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(String value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(String value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(String value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLike(String value) {
            addCriterion("isdel like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotLike(String value) {
            addCriterion("isdel not like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<String> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<String> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(String value1, String value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(String value1, String value2) {
            addCriterion("isdel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsstopIsNull() {
            addCriterion("isstop is null");
            return (Criteria) this;
        }

        public Criteria andIsstopIsNotNull() {
            addCriterion("isstop is not null");
            return (Criteria) this;
        }

        public Criteria andIsstopEqualTo(String value) {
            addCriterion("isstop =", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopNotEqualTo(String value) {
            addCriterion("isstop <>", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopGreaterThan(String value) {
            addCriterion("isstop >", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopGreaterThanOrEqualTo(String value) {
            addCriterion("isstop >=", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopLessThan(String value) {
            addCriterion("isstop <", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopLessThanOrEqualTo(String value) {
            addCriterion("isstop <=", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopLike(String value) {
            addCriterion("isstop like", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopNotLike(String value) {
            addCriterion("isstop not like", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopIn(List<String> values) {
            addCriterion("isstop in", values, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopNotIn(List<String> values) {
            addCriterion("isstop not in", values, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopBetween(String value1, String value2) {
            addCriterion("isstop between", value1, value2, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopNotBetween(String value1, String value2) {
            addCriterion("isstop not between", value1, value2, "isstop");
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

        public Criteria andRegionsidEqualTo(String value) {
            addCriterion("regionsId =", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidNotEqualTo(String value) {
            addCriterion("regionsId <>", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidGreaterThan(String value) {
            addCriterion("regionsId >", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidGreaterThanOrEqualTo(String value) {
            addCriterion("regionsId >=", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidLessThan(String value) {
            addCriterion("regionsId <", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidLessThanOrEqualTo(String value) {
            addCriterion("regionsId <=", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidLike(String value) {
            addCriterion("regionsId like", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidNotLike(String value) {
            addCriterion("regionsId not like", value, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidIn(List<String> values) {
            addCriterion("regionsId in", values, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidNotIn(List<String> values) {
            addCriterion("regionsId not in", values, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidBetween(String value1, String value2) {
            addCriterion("regionsId between", value1, value2, "regionsid");
            return (Criteria) this;
        }

        public Criteria andRegionsidNotBetween(String value1, String value2) {
            addCriterion("regionsId not between", value1, value2, "regionsid");
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
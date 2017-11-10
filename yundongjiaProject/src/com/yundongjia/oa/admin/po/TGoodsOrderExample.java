package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TGoodsOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TGoodsOrderExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gId is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gId is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gId =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gId <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gId >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gId >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gId <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gId <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gId in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gId not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gId between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gId not between", value1, value2, "gid");
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

        public Criteria andMembernameIsNull() {
            addCriterion("memberName is null");
            return (Criteria) this;
        }

        public Criteria andMembernameIsNotNull() {
            addCriterion("memberName is not null");
            return (Criteria) this;
        }

        public Criteria andMembernameEqualTo(String value) {
            addCriterion("memberName =", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotEqualTo(String value) {
            addCriterion("memberName <>", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThan(String value) {
            addCriterion("memberName >", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThanOrEqualTo(String value) {
            addCriterion("memberName >=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThan(String value) {
            addCriterion("memberName <", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThanOrEqualTo(String value) {
            addCriterion("memberName <=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLike(String value) {
            addCriterion("memberName like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotLike(String value) {
            addCriterion("memberName not like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameIn(List<String> values) {
            addCriterion("memberName in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotIn(List<String> values) {
            addCriterion("memberName not in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameBetween(String value1, String value2) {
            addCriterion("memberName between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotBetween(String value1, String value2) {
            addCriterion("memberName not between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andShippernameIsNull() {
            addCriterion("shipperName is null");
            return (Criteria) this;
        }

        public Criteria andShippernameIsNotNull() {
            addCriterion("shipperName is not null");
            return (Criteria) this;
        }

        public Criteria andShippernameEqualTo(String value) {
            addCriterion("shipperName =", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotEqualTo(String value) {
            addCriterion("shipperName <>", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameGreaterThan(String value) {
            addCriterion("shipperName >", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameGreaterThanOrEqualTo(String value) {
            addCriterion("shipperName >=", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameLessThan(String value) {
            addCriterion("shipperName <", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameLessThanOrEqualTo(String value) {
            addCriterion("shipperName <=", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameLike(String value) {
            addCriterion("shipperName like", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotLike(String value) {
            addCriterion("shipperName not like", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameIn(List<String> values) {
            addCriterion("shipperName in", values, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotIn(List<String> values) {
            addCriterion("shipperName not in", values, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameBetween(String value1, String value2) {
            addCriterion("shipperName between", value1, value2, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotBetween(String value1, String value2) {
            addCriterion("shipperName not between", value1, value2, "shippername");
            return (Criteria) this;
        }

        public Criteria andShipperphoneIsNull() {
            addCriterion("shipperPhone is null");
            return (Criteria) this;
        }

        public Criteria andShipperphoneIsNotNull() {
            addCriterion("shipperPhone is not null");
            return (Criteria) this;
        }

        public Criteria andShipperphoneEqualTo(String value) {
            addCriterion("shipperPhone =", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneNotEqualTo(String value) {
            addCriterion("shipperPhone <>", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneGreaterThan(String value) {
            addCriterion("shipperPhone >", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneGreaterThanOrEqualTo(String value) {
            addCriterion("shipperPhone >=", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneLessThan(String value) {
            addCriterion("shipperPhone <", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneLessThanOrEqualTo(String value) {
            addCriterion("shipperPhone <=", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneLike(String value) {
            addCriterion("shipperPhone like", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneNotLike(String value) {
            addCriterion("shipperPhone not like", value, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneIn(List<String> values) {
            addCriterion("shipperPhone in", values, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneNotIn(List<String> values) {
            addCriterion("shipperPhone not in", values, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneBetween(String value1, String value2) {
            addCriterion("shipperPhone between", value1, value2, "shipperphone");
            return (Criteria) this;
        }

        public Criteria andShipperphoneNotBetween(String value1, String value2) {
            addCriterion("shipperPhone not between", value1, value2, "shipperphone");
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

        public Criteria andMessagestatusIsNull() {
            addCriterion("messageStatus is null");
            return (Criteria) this;
        }

        public Criteria andMessagestatusIsNotNull() {
            addCriterion("messageStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMessagestatusEqualTo(Integer value) {
            addCriterion("messageStatus =", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotEqualTo(Integer value) {
            addCriterion("messageStatus <>", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusGreaterThan(Integer value) {
            addCriterion("messageStatus >", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageStatus >=", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLessThan(Integer value) {
            addCriterion("messageStatus <", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusLessThanOrEqualTo(Integer value) {
            addCriterion("messageStatus <=", value, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusIn(List<Integer> values) {
            addCriterion("messageStatus in", values, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotIn(List<Integer> values) {
            addCriterion("messageStatus not in", values, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusBetween(Integer value1, Integer value2) {
            addCriterion("messageStatus between", value1, value2, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andMessagestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("messageStatus not between", value1, value2, "messagestatus");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andBuynumIsNull() {
            addCriterion("buyNum is null");
            return (Criteria) this;
        }

        public Criteria andBuynumIsNotNull() {
            addCriterion("buyNum is not null");
            return (Criteria) this;
        }

        public Criteria andBuynumEqualTo(Integer value) {
            addCriterion("buyNum =", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumNotEqualTo(Integer value) {
            addCriterion("buyNum <>", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumGreaterThan(Integer value) {
            addCriterion("buyNum >", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyNum >=", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumLessThan(Integer value) {
            addCriterion("buyNum <", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumLessThanOrEqualTo(Integer value) {
            addCriterion("buyNum <=", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumIn(List<Integer> values) {
            addCriterion("buyNum in", values, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumNotIn(List<Integer> values) {
            addCriterion("buyNum not in", values, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumBetween(Integer value1, Integer value2) {
            addCriterion("buyNum between", value1, value2, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumNotBetween(Integer value1, Integer value2) {
            addCriterion("buyNum not between", value1, value2, "buynum");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andExpresstypeIsNull() {
            addCriterion("expressType is null");
            return (Criteria) this;
        }

        public Criteria andExpresstypeIsNotNull() {
            addCriterion("expressType is not null");
            return (Criteria) this;
        }

        public Criteria andExpresstypeEqualTo(String value) {
            addCriterion("expressType =", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeNotEqualTo(String value) {
            addCriterion("expressType <>", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeGreaterThan(String value) {
            addCriterion("expressType >", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeGreaterThanOrEqualTo(String value) {
            addCriterion("expressType >=", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeLessThan(String value) {
            addCriterion("expressType <", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeLessThanOrEqualTo(String value) {
            addCriterion("expressType <=", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeLike(String value) {
            addCriterion("expressType like", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeNotLike(String value) {
            addCriterion("expressType not like", value, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeIn(List<String> values) {
            addCriterion("expressType in", values, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeNotIn(List<String> values) {
            addCriterion("expressType not in", values, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeBetween(String value1, String value2) {
            addCriterion("expressType between", value1, value2, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpresstypeNotBetween(String value1, String value2) {
            addCriterion("expressType not between", value1, value2, "expresstype");
            return (Criteria) this;
        }

        public Criteria andExpressnumIsNull() {
            addCriterion("expressNum is null");
            return (Criteria) this;
        }

        public Criteria andExpressnumIsNotNull() {
            addCriterion("expressNum is not null");
            return (Criteria) this;
        }

        public Criteria andExpressnumEqualTo(String value) {
            addCriterion("expressNum =", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotEqualTo(String value) {
            addCriterion("expressNum <>", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumGreaterThan(String value) {
            addCriterion("expressNum >", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumGreaterThanOrEqualTo(String value) {
            addCriterion("expressNum >=", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumLessThan(String value) {
            addCriterion("expressNum <", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumLessThanOrEqualTo(String value) {
            addCriterion("expressNum <=", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumLike(String value) {
            addCriterion("expressNum like", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotLike(String value) {
            addCriterion("expressNum not like", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumIn(List<String> values) {
            addCriterion("expressNum in", values, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotIn(List<String> values) {
            addCriterion("expressNum not in", values, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumBetween(String value1, String value2) {
            addCriterion("expressNum between", value1, value2, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotBetween(String value1, String value2) {
            addCriterion("expressNum not between", value1, value2, "expressnum");
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

        public Criteria andPaystatusEqualTo(Integer value) {
            addCriterion("payStatus =", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotEqualTo(Integer value) {
            addCriterion("payStatus <>", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThan(Integer value) {
            addCriterion("payStatus >", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("payStatus >=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThan(Integer value) {
            addCriterion("payStatus <", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThanOrEqualTo(Integer value) {
            addCriterion("payStatus <=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusIn(List<Integer> values) {
            addCriterion("payStatus in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotIn(List<Integer> values) {
            addCriterion("payStatus not in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusBetween(Integer value1, Integer value2) {
            addCriterion("payStatus between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotBetween(Integer value1, Integer value2) {
            addCriterion("payStatus not between", value1, value2, "paystatus");
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

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Double value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Double value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Double value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Double value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Double value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Double value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Double> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Double> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Double value1, Double value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Double value1, Double value2) {
            addCriterion("freight not between", value1, value2, "freight");
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

        public Criteria andOpeartionidIsNull() {
            addCriterion("opeartionId is null");
            return (Criteria) this;
        }

        public Criteria andOpeartionidIsNotNull() {
            addCriterion("opeartionId is not null");
            return (Criteria) this;
        }

        public Criteria andOpeartionidEqualTo(Integer value) {
            addCriterion("opeartionId =", value, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidNotEqualTo(Integer value) {
            addCriterion("opeartionId <>", value, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidGreaterThan(Integer value) {
            addCriterion("opeartionId >", value, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("opeartionId >=", value, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidLessThan(Integer value) {
            addCriterion("opeartionId <", value, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidLessThanOrEqualTo(Integer value) {
            addCriterion("opeartionId <=", value, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidIn(List<Integer> values) {
            addCriterion("opeartionId in", values, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidNotIn(List<Integer> values) {
            addCriterion("opeartionId not in", values, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidBetween(Integer value1, Integer value2) {
            addCriterion("opeartionId between", value1, value2, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andOpeartionidNotBetween(Integer value1, Integer value2) {
            addCriterion("opeartionId not between", value1, value2, "opeartionid");
            return (Criteria) this;
        }

        public Criteria andScoreidIsNull() {
            addCriterion("scoreId is null");
            return (Criteria) this;
        }

        public Criteria andScoreidIsNotNull() {
            addCriterion("scoreId is not null");
            return (Criteria) this;
        }

        public Criteria andScoreidEqualTo(Integer value) {
            addCriterion("scoreId =", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotEqualTo(Integer value) {
            addCriterion("scoreId <>", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidGreaterThan(Integer value) {
            addCriterion("scoreId >", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoreId >=", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidLessThan(Integer value) {
            addCriterion("scoreId <", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidLessThanOrEqualTo(Integer value) {
            addCriterion("scoreId <=", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidIn(List<Integer> values) {
            addCriterion("scoreId in", values, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotIn(List<Integer> values) {
            addCriterion("scoreId not in", values, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidBetween(Integer value1, Integer value2) {
            addCriterion("scoreId between", value1, value2, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotBetween(Integer value1, Integer value2) {
            addCriterion("scoreId not between", value1, value2, "scoreid");
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
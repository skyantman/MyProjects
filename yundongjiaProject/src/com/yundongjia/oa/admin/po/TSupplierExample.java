package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TSupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSupplierExample() {
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

        public Criteria andSupplierloginidIsNull() {
            addCriterion("supplierLoginId is null");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidIsNotNull() {
            addCriterion("supplierLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidEqualTo(Integer value) {
            addCriterion("supplierLoginId =", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidNotEqualTo(Integer value) {
            addCriterion("supplierLoginId <>", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidGreaterThan(Integer value) {
            addCriterion("supplierLoginId >", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplierLoginId >=", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidLessThan(Integer value) {
            addCriterion("supplierLoginId <", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidLessThanOrEqualTo(Integer value) {
            addCriterion("supplierLoginId <=", value, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidIn(List<Integer> values) {
            addCriterion("supplierLoginId in", values, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidNotIn(List<Integer> values) {
            addCriterion("supplierLoginId not in", values, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidBetween(Integer value1, Integer value2) {
            addCriterion("supplierLoginId between", value1, value2, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSupplierloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("supplierLoginId not between", value1, value2, "supplierloginid");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIsNull() {
            addCriterion("supplierName is null");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIsNotNull() {
            addCriterion("supplierName is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliernameEqualTo(String value) {
            addCriterion("supplierName =", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotEqualTo(String value) {
            addCriterion("supplierName <>", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameGreaterThan(String value) {
            addCriterion("supplierName >", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameGreaterThanOrEqualTo(String value) {
            addCriterion("supplierName >=", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLessThan(String value) {
            addCriterion("supplierName <", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLessThanOrEqualTo(String value) {
            addCriterion("supplierName <=", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLike(String value) {
            addCriterion("supplierName like", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotLike(String value) {
            addCriterion("supplierName not like", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIn(List<String> values) {
            addCriterion("supplierName in", values, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotIn(List<String> values) {
            addCriterion("supplierName not in", values, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameBetween(String value1, String value2) {
            addCriterion("supplierName between", value1, value2, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotBetween(String value1, String value2) {
            addCriterion("supplierName not between", value1, value2, "suppliername");
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

        public Criteria andLinkmannameIsNull() {
            addCriterion("linkmanName is null");
            return (Criteria) this;
        }

        public Criteria andLinkmannameIsNotNull() {
            addCriterion("linkmanName is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmannameEqualTo(String value) {
            addCriterion("linkmanName =", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameNotEqualTo(String value) {
            addCriterion("linkmanName <>", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameGreaterThan(String value) {
            addCriterion("linkmanName >", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameGreaterThanOrEqualTo(String value) {
            addCriterion("linkmanName >=", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameLessThan(String value) {
            addCriterion("linkmanName <", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameLessThanOrEqualTo(String value) {
            addCriterion("linkmanName <=", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameLike(String value) {
            addCriterion("linkmanName like", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameNotLike(String value) {
            addCriterion("linkmanName not like", value, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameIn(List<String> values) {
            addCriterion("linkmanName in", values, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameNotIn(List<String> values) {
            addCriterion("linkmanName not in", values, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameBetween(String value1, String value2) {
            addCriterion("linkmanName between", value1, value2, "linkmanname");
            return (Criteria) this;
        }

        public Criteria andLinkmannameNotBetween(String value1, String value2) {
            addCriterion("linkmanName not between", value1, value2, "linkmanname");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andClearingtypeIsNull() {
            addCriterion("clearingType is null");
            return (Criteria) this;
        }

        public Criteria andClearingtypeIsNotNull() {
            addCriterion("clearingType is not null");
            return (Criteria) this;
        }

        public Criteria andClearingtypeEqualTo(Integer value) {
            addCriterion("clearingType =", value, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeNotEqualTo(Integer value) {
            addCriterion("clearingType <>", value, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeGreaterThan(Integer value) {
            addCriterion("clearingType >", value, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("clearingType >=", value, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeLessThan(Integer value) {
            addCriterion("clearingType <", value, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeLessThanOrEqualTo(Integer value) {
            addCriterion("clearingType <=", value, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeIn(List<Integer> values) {
            addCriterion("clearingType in", values, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeNotIn(List<Integer> values) {
            addCriterion("clearingType not in", values, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeBetween(Integer value1, Integer value2) {
            addCriterion("clearingType between", value1, value2, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andClearingtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("clearingType not between", value1, value2, "clearingtype");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingIsNull() {
            addCriterion("periodClearing is null");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingIsNotNull() {
            addCriterion("periodClearing is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingEqualTo(Integer value) {
            addCriterion("periodClearing =", value, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingNotEqualTo(Integer value) {
            addCriterion("periodClearing <>", value, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingGreaterThan(Integer value) {
            addCriterion("periodClearing >", value, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingGreaterThanOrEqualTo(Integer value) {
            addCriterion("periodClearing >=", value, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingLessThan(Integer value) {
            addCriterion("periodClearing <", value, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingLessThanOrEqualTo(Integer value) {
            addCriterion("periodClearing <=", value, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingIn(List<Integer> values) {
            addCriterion("periodClearing in", values, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingNotIn(List<Integer> values) {
            addCriterion("periodClearing not in", values, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingBetween(Integer value1, Integer value2) {
            addCriterion("periodClearing between", value1, value2, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andPeriodclearingNotBetween(Integer value1, Integer value2) {
            addCriterion("periodClearing not between", value1, value2, "periodclearing");
            return (Criteria) this;
        }

        public Criteria andStratusIsNull() {
            addCriterion("stratus is null");
            return (Criteria) this;
        }

        public Criteria andStratusIsNotNull() {
            addCriterion("stratus is not null");
            return (Criteria) this;
        }

        public Criteria andStratusEqualTo(Integer value) {
            addCriterion("stratus =", value, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusNotEqualTo(Integer value) {
            addCriterion("stratus <>", value, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusGreaterThan(Integer value) {
            addCriterion("stratus >", value, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusGreaterThanOrEqualTo(Integer value) {
            addCriterion("stratus >=", value, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusLessThan(Integer value) {
            addCriterion("stratus <", value, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusLessThanOrEqualTo(Integer value) {
            addCriterion("stratus <=", value, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusIn(List<Integer> values) {
            addCriterion("stratus in", values, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusNotIn(List<Integer> values) {
            addCriterion("stratus not in", values, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusBetween(Integer value1, Integer value2) {
            addCriterion("stratus between", value1, value2, "stratus");
            return (Criteria) this;
        }

        public Criteria andStratusNotBetween(Integer value1, Integer value2) {
            addCriterion("stratus not between", value1, value2, "stratus");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidIsNull() {
            addCriterion("linkStudioId is null");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidIsNotNull() {
            addCriterion("linkStudioId is not null");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidEqualTo(String value) {
            addCriterion("linkStudioId =", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidNotEqualTo(String value) {
            addCriterion("linkStudioId <>", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidGreaterThan(String value) {
            addCriterion("linkStudioId >", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidGreaterThanOrEqualTo(String value) {
            addCriterion("linkStudioId >=", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidLessThan(String value) {
            addCriterion("linkStudioId <", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidLessThanOrEqualTo(String value) {
            addCriterion("linkStudioId <=", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidLike(String value) {
            addCriterion("linkStudioId like", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidNotLike(String value) {
            addCriterion("linkStudioId not like", value, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidIn(List<String> values) {
            addCriterion("linkStudioId in", values, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidNotIn(List<String> values) {
            addCriterion("linkStudioId not in", values, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidBetween(String value1, String value2) {
            addCriterion("linkStudioId between", value1, value2, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLinkstudioidNotBetween(String value1, String value2) {
            addCriterion("linkStudioId not between", value1, value2, "linkstudioid");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceIsNull() {
            addCriterion("likeStudioCostPrice is null");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceIsNotNull() {
            addCriterion("likeStudioCostPrice is not null");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceEqualTo(String value) {
            addCriterion("likeStudioCostPrice =", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceNotEqualTo(String value) {
            addCriterion("likeStudioCostPrice <>", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceGreaterThan(String value) {
            addCriterion("likeStudioCostPrice >", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceGreaterThanOrEqualTo(String value) {
            addCriterion("likeStudioCostPrice >=", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceLessThan(String value) {
            addCriterion("likeStudioCostPrice <", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceLessThanOrEqualTo(String value) {
            addCriterion("likeStudioCostPrice <=", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceLike(String value) {
            addCriterion("likeStudioCostPrice like", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceNotLike(String value) {
            addCriterion("likeStudioCostPrice not like", value, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceIn(List<String> values) {
            addCriterion("likeStudioCostPrice in", values, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceNotIn(List<String> values) {
            addCriterion("likeStudioCostPrice not in", values, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceBetween(String value1, String value2) {
            addCriterion("likeStudioCostPrice between", value1, value2, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLikestudiocostpriceNotBetween(String value1, String value2) {
            addCriterion("likeStudioCostPrice not between", value1, value2, "likestudiocostprice");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidIsNull() {
            addCriterion("linkCoachId is null");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidIsNotNull() {
            addCriterion("linkCoachId is not null");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidEqualTo(String value) {
            addCriterion("linkCoachId =", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidNotEqualTo(String value) {
            addCriterion("linkCoachId <>", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidGreaterThan(String value) {
            addCriterion("linkCoachId >", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidGreaterThanOrEqualTo(String value) {
            addCriterion("linkCoachId >=", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidLessThan(String value) {
            addCriterion("linkCoachId <", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidLessThanOrEqualTo(String value) {
            addCriterion("linkCoachId <=", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidLike(String value) {
            addCriterion("linkCoachId like", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidNotLike(String value) {
            addCriterion("linkCoachId not like", value, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidIn(List<String> values) {
            addCriterion("linkCoachId in", values, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidNotIn(List<String> values) {
            addCriterion("linkCoachId not in", values, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidBetween(String value1, String value2) {
            addCriterion("linkCoachId between", value1, value2, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLinkcoachidNotBetween(String value1, String value2) {
            addCriterion("linkCoachId not between", value1, value2, "linkcoachid");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceIsNull() {
            addCriterion("likeCoachCostPrice is null");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceIsNotNull() {
            addCriterion("likeCoachCostPrice is not null");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceEqualTo(String value) {
            addCriterion("likeCoachCostPrice =", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceNotEqualTo(String value) {
            addCriterion("likeCoachCostPrice <>", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceGreaterThan(String value) {
            addCriterion("likeCoachCostPrice >", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceGreaterThanOrEqualTo(String value) {
            addCriterion("likeCoachCostPrice >=", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceLessThan(String value) {
            addCriterion("likeCoachCostPrice <", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceLessThanOrEqualTo(String value) {
            addCriterion("likeCoachCostPrice <=", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceLike(String value) {
            addCriterion("likeCoachCostPrice like", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceNotLike(String value) {
            addCriterion("likeCoachCostPrice not like", value, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceIn(List<String> values) {
            addCriterion("likeCoachCostPrice in", values, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceNotIn(List<String> values) {
            addCriterion("likeCoachCostPrice not in", values, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceBetween(String value1, String value2) {
            addCriterion("likeCoachCostPrice between", value1, value2, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLikecoachcostpriceNotBetween(String value1, String value2) {
            addCriterion("likeCoachCostPrice not between", value1, value2, "likecoachcostprice");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidIsNull() {
            addCriterion("linkGoodsId is null");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidIsNotNull() {
            addCriterion("linkGoodsId is not null");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidEqualTo(String value) {
            addCriterion("linkGoodsId =", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidNotEqualTo(String value) {
            addCriterion("linkGoodsId <>", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidGreaterThan(String value) {
            addCriterion("linkGoodsId >", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidGreaterThanOrEqualTo(String value) {
            addCriterion("linkGoodsId >=", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidLessThan(String value) {
            addCriterion("linkGoodsId <", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidLessThanOrEqualTo(String value) {
            addCriterion("linkGoodsId <=", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidLike(String value) {
            addCriterion("linkGoodsId like", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidNotLike(String value) {
            addCriterion("linkGoodsId not like", value, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidIn(List<String> values) {
            addCriterion("linkGoodsId in", values, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidNotIn(List<String> values) {
            addCriterion("linkGoodsId not in", values, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidBetween(String value1, String value2) {
            addCriterion("linkGoodsId between", value1, value2, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLinkgoodsidNotBetween(String value1, String value2) {
            addCriterion("linkGoodsId not between", value1, value2, "linkgoodsid");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceIsNull() {
            addCriterion("likeGoodsCostPrice is null");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceIsNotNull() {
            addCriterion("likeGoodsCostPrice is not null");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceEqualTo(String value) {
            addCriterion("likeGoodsCostPrice =", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceNotEqualTo(String value) {
            addCriterion("likeGoodsCostPrice <>", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceGreaterThan(String value) {
            addCriterion("likeGoodsCostPrice >", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceGreaterThanOrEqualTo(String value) {
            addCriterion("likeGoodsCostPrice >=", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceLessThan(String value) {
            addCriterion("likeGoodsCostPrice <", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceLessThanOrEqualTo(String value) {
            addCriterion("likeGoodsCostPrice <=", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceLike(String value) {
            addCriterion("likeGoodsCostPrice like", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceNotLike(String value) {
            addCriterion("likeGoodsCostPrice not like", value, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceIn(List<String> values) {
            addCriterion("likeGoodsCostPrice in", values, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceNotIn(List<String> values) {
            addCriterion("likeGoodsCostPrice not in", values, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceBetween(String value1, String value2) {
            addCriterion("likeGoodsCostPrice between", value1, value2, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andLikegoodscostpriceNotBetween(String value1, String value2) {
            addCriterion("likeGoodsCostPrice not between", value1, value2, "likegoodscostprice");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Double value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Double value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Double value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Double value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Double value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Double> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Double> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Double value1, Double value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Double value1, Double value2) {
            addCriterion("balance not between", value1, value2, "balance");
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

        public Criteria andSavemoneyIsNull() {
            addCriterion("saveMoney is null");
            return (Criteria) this;
        }

        public Criteria andSavemoneyIsNotNull() {
            addCriterion("saveMoney is not null");
            return (Criteria) this;
        }

        public Criteria andSavemoneyEqualTo(Double value) {
            addCriterion("saveMoney =", value, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyNotEqualTo(Double value) {
            addCriterion("saveMoney <>", value, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyGreaterThan(Double value) {
            addCriterion("saveMoney >", value, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("saveMoney >=", value, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyLessThan(Double value) {
            addCriterion("saveMoney <", value, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyLessThanOrEqualTo(Double value) {
            addCriterion("saveMoney <=", value, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyIn(List<Double> values) {
            addCriterion("saveMoney in", values, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyNotIn(List<Double> values) {
            addCriterion("saveMoney not in", values, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyBetween(Double value1, Double value2) {
            addCriterion("saveMoney between", value1, value2, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyNotBetween(Double value1, Double value2) {
            addCriterion("saveMoney not between", value1, value2, "savemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyIsNull() {
            addCriterion("superSaveMoney is null");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyIsNotNull() {
            addCriterion("superSaveMoney is not null");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyEqualTo(Double value) {
            addCriterion("superSaveMoney =", value, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyNotEqualTo(Double value) {
            addCriterion("superSaveMoney <>", value, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyGreaterThan(Double value) {
            addCriterion("superSaveMoney >", value, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("superSaveMoney >=", value, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyLessThan(Double value) {
            addCriterion("superSaveMoney <", value, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyLessThanOrEqualTo(Double value) {
            addCriterion("superSaveMoney <=", value, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyIn(List<Double> values) {
            addCriterion("superSaveMoney in", values, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyNotIn(List<Double> values) {
            addCriterion("superSaveMoney not in", values, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyBetween(Double value1, Double value2) {
            addCriterion("superSaveMoney between", value1, value2, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSupersavemoneyNotBetween(Double value1, Double value2) {
            addCriterion("superSaveMoney not between", value1, value2, "supersavemoney");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateIsNull() {
            addCriterion("saveMoneyExpireDate is null");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateIsNotNull() {
            addCriterion("saveMoneyExpireDate is not null");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateEqualTo(String value) {
            addCriterion("saveMoneyExpireDate =", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateNotEqualTo(String value) {
            addCriterion("saveMoneyExpireDate <>", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateGreaterThan(String value) {
            addCriterion("saveMoneyExpireDate >", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateGreaterThanOrEqualTo(String value) {
            addCriterion("saveMoneyExpireDate >=", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateLessThan(String value) {
            addCriterion("saveMoneyExpireDate <", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateLessThanOrEqualTo(String value) {
            addCriterion("saveMoneyExpireDate <=", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateLike(String value) {
            addCriterion("saveMoneyExpireDate like", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateNotLike(String value) {
            addCriterion("saveMoneyExpireDate not like", value, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateIn(List<String> values) {
            addCriterion("saveMoneyExpireDate in", values, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateNotIn(List<String> values) {
            addCriterion("saveMoneyExpireDate not in", values, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateBetween(String value1, String value2) {
            addCriterion("saveMoneyExpireDate between", value1, value2, "savemoneyexpiredate");
            return (Criteria) this;
        }

        public Criteria andSavemoneyexpiredateNotBetween(String value1, String value2) {
            addCriterion("saveMoneyExpireDate not between", value1, value2, "savemoneyexpiredate");
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
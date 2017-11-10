package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEnterpriseExample() {
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

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
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

        public Criteria andOperationidIsNull() {
            addCriterion("operationId is null");
            return (Criteria) this;
        }

        public Criteria andOperationidIsNotNull() {
            addCriterion("operationId is not null");
            return (Criteria) this;
        }

        public Criteria andOperationidEqualTo(Integer value) {
            addCriterion("operationId =", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidNotEqualTo(Integer value) {
            addCriterion("operationId <>", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidGreaterThan(Integer value) {
            addCriterion("operationId >", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("operationId >=", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidLessThan(Integer value) {
            addCriterion("operationId <", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidLessThanOrEqualTo(Integer value) {
            addCriterion("operationId <=", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidIn(List<Integer> values) {
            addCriterion("operationId in", values, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidNotIn(List<Integer> values) {
            addCriterion("operationId not in", values, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidBetween(Integer value1, Integer value2) {
            addCriterion("operationId between", value1, value2, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidNotBetween(Integer value1, Integer value2) {
            addCriterion("operationId not between", value1, value2, "operationid");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIsNull() {
            addCriterion("enterpriseName is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIsNotNull() {
            addCriterion("enterpriseName is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameEqualTo(String value) {
            addCriterion("enterpriseName =", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotEqualTo(String value) {
            addCriterion("enterpriseName <>", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThan(String value) {
            addCriterion("enterpriseName >", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseName >=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThan(String value) {
            addCriterion("enterpriseName <", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThanOrEqualTo(String value) {
            addCriterion("enterpriseName <=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLike(String value) {
            addCriterion("enterpriseName like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotLike(String value) {
            addCriterion("enterpriseName not like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIn(List<String> values) {
            addCriterion("enterpriseName in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotIn(List<String> values) {
            addCriterion("enterpriseName not in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameBetween(String value1, String value2) {
            addCriterion("enterpriseName between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotBetween(String value1, String value2) {
            addCriterion("enterpriseName not between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleIsNull() {
            addCriterion("enterpriseScale is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleIsNotNull() {
            addCriterion("enterpriseScale is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleEqualTo(String value) {
            addCriterion("enterpriseScale =", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleNotEqualTo(String value) {
            addCriterion("enterpriseScale <>", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleGreaterThan(String value) {
            addCriterion("enterpriseScale >", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleGreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseScale >=", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleLessThan(String value) {
            addCriterion("enterpriseScale <", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleLessThanOrEqualTo(String value) {
            addCriterion("enterpriseScale <=", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleLike(String value) {
            addCriterion("enterpriseScale like", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleNotLike(String value) {
            addCriterion("enterpriseScale not like", value, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleIn(List<String> values) {
            addCriterion("enterpriseScale in", values, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleNotIn(List<String> values) {
            addCriterion("enterpriseScale not in", values, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleBetween(String value1, String value2) {
            addCriterion("enterpriseScale between", value1, value2, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterprisescaleNotBetween(String value1, String value2) {
            addCriterion("enterpriseScale not between", value1, value2, "enterprisescale");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoIsNull() {
            addCriterion("enterpriseLogo is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoIsNotNull() {
            addCriterion("enterpriseLogo is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoEqualTo(String value) {
            addCriterion("enterpriseLogo =", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoNotEqualTo(String value) {
            addCriterion("enterpriseLogo <>", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoGreaterThan(String value) {
            addCriterion("enterpriseLogo >", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoGreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseLogo >=", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoLessThan(String value) {
            addCriterion("enterpriseLogo <", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoLessThanOrEqualTo(String value) {
            addCriterion("enterpriseLogo <=", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoLike(String value) {
            addCriterion("enterpriseLogo like", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoNotLike(String value) {
            addCriterion("enterpriseLogo not like", value, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoIn(List<String> values) {
            addCriterion("enterpriseLogo in", values, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoNotIn(List<String> values) {
            addCriterion("enterpriseLogo not in", values, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoBetween(String value1, String value2) {
            addCriterion("enterpriseLogo between", value1, value2, "enterpriselogo");
            return (Criteria) this;
        }

        public Criteria andEnterpriselogoNotBetween(String value1, String value2) {
            addCriterion("enterpriseLogo not between", value1, value2, "enterpriselogo");
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

        public Criteria andEnterpriseaddrIsNull() {
            addCriterion("enterpriseAddr is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrIsNotNull() {
            addCriterion("enterpriseAddr is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrEqualTo(String value) {
            addCriterion("enterpriseAddr =", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrNotEqualTo(String value) {
            addCriterion("enterpriseAddr <>", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrGreaterThan(String value) {
            addCriterion("enterpriseAddr >", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrGreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseAddr >=", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrLessThan(String value) {
            addCriterion("enterpriseAddr <", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrLessThanOrEqualTo(String value) {
            addCriterion("enterpriseAddr <=", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrLike(String value) {
            addCriterion("enterpriseAddr like", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrNotLike(String value) {
            addCriterion("enterpriseAddr not like", value, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrIn(List<String> values) {
            addCriterion("enterpriseAddr in", values, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrNotIn(List<String> values) {
            addCriterion("enterpriseAddr not in", values, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrBetween(String value1, String value2) {
            addCriterion("enterpriseAddr between", value1, value2, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseaddrNotBetween(String value1, String value2) {
            addCriterion("enterpriseAddr not between", value1, value2, "enterpriseaddr");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelIsNull() {
            addCriterion("enterpriseTel is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelIsNotNull() {
            addCriterion("enterpriseTel is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelEqualTo(String value) {
            addCriterion("enterpriseTel =", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelNotEqualTo(String value) {
            addCriterion("enterpriseTel <>", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelGreaterThan(String value) {
            addCriterion("enterpriseTel >", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelGreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseTel >=", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelLessThan(String value) {
            addCriterion("enterpriseTel <", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelLessThanOrEqualTo(String value) {
            addCriterion("enterpriseTel <=", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelLike(String value) {
            addCriterion("enterpriseTel like", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelNotLike(String value) {
            addCriterion("enterpriseTel not like", value, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelIn(List<String> values) {
            addCriterion("enterpriseTel in", values, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelNotIn(List<String> values) {
            addCriterion("enterpriseTel not in", values, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelBetween(String value1, String value2) {
            addCriterion("enterpriseTel between", value1, value2, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andEnterprisetelNotBetween(String value1, String value2) {
            addCriterion("enterpriseTel not between", value1, value2, "enterprisetel");
            return (Criteria) this;
        }

        public Criteria andContactnameIsNull() {
            addCriterion("contactName is null");
            return (Criteria) this;
        }

        public Criteria andContactnameIsNotNull() {
            addCriterion("contactName is not null");
            return (Criteria) this;
        }

        public Criteria andContactnameEqualTo(String value) {
            addCriterion("contactName =", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotEqualTo(String value) {
            addCriterion("contactName <>", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameGreaterThan(String value) {
            addCriterion("contactName >", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameGreaterThanOrEqualTo(String value) {
            addCriterion("contactName >=", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameLessThan(String value) {
            addCriterion("contactName <", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameLessThanOrEqualTo(String value) {
            addCriterion("contactName <=", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameLike(String value) {
            addCriterion("contactName like", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotLike(String value) {
            addCriterion("contactName not like", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameIn(List<String> values) {
            addCriterion("contactName in", values, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotIn(List<String> values) {
            addCriterion("contactName not in", values, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameBetween(String value1, String value2) {
            addCriterion("contactName between", value1, value2, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotBetween(String value1, String value2) {
            addCriterion("contactName not between", value1, value2, "contactname");
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

        public Criteria andIsdelEqualTo(String value) {
            addCriterion("isDel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(String value) {
            addCriterion("isDel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(String value) {
            addCriterion("isDel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(String value) {
            addCriterion("isDel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(String value) {
            addCriterion("isDel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(String value) {
            addCriterion("isDel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLike(String value) {
            addCriterion("isDel like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotLike(String value) {
            addCriterion("isDel not like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<String> values) {
            addCriterion("isDel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<String> values) {
            addCriterion("isDel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(String value1, String value2) {
            addCriterion("isDel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(String value1, String value2) {
            addCriterion("isDel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsactivityIsNull() {
            addCriterion("isActivity is null");
            return (Criteria) this;
        }

        public Criteria andIsactivityIsNotNull() {
            addCriterion("isActivity is not null");
            return (Criteria) this;
        }

        public Criteria andIsactivityEqualTo(Integer value) {
            addCriterion("isActivity =", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityNotEqualTo(Integer value) {
            addCriterion("isActivity <>", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityGreaterThan(Integer value) {
            addCriterion("isActivity >", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityGreaterThanOrEqualTo(Integer value) {
            addCriterion("isActivity >=", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityLessThan(Integer value) {
            addCriterion("isActivity <", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityLessThanOrEqualTo(Integer value) {
            addCriterion("isActivity <=", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityIn(List<Integer> values) {
            addCriterion("isActivity in", values, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityNotIn(List<Integer> values) {
            addCriterion("isActivity not in", values, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityBetween(Integer value1, Integer value2) {
            addCriterion("isActivity between", value1, value2, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityNotBetween(Integer value1, Integer value2) {
            addCriterion("isActivity not between", value1, value2, "isactivity");
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
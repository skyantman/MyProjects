package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TActivityExample() {
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

        public Criteria andActiveidIsNull() {
            addCriterion("activeId is null");
            return (Criteria) this;
        }

        public Criteria andActiveidIsNotNull() {
            addCriterion("activeId is not null");
            return (Criteria) this;
        }

        public Criteria andActiveidEqualTo(Integer value) {
            addCriterion("activeId =", value, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidNotEqualTo(Integer value) {
            addCriterion("activeId <>", value, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidGreaterThan(Integer value) {
            addCriterion("activeId >", value, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidGreaterThanOrEqualTo(Integer value) {
            addCriterion("activeId >=", value, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidLessThan(Integer value) {
            addCriterion("activeId <", value, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidLessThanOrEqualTo(Integer value) {
            addCriterion("activeId <=", value, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidIn(List<Integer> values) {
            addCriterion("activeId in", values, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidNotIn(List<Integer> values) {
            addCriterion("activeId not in", values, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidBetween(Integer value1, Integer value2) {
            addCriterion("activeId between", value1, value2, "activeid");
            return (Criteria) this;
        }

        public Criteria andActiveidNotBetween(Integer value1, Integer value2) {
            addCriterion("activeId not between", value1, value2, "activeid");
            return (Criteria) this;
        }

        public Criteria andActivenameIsNull() {
            addCriterion("activeName is null");
            return (Criteria) this;
        }

        public Criteria andActivenameIsNotNull() {
            addCriterion("activeName is not null");
            return (Criteria) this;
        }

        public Criteria andActivenameEqualTo(String value) {
            addCriterion("activeName =", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotEqualTo(String value) {
            addCriterion("activeName <>", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameGreaterThan(String value) {
            addCriterion("activeName >", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameGreaterThanOrEqualTo(String value) {
            addCriterion("activeName >=", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameLessThan(String value) {
            addCriterion("activeName <", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameLessThanOrEqualTo(String value) {
            addCriterion("activeName <=", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameLike(String value) {
            addCriterion("activeName like", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotLike(String value) {
            addCriterion("activeName not like", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameIn(List<String> values) {
            addCriterion("activeName in", values, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotIn(List<String> values) {
            addCriterion("activeName not in", values, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameBetween(String value1, String value2) {
            addCriterion("activeName between", value1, value2, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotBetween(String value1, String value2) {
            addCriterion("activeName not between", value1, value2, "activename");
            return (Criteria) this;
        }

        public Criteria andActivetypeIsNull() {
            addCriterion("activeType is null");
            return (Criteria) this;
        }

        public Criteria andActivetypeIsNotNull() {
            addCriterion("activeType is not null");
            return (Criteria) this;
        }

        public Criteria andActivetypeEqualTo(Integer value) {
            addCriterion("activeType =", value, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeNotEqualTo(Integer value) {
            addCriterion("activeType <>", value, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeGreaterThan(Integer value) {
            addCriterion("activeType >", value, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activeType >=", value, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeLessThan(Integer value) {
            addCriterion("activeType <", value, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeLessThanOrEqualTo(Integer value) {
            addCriterion("activeType <=", value, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeIn(List<Integer> values) {
            addCriterion("activeType in", values, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeNotIn(List<Integer> values) {
            addCriterion("activeType not in", values, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeBetween(Integer value1, Integer value2) {
            addCriterion("activeType between", value1, value2, "activetype");
            return (Criteria) this;
        }

        public Criteria andActivetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("activeType not between", value1, value2, "activetype");
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

        public Criteria andActiveaddresIsNull() {
            addCriterion("activeAddres is null");
            return (Criteria) this;
        }

        public Criteria andActiveaddresIsNotNull() {
            addCriterion("activeAddres is not null");
            return (Criteria) this;
        }

        public Criteria andActiveaddresEqualTo(String value) {
            addCriterion("activeAddres =", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresNotEqualTo(String value) {
            addCriterion("activeAddres <>", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresGreaterThan(String value) {
            addCriterion("activeAddres >", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresGreaterThanOrEqualTo(String value) {
            addCriterion("activeAddres >=", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresLessThan(String value) {
            addCriterion("activeAddres <", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresLessThanOrEqualTo(String value) {
            addCriterion("activeAddres <=", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresLike(String value) {
            addCriterion("activeAddres like", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresNotLike(String value) {
            addCriterion("activeAddres not like", value, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresIn(List<String> values) {
            addCriterion("activeAddres in", values, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresNotIn(List<String> values) {
            addCriterion("activeAddres not in", values, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresBetween(String value1, String value2) {
            addCriterion("activeAddres between", value1, value2, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActiveaddresNotBetween(String value1, String value2) {
            addCriterion("activeAddres not between", value1, value2, "activeaddres");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeIsNull() {
            addCriterion("activeStartTime is null");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeIsNotNull() {
            addCriterion("activeStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeEqualTo(String value) {
            addCriterion("activeStartTime =", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeNotEqualTo(String value) {
            addCriterion("activeStartTime <>", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeGreaterThan(String value) {
            addCriterion("activeStartTime >", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("activeStartTime >=", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeLessThan(String value) {
            addCriterion("activeStartTime <", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeLessThanOrEqualTo(String value) {
            addCriterion("activeStartTime <=", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeLike(String value) {
            addCriterion("activeStartTime like", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeNotLike(String value) {
            addCriterion("activeStartTime not like", value, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeIn(List<String> values) {
            addCriterion("activeStartTime in", values, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeNotIn(List<String> values) {
            addCriterion("activeStartTime not in", values, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeBetween(String value1, String value2) {
            addCriterion("activeStartTime between", value1, value2, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActivestarttimeNotBetween(String value1, String value2) {
            addCriterion("activeStartTime not between", value1, value2, "activestarttime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeIsNull() {
            addCriterion("activeEndTime is null");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeIsNotNull() {
            addCriterion("activeEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeEqualTo(String value) {
            addCriterion("activeEndTime =", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeNotEqualTo(String value) {
            addCriterion("activeEndTime <>", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeGreaterThan(String value) {
            addCriterion("activeEndTime >", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("activeEndTime >=", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeLessThan(String value) {
            addCriterion("activeEndTime <", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeLessThanOrEqualTo(String value) {
            addCriterion("activeEndTime <=", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeLike(String value) {
            addCriterion("activeEndTime like", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeNotLike(String value) {
            addCriterion("activeEndTime not like", value, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeIn(List<String> values) {
            addCriterion("activeEndTime in", values, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeNotIn(List<String> values) {
            addCriterion("activeEndTime not in", values, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeBetween(String value1, String value2) {
            addCriterion("activeEndTime between", value1, value2, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActiveendtimeNotBetween(String value1, String value2) {
            addCriterion("activeEndTime not between", value1, value2, "activeendtime");
            return (Criteria) this;
        }

        public Criteria andActivenumIsNull() {
            addCriterion("activeNum is null");
            return (Criteria) this;
        }

        public Criteria andActivenumIsNotNull() {
            addCriterion("activeNum is not null");
            return (Criteria) this;
        }

        public Criteria andActivenumEqualTo(Integer value) {
            addCriterion("activeNum =", value, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumNotEqualTo(Integer value) {
            addCriterion("activeNum <>", value, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumGreaterThan(Integer value) {
            addCriterion("activeNum >", value, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activeNum >=", value, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumLessThan(Integer value) {
            addCriterion("activeNum <", value, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumLessThanOrEqualTo(Integer value) {
            addCriterion("activeNum <=", value, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumIn(List<Integer> values) {
            addCriterion("activeNum in", values, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumNotIn(List<Integer> values) {
            addCriterion("activeNum not in", values, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumBetween(Integer value1, Integer value2) {
            addCriterion("activeNum between", value1, value2, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivenumNotBetween(Integer value1, Integer value2) {
            addCriterion("activeNum not between", value1, value2, "activenum");
            return (Criteria) this;
        }

        public Criteria andActivekeywordIsNull() {
            addCriterion("activeKeyword is null");
            return (Criteria) this;
        }

        public Criteria andActivekeywordIsNotNull() {
            addCriterion("activeKeyword is not null");
            return (Criteria) this;
        }

        public Criteria andActivekeywordEqualTo(String value) {
            addCriterion("activeKeyword =", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordNotEqualTo(String value) {
            addCriterion("activeKeyword <>", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordGreaterThan(String value) {
            addCriterion("activeKeyword >", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordGreaterThanOrEqualTo(String value) {
            addCriterion("activeKeyword >=", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordLessThan(String value) {
            addCriterion("activeKeyword <", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordLessThanOrEqualTo(String value) {
            addCriterion("activeKeyword <=", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordLike(String value) {
            addCriterion("activeKeyword like", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordNotLike(String value) {
            addCriterion("activeKeyword not like", value, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordIn(List<String> values) {
            addCriterion("activeKeyword in", values, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordNotIn(List<String> values) {
            addCriterion("activeKeyword not in", values, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordBetween(String value1, String value2) {
            addCriterion("activeKeyword between", value1, value2, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActivekeywordNotBetween(String value1, String value2) {
            addCriterion("activeKeyword not between", value1, value2, "activekeyword");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceIsNull() {
            addCriterion("activeIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceIsNotNull() {
            addCriterion("activeIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceEqualTo(String value) {
            addCriterion("activeIntroduce =", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceNotEqualTo(String value) {
            addCriterion("activeIntroduce <>", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceGreaterThan(String value) {
            addCriterion("activeIntroduce >", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceGreaterThanOrEqualTo(String value) {
            addCriterion("activeIntroduce >=", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceLessThan(String value) {
            addCriterion("activeIntroduce <", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceLessThanOrEqualTo(String value) {
            addCriterion("activeIntroduce <=", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceLike(String value) {
            addCriterion("activeIntroduce like", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceNotLike(String value) {
            addCriterion("activeIntroduce not like", value, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceIn(List<String> values) {
            addCriterion("activeIntroduce in", values, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceNotIn(List<String> values) {
            addCriterion("activeIntroduce not in", values, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceBetween(String value1, String value2) {
            addCriterion("activeIntroduce between", value1, value2, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActiveintroduceNotBetween(String value1, String value2) {
            addCriterion("activeIntroduce not between", value1, value2, "activeintroduce");
            return (Criteria) this;
        }

        public Criteria andActivecommIsNull() {
            addCriterion("activeComm is null");
            return (Criteria) this;
        }

        public Criteria andActivecommIsNotNull() {
            addCriterion("activeComm is not null");
            return (Criteria) this;
        }

        public Criteria andActivecommEqualTo(String value) {
            addCriterion("activeComm =", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommNotEqualTo(String value) {
            addCriterion("activeComm <>", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommGreaterThan(String value) {
            addCriterion("activeComm >", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommGreaterThanOrEqualTo(String value) {
            addCriterion("activeComm >=", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommLessThan(String value) {
            addCriterion("activeComm <", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommLessThanOrEqualTo(String value) {
            addCriterion("activeComm <=", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommLike(String value) {
            addCriterion("activeComm like", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommNotLike(String value) {
            addCriterion("activeComm not like", value, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommIn(List<String> values) {
            addCriterion("activeComm in", values, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommNotIn(List<String> values) {
            addCriterion("activeComm not in", values, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommBetween(String value1, String value2) {
            addCriterion("activeComm between", value1, value2, "activecomm");
            return (Criteria) this;
        }

        public Criteria andActivecommNotBetween(String value1, String value2) {
            addCriterion("activeComm not between", value1, value2, "activecomm");
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

        public Criteria andAlreadymanIsNull() {
            addCriterion("alreadyMan is null");
            return (Criteria) this;
        }

        public Criteria andAlreadymanIsNotNull() {
            addCriterion("alreadyMan is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadymanEqualTo(Integer value) {
            addCriterion("alreadyMan =", value, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanNotEqualTo(Integer value) {
            addCriterion("alreadyMan <>", value, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanGreaterThan(Integer value) {
            addCriterion("alreadyMan >", value, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanGreaterThanOrEqualTo(Integer value) {
            addCriterion("alreadyMan >=", value, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanLessThan(Integer value) {
            addCriterion("alreadyMan <", value, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanLessThanOrEqualTo(Integer value) {
            addCriterion("alreadyMan <=", value, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanIn(List<Integer> values) {
            addCriterion("alreadyMan in", values, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanNotIn(List<Integer> values) {
            addCriterion("alreadyMan not in", values, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanBetween(Integer value1, Integer value2) {
            addCriterion("alreadyMan between", value1, value2, "alreadyman");
            return (Criteria) this;
        }

        public Criteria andAlreadymanNotBetween(Integer value1, Integer value2) {
            addCriterion("alreadyMan not between", value1, value2, "alreadyman");
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

        public Criteria andStudiocostIsNull() {
            addCriterion("studioCost is null");
            return (Criteria) this;
        }

        public Criteria andStudiocostIsNotNull() {
            addCriterion("studioCost is not null");
            return (Criteria) this;
        }

        public Criteria andStudiocostEqualTo(Double value) {
            addCriterion("studioCost =", value, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostNotEqualTo(Double value) {
            addCriterion("studioCost <>", value, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostGreaterThan(Double value) {
            addCriterion("studioCost >", value, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostGreaterThanOrEqualTo(Double value) {
            addCriterion("studioCost >=", value, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostLessThan(Double value) {
            addCriterion("studioCost <", value, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostLessThanOrEqualTo(Double value) {
            addCriterion("studioCost <=", value, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostIn(List<Double> values) {
            addCriterion("studioCost in", values, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostNotIn(List<Double> values) {
            addCriterion("studioCost not in", values, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostBetween(Double value1, Double value2) {
            addCriterion("studioCost between", value1, value2, "studiocost");
            return (Criteria) this;
        }

        public Criteria andStudiocostNotBetween(Double value1, Double value2) {
            addCriterion("studioCost not between", value1, value2, "studiocost");
            return (Criteria) this;
        }

        public Criteria andCoachidsIsNull() {
            addCriterion("coachIds is null");
            return (Criteria) this;
        }

        public Criteria andCoachidsIsNotNull() {
            addCriterion("coachIds is not null");
            return (Criteria) this;
        }

        public Criteria andCoachidsEqualTo(String value) {
            addCriterion("coachIds =", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsNotEqualTo(String value) {
            addCriterion("coachIds <>", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsGreaterThan(String value) {
            addCriterion("coachIds >", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsGreaterThanOrEqualTo(String value) {
            addCriterion("coachIds >=", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsLessThan(String value) {
            addCriterion("coachIds <", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsLessThanOrEqualTo(String value) {
            addCriterion("coachIds <=", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsLike(String value) {
            addCriterion("coachIds like", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsNotLike(String value) {
            addCriterion("coachIds not like", value, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsIn(List<String> values) {
            addCriterion("coachIds in", values, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsNotIn(List<String> values) {
            addCriterion("coachIds not in", values, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsBetween(String value1, String value2) {
            addCriterion("coachIds between", value1, value2, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachidsNotBetween(String value1, String value2) {
            addCriterion("coachIds not between", value1, value2, "coachids");
            return (Criteria) this;
        }

        public Criteria andCoachcostsIsNull() {
            addCriterion("coachCosts is null");
            return (Criteria) this;
        }

        public Criteria andCoachcostsIsNotNull() {
            addCriterion("coachCosts is not null");
            return (Criteria) this;
        }

        public Criteria andCoachcostsEqualTo(String value) {
            addCriterion("coachCosts =", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsNotEqualTo(String value) {
            addCriterion("coachCosts <>", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsGreaterThan(String value) {
            addCriterion("coachCosts >", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsGreaterThanOrEqualTo(String value) {
            addCriterion("coachCosts >=", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsLessThan(String value) {
            addCriterion("coachCosts <", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsLessThanOrEqualTo(String value) {
            addCriterion("coachCosts <=", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsLike(String value) {
            addCriterion("coachCosts like", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsNotLike(String value) {
            addCriterion("coachCosts not like", value, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsIn(List<String> values) {
            addCriterion("coachCosts in", values, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsNotIn(List<String> values) {
            addCriterion("coachCosts not in", values, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsBetween(String value1, String value2) {
            addCriterion("coachCosts between", value1, value2, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andCoachcostsNotBetween(String value1, String value2) {
            addCriterion("coachCosts not between", value1, value2, "coachcosts");
            return (Criteria) this;
        }

        public Criteria andActivepriceIsNull() {
            addCriterion("activePrice is null");
            return (Criteria) this;
        }

        public Criteria andActivepriceIsNotNull() {
            addCriterion("activePrice is not null");
            return (Criteria) this;
        }

        public Criteria andActivepriceEqualTo(Double value) {
            addCriterion("activePrice =", value, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceNotEqualTo(Double value) {
            addCriterion("activePrice <>", value, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceGreaterThan(Double value) {
            addCriterion("activePrice >", value, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("activePrice >=", value, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceLessThan(Double value) {
            addCriterion("activePrice <", value, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceLessThanOrEqualTo(Double value) {
            addCriterion("activePrice <=", value, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceIn(List<Double> values) {
            addCriterion("activePrice in", values, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceNotIn(List<Double> values) {
            addCriterion("activePrice not in", values, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceBetween(Double value1, Double value2) {
            addCriterion("activePrice between", value1, value2, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivepriceNotBetween(Double value1, Double value2) {
            addCriterion("activePrice not between", value1, value2, "activeprice");
            return (Criteria) this;
        }

        public Criteria andActivesubnumIsNull() {
            addCriterion("activeSubNum is null");
            return (Criteria) this;
        }

        public Criteria andActivesubnumIsNotNull() {
            addCriterion("activeSubNum is not null");
            return (Criteria) this;
        }

        public Criteria andActivesubnumEqualTo(Integer value) {
            addCriterion("activeSubNum =", value, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumNotEqualTo(Integer value) {
            addCriterion("activeSubNum <>", value, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumGreaterThan(Integer value) {
            addCriterion("activeSubNum >", value, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activeSubNum >=", value, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumLessThan(Integer value) {
            addCriterion("activeSubNum <", value, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumLessThanOrEqualTo(Integer value) {
            addCriterion("activeSubNum <=", value, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumIn(List<Integer> values) {
            addCriterion("activeSubNum in", values, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumNotIn(List<Integer> values) {
            addCriterion("activeSubNum not in", values, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumBetween(Integer value1, Integer value2) {
            addCriterion("activeSubNum between", value1, value2, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivesubnumNotBetween(Integer value1, Integer value2) {
            addCriterion("activeSubNum not between", value1, value2, "activesubnum");
            return (Criteria) this;
        }

        public Criteria andActivitylimitIsNull() {
            addCriterion("activityLimit is null");
            return (Criteria) this;
        }

        public Criteria andActivitylimitIsNotNull() {
            addCriterion("activityLimit is not null");
            return (Criteria) this;
        }

        public Criteria andActivitylimitEqualTo(Integer value) {
            addCriterion("activityLimit =", value, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitNotEqualTo(Integer value) {
            addCriterion("activityLimit <>", value, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitGreaterThan(Integer value) {
            addCriterion("activityLimit >", value, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("activityLimit >=", value, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitLessThan(Integer value) {
            addCriterion("activityLimit <", value, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitLessThanOrEqualTo(Integer value) {
            addCriterion("activityLimit <=", value, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitIn(List<Integer> values) {
            addCriterion("activityLimit in", values, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitNotIn(List<Integer> values) {
            addCriterion("activityLimit not in", values, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitBetween(Integer value1, Integer value2) {
            addCriterion("activityLimit between", value1, value2, "activitylimit");
            return (Criteria) this;
        }

        public Criteria andActivitylimitNotBetween(Integer value1, Integer value2) {
            addCriterion("activityLimit not between", value1, value2, "activitylimit");
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
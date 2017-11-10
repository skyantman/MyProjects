package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TBodyfatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBodyfatExample() {
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

        public Criteria andMeasuretimeIsNull() {
            addCriterion("measureTime is null");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeIsNotNull() {
            addCriterion("measureTime is not null");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeEqualTo(String value) {
            addCriterion("measureTime =", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeNotEqualTo(String value) {
            addCriterion("measureTime <>", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeGreaterThan(String value) {
            addCriterion("measureTime >", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeGreaterThanOrEqualTo(String value) {
            addCriterion("measureTime >=", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeLessThan(String value) {
            addCriterion("measureTime <", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeLessThanOrEqualTo(String value) {
            addCriterion("measureTime <=", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeLike(String value) {
            addCriterion("measureTime like", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeNotLike(String value) {
            addCriterion("measureTime not like", value, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeIn(List<String> values) {
            addCriterion("measureTime in", values, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeNotIn(List<String> values) {
            addCriterion("measureTime not in", values, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeBetween(String value1, String value2) {
            addCriterion("measureTime between", value1, value2, "measuretime");
            return (Criteria) this;
        }

        public Criteria andMeasuretimeNotBetween(String value1, String value2) {
            addCriterion("measureTime not between", value1, value2, "measuretime");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andBmiIsNull() {
            addCriterion("bmi is null");
            return (Criteria) this;
        }

        public Criteria andBmiIsNotNull() {
            addCriterion("bmi is not null");
            return (Criteria) this;
        }

        public Criteria andBmiEqualTo(String value) {
            addCriterion("bmi =", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotEqualTo(String value) {
            addCriterion("bmi <>", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThan(String value) {
            addCriterion("bmi >", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThanOrEqualTo(String value) {
            addCriterion("bmi >=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThan(String value) {
            addCriterion("bmi <", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThanOrEqualTo(String value) {
            addCriterion("bmi <=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLike(String value) {
            addCriterion("bmi like", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotLike(String value) {
            addCriterion("bmi not like", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiIn(List<String> values) {
            addCriterion("bmi in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotIn(List<String> values) {
            addCriterion("bmi not in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiBetween(String value1, String value2) {
            addCriterion("bmi between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotBetween(String value1, String value2) {
            addCriterion("bmi not between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andBodyfatIsNull() {
            addCriterion("bodyfat is null");
            return (Criteria) this;
        }

        public Criteria andBodyfatIsNotNull() {
            addCriterion("bodyfat is not null");
            return (Criteria) this;
        }

        public Criteria andBodyfatEqualTo(String value) {
            addCriterion("bodyfat =", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatNotEqualTo(String value) {
            addCriterion("bodyfat <>", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatGreaterThan(String value) {
            addCriterion("bodyfat >", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatGreaterThanOrEqualTo(String value) {
            addCriterion("bodyfat >=", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatLessThan(String value) {
            addCriterion("bodyfat <", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatLessThanOrEqualTo(String value) {
            addCriterion("bodyfat <=", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatLike(String value) {
            addCriterion("bodyfat like", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatNotLike(String value) {
            addCriterion("bodyfat not like", value, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatIn(List<String> values) {
            addCriterion("bodyfat in", values, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatNotIn(List<String> values) {
            addCriterion("bodyfat not in", values, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatBetween(String value1, String value2) {
            addCriterion("bodyfat between", value1, value2, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andBodyfatNotBetween(String value1, String value2) {
            addCriterion("bodyfat not between", value1, value2, "bodyfat");
            return (Criteria) this;
        }

        public Criteria andSubfatIsNull() {
            addCriterion("subfat is null");
            return (Criteria) this;
        }

        public Criteria andSubfatIsNotNull() {
            addCriterion("subfat is not null");
            return (Criteria) this;
        }

        public Criteria andSubfatEqualTo(String value) {
            addCriterion("subfat =", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatNotEqualTo(String value) {
            addCriterion("subfat <>", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatGreaterThan(String value) {
            addCriterion("subfat >", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatGreaterThanOrEqualTo(String value) {
            addCriterion("subfat >=", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatLessThan(String value) {
            addCriterion("subfat <", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatLessThanOrEqualTo(String value) {
            addCriterion("subfat <=", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatLike(String value) {
            addCriterion("subfat like", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatNotLike(String value) {
            addCriterion("subfat not like", value, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatIn(List<String> values) {
            addCriterion("subfat in", values, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatNotIn(List<String> values) {
            addCriterion("subfat not in", values, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatBetween(String value1, String value2) {
            addCriterion("subfat between", value1, value2, "subfat");
            return (Criteria) this;
        }

        public Criteria andSubfatNotBetween(String value1, String value2) {
            addCriterion("subfat not between", value1, value2, "subfat");
            return (Criteria) this;
        }

        public Criteria andVisfatIsNull() {
            addCriterion("visfat is null");
            return (Criteria) this;
        }

        public Criteria andVisfatIsNotNull() {
            addCriterion("visfat is not null");
            return (Criteria) this;
        }

        public Criteria andVisfatEqualTo(String value) {
            addCriterion("visfat =", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatNotEqualTo(String value) {
            addCriterion("visfat <>", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatGreaterThan(String value) {
            addCriterion("visfat >", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatGreaterThanOrEqualTo(String value) {
            addCriterion("visfat >=", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatLessThan(String value) {
            addCriterion("visfat <", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatLessThanOrEqualTo(String value) {
            addCriterion("visfat <=", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatLike(String value) {
            addCriterion("visfat like", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatNotLike(String value) {
            addCriterion("visfat not like", value, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatIn(List<String> values) {
            addCriterion("visfat in", values, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatNotIn(List<String> values) {
            addCriterion("visfat not in", values, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatBetween(String value1, String value2) {
            addCriterion("visfat between", value1, value2, "visfat");
            return (Criteria) this;
        }

        public Criteria andVisfatNotBetween(String value1, String value2) {
            addCriterion("visfat not between", value1, value2, "visfat");
            return (Criteria) this;
        }

        public Criteria andWaterIsNull() {
            addCriterion("water is null");
            return (Criteria) this;
        }

        public Criteria andWaterIsNotNull() {
            addCriterion("water is not null");
            return (Criteria) this;
        }

        public Criteria andWaterEqualTo(String value) {
            addCriterion("water =", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotEqualTo(String value) {
            addCriterion("water <>", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThan(String value) {
            addCriterion("water >", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThanOrEqualTo(String value) {
            addCriterion("water >=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThan(String value) {
            addCriterion("water <", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThanOrEqualTo(String value) {
            addCriterion("water <=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLike(String value) {
            addCriterion("water like", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotLike(String value) {
            addCriterion("water not like", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterIn(List<String> values) {
            addCriterion("water in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotIn(List<String> values) {
            addCriterion("water not in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterBetween(String value1, String value2) {
            addCriterion("water between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotBetween(String value1, String value2) {
            addCriterion("water not between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andBmrIsNull() {
            addCriterion("bmr is null");
            return (Criteria) this;
        }

        public Criteria andBmrIsNotNull() {
            addCriterion("bmr is not null");
            return (Criteria) this;
        }

        public Criteria andBmrEqualTo(String value) {
            addCriterion("bmr =", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrNotEqualTo(String value) {
            addCriterion("bmr <>", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrGreaterThan(String value) {
            addCriterion("bmr >", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrGreaterThanOrEqualTo(String value) {
            addCriterion("bmr >=", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrLessThan(String value) {
            addCriterion("bmr <", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrLessThanOrEqualTo(String value) {
            addCriterion("bmr <=", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrLike(String value) {
            addCriterion("bmr like", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrNotLike(String value) {
            addCriterion("bmr not like", value, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrIn(List<String> values) {
            addCriterion("bmr in", values, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrNotIn(List<String> values) {
            addCriterion("bmr not in", values, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrBetween(String value1, String value2) {
            addCriterion("bmr between", value1, value2, "bmr");
            return (Criteria) this;
        }

        public Criteria andBmrNotBetween(String value1, String value2) {
            addCriterion("bmr not between", value1, value2, "bmr");
            return (Criteria) this;
        }

        public Criteria andMuscleIsNull() {
            addCriterion("muscle is null");
            return (Criteria) this;
        }

        public Criteria andMuscleIsNotNull() {
            addCriterion("muscle is not null");
            return (Criteria) this;
        }

        public Criteria andMuscleEqualTo(String value) {
            addCriterion("muscle =", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleNotEqualTo(String value) {
            addCriterion("muscle <>", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleGreaterThan(String value) {
            addCriterion("muscle >", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleGreaterThanOrEqualTo(String value) {
            addCriterion("muscle >=", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleLessThan(String value) {
            addCriterion("muscle <", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleLessThanOrEqualTo(String value) {
            addCriterion("muscle <=", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleLike(String value) {
            addCriterion("muscle like", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleNotLike(String value) {
            addCriterion("muscle not like", value, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleIn(List<String> values) {
            addCriterion("muscle in", values, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleNotIn(List<String> values) {
            addCriterion("muscle not in", values, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleBetween(String value1, String value2) {
            addCriterion("muscle between", value1, value2, "muscle");
            return (Criteria) this;
        }

        public Criteria andMuscleNotBetween(String value1, String value2) {
            addCriterion("muscle not between", value1, value2, "muscle");
            return (Criteria) this;
        }

        public Criteria andBoneIsNull() {
            addCriterion("bone is null");
            return (Criteria) this;
        }

        public Criteria andBoneIsNotNull() {
            addCriterion("bone is not null");
            return (Criteria) this;
        }

        public Criteria andBoneEqualTo(String value) {
            addCriterion("bone =", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneNotEqualTo(String value) {
            addCriterion("bone <>", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneGreaterThan(String value) {
            addCriterion("bone >", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneGreaterThanOrEqualTo(String value) {
            addCriterion("bone >=", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneLessThan(String value) {
            addCriterion("bone <", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneLessThanOrEqualTo(String value) {
            addCriterion("bone <=", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneLike(String value) {
            addCriterion("bone like", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneNotLike(String value) {
            addCriterion("bone not like", value, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneIn(List<String> values) {
            addCriterion("bone in", values, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneNotIn(List<String> values) {
            addCriterion("bone not in", values, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneBetween(String value1, String value2) {
            addCriterion("bone between", value1, value2, "bone");
            return (Criteria) this;
        }

        public Criteria andBoneNotBetween(String value1, String value2) {
            addCriterion("bone not between", value1, value2, "bone");
            return (Criteria) this;
        }

        public Criteria andProteinIsNull() {
            addCriterion("protein is null");
            return (Criteria) this;
        }

        public Criteria andProteinIsNotNull() {
            addCriterion("protein is not null");
            return (Criteria) this;
        }

        public Criteria andProteinEqualTo(String value) {
            addCriterion("protein =", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotEqualTo(String value) {
            addCriterion("protein <>", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThan(String value) {
            addCriterion("protein >", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThanOrEqualTo(String value) {
            addCriterion("protein >=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThan(String value) {
            addCriterion("protein <", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThanOrEqualTo(String value) {
            addCriterion("protein <=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLike(String value) {
            addCriterion("protein like", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotLike(String value) {
            addCriterion("protein not like", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinIn(List<String> values) {
            addCriterion("protein in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotIn(List<String> values) {
            addCriterion("protein not in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinBetween(String value1, String value2) {
            addCriterion("protein between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotBetween(String value1, String value2) {
            addCriterion("protein not between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andMmIsNull() {
            addCriterion("mm is null");
            return (Criteria) this;
        }

        public Criteria andMmIsNotNull() {
            addCriterion("mm is not null");
            return (Criteria) this;
        }

        public Criteria andMmEqualTo(String value) {
            addCriterion("mm =", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotEqualTo(String value) {
            addCriterion("mm <>", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmGreaterThan(String value) {
            addCriterion("mm >", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmGreaterThanOrEqualTo(String value) {
            addCriterion("mm >=", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLessThan(String value) {
            addCriterion("mm <", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLessThanOrEqualTo(String value) {
            addCriterion("mm <=", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLike(String value) {
            addCriterion("mm like", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotLike(String value) {
            addCriterion("mm not like", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmIn(List<String> values) {
            addCriterion("mm in", values, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotIn(List<String> values) {
            addCriterion("mm not in", values, "mm");
            return (Criteria) this;
        }

        public Criteria andMmBetween(String value1, String value2) {
            addCriterion("mm between", value1, value2, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotBetween(String value1, String value2) {
            addCriterion("mm not between", value1, value2, "mm");
            return (Criteria) this;
        }

        public Criteria andOnlynumIsNull() {
            addCriterion("onlyNum is null");
            return (Criteria) this;
        }

        public Criteria andOnlynumIsNotNull() {
            addCriterion("onlyNum is not null");
            return (Criteria) this;
        }

        public Criteria andOnlynumEqualTo(String value) {
            addCriterion("onlyNum =", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumNotEqualTo(String value) {
            addCriterion("onlyNum <>", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumGreaterThan(String value) {
            addCriterion("onlyNum >", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumGreaterThanOrEqualTo(String value) {
            addCriterion("onlyNum >=", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumLessThan(String value) {
            addCriterion("onlyNum <", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumLessThanOrEqualTo(String value) {
            addCriterion("onlyNum <=", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumLike(String value) {
            addCriterion("onlyNum like", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumNotLike(String value) {
            addCriterion("onlyNum not like", value, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumIn(List<String> values) {
            addCriterion("onlyNum in", values, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumNotIn(List<String> values) {
            addCriterion("onlyNum not in", values, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumBetween(String value1, String value2) {
            addCriterion("onlyNum between", value1, value2, "onlynum");
            return (Criteria) this;
        }

        public Criteria andOnlynumNotBetween(String value1, String value2) {
            addCriterion("onlyNum not between", value1, value2, "onlynum");
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
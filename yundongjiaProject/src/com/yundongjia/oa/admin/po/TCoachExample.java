package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TCoachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCoachExample() {
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

        public Criteria andCoachidIsNull() {
            addCriterion("coachId is null");
            return (Criteria) this;
        }

        public Criteria andCoachidIsNotNull() {
            addCriterion("coachId is not null");
            return (Criteria) this;
        }

        public Criteria andCoachidEqualTo(Integer value) {
            addCriterion("coachId =", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotEqualTo(Integer value) {
            addCriterion("coachId <>", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThan(Integer value) {
            addCriterion("coachId >", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coachId >=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThan(Integer value) {
            addCriterion("coachId <", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThanOrEqualTo(Integer value) {
            addCriterion("coachId <=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidIn(List<Integer> values) {
            addCriterion("coachId in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotIn(List<Integer> values) {
            addCriterion("coachId not in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidBetween(Integer value1, Integer value2) {
            addCriterion("coachId between", value1, value2, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotBetween(Integer value1, Integer value2) {
            addCriterion("coachId not between", value1, value2, "coachid");
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

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
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

        public Criteria andHeightEqualTo(Double value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Double value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Double value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Double value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Double value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Double value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Double> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Double> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Double value1, Double value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Double value1, Double value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andCoursepriceIsNull() {
            addCriterion("coursePrice is null");
            return (Criteria) this;
        }

        public Criteria andCoursepriceIsNotNull() {
            addCriterion("coursePrice is not null");
            return (Criteria) this;
        }

        public Criteria andCoursepriceEqualTo(Double value) {
            addCriterion("coursePrice =", value, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceNotEqualTo(Double value) {
            addCriterion("coursePrice <>", value, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceGreaterThan(Double value) {
            addCriterion("coursePrice >", value, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("coursePrice >=", value, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceLessThan(Double value) {
            addCriterion("coursePrice <", value, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceLessThanOrEqualTo(Double value) {
            addCriterion("coursePrice <=", value, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceIn(List<Double> values) {
            addCriterion("coursePrice in", values, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceNotIn(List<Double> values) {
            addCriterion("coursePrice not in", values, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceBetween(Double value1, Double value2) {
            addCriterion("coursePrice between", value1, value2, "courseprice");
            return (Criteria) this;
        }

        public Criteria andCoursepriceNotBetween(Double value1, Double value2) {
            addCriterion("coursePrice not between", value1, value2, "courseprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceIsNull() {
            addCriterion("singlePrice is null");
            return (Criteria) this;
        }

        public Criteria andSinglepriceIsNotNull() {
            addCriterion("singlePrice is not null");
            return (Criteria) this;
        }

        public Criteria andSinglepriceEqualTo(Double value) {
            addCriterion("singlePrice =", value, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceNotEqualTo(Double value) {
            addCriterion("singlePrice <>", value, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceGreaterThan(Double value) {
            addCriterion("singlePrice >", value, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("singlePrice >=", value, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceLessThan(Double value) {
            addCriterion("singlePrice <", value, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceLessThanOrEqualTo(Double value) {
            addCriterion("singlePrice <=", value, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceIn(List<Double> values) {
            addCriterion("singlePrice in", values, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceNotIn(List<Double> values) {
            addCriterion("singlePrice not in", values, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceBetween(Double value1, Double value2) {
            addCriterion("singlePrice between", value1, value2, "singleprice");
            return (Criteria) this;
        }

        public Criteria andSinglepriceNotBetween(Double value1, Double value2) {
            addCriterion("singlePrice not between", value1, value2, "singleprice");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickName is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickName is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickName =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickName <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickName >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickName >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickName <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickName <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickName like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickName not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickName in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickName not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickName between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickName not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andIscheckedIsNull() {
            addCriterion("isChecked is null");
            return (Criteria) this;
        }

        public Criteria andIscheckedIsNotNull() {
            addCriterion("isChecked is not null");
            return (Criteria) this;
        }

        public Criteria andIscheckedEqualTo(String value) {
            addCriterion("isChecked =", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotEqualTo(String value) {
            addCriterion("isChecked <>", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedGreaterThan(String value) {
            addCriterion("isChecked >", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedGreaterThanOrEqualTo(String value) {
            addCriterion("isChecked >=", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedLessThan(String value) {
            addCriterion("isChecked <", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedLessThanOrEqualTo(String value) {
            addCriterion("isChecked <=", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedLike(String value) {
            addCriterion("isChecked like", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotLike(String value) {
            addCriterion("isChecked not like", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedIn(List<String> values) {
            addCriterion("isChecked in", values, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotIn(List<String> values) {
            addCriterion("isChecked not in", values, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedBetween(String value1, String value2) {
            addCriterion("isChecked between", value1, value2, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotBetween(String value1, String value2) {
            addCriterion("isChecked not between", value1, value2, "ischecked");
            return (Criteria) this;
        }

        public Criteria andWorkageIsNull() {
            addCriterion("workAge is null");
            return (Criteria) this;
        }

        public Criteria andWorkageIsNotNull() {
            addCriterion("workAge is not null");
            return (Criteria) this;
        }

        public Criteria andWorkageEqualTo(String value) {
            addCriterion("workAge =", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageNotEqualTo(String value) {
            addCriterion("workAge <>", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageGreaterThan(String value) {
            addCriterion("workAge >", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageGreaterThanOrEqualTo(String value) {
            addCriterion("workAge >=", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageLessThan(String value) {
            addCriterion("workAge <", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageLessThanOrEqualTo(String value) {
            addCriterion("workAge <=", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageLike(String value) {
            addCriterion("workAge like", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageNotLike(String value) {
            addCriterion("workAge not like", value, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageIn(List<String> values) {
            addCriterion("workAge in", values, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageNotIn(List<String> values) {
            addCriterion("workAge not in", values, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageBetween(String value1, String value2) {
            addCriterion("workAge between", value1, value2, "workage");
            return (Criteria) this;
        }

        public Criteria andWorkageNotBetween(String value1, String value2) {
            addCriterion("workAge not between", value1, value2, "workage");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgstatIsNull() {
            addCriterion("imgStat is null");
            return (Criteria) this;
        }

        public Criteria andImgstatIsNotNull() {
            addCriterion("imgStat is not null");
            return (Criteria) this;
        }

        public Criteria andImgstatEqualTo(Integer value) {
            addCriterion("imgStat =", value, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatNotEqualTo(Integer value) {
            addCriterion("imgStat <>", value, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatGreaterThan(Integer value) {
            addCriterion("imgStat >", value, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatGreaterThanOrEqualTo(Integer value) {
            addCriterion("imgStat >=", value, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatLessThan(Integer value) {
            addCriterion("imgStat <", value, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatLessThanOrEqualTo(Integer value) {
            addCriterion("imgStat <=", value, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatIn(List<Integer> values) {
            addCriterion("imgStat in", values, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatNotIn(List<Integer> values) {
            addCriterion("imgStat not in", values, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatBetween(Integer value1, Integer value2) {
            addCriterion("imgStat between", value1, value2, "imgstat");
            return (Criteria) this;
        }

        public Criteria andImgstatNotBetween(Integer value1, Integer value2) {
            addCriterion("imgStat not between", value1, value2, "imgstat");
            return (Criteria) this;
        }

        public Criteria andAutographIsNull() {
            addCriterion("autograph is null");
            return (Criteria) this;
        }

        public Criteria andAutographIsNotNull() {
            addCriterion("autograph is not null");
            return (Criteria) this;
        }

        public Criteria andAutographEqualTo(String value) {
            addCriterion("autograph =", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotEqualTo(String value) {
            addCriterion("autograph <>", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographGreaterThan(String value) {
            addCriterion("autograph >", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographGreaterThanOrEqualTo(String value) {
            addCriterion("autograph >=", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographLessThan(String value) {
            addCriterion("autograph <", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographLessThanOrEqualTo(String value) {
            addCriterion("autograph <=", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographLike(String value) {
            addCriterion("autograph like", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotLike(String value) {
            addCriterion("autograph not like", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographIn(List<String> values) {
            addCriterion("autograph in", values, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotIn(List<String> values) {
            addCriterion("autograph not in", values, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographBetween(String value1, String value2) {
            addCriterion("autograph between", value1, value2, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotBetween(String value1, String value2) {
            addCriterion("autograph not between", value1, value2, "autograph");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andCanclelimitIsNull() {
            addCriterion("cancleLimit is null");
            return (Criteria) this;
        }

        public Criteria andCanclelimitIsNotNull() {
            addCriterion("cancleLimit is not null");
            return (Criteria) this;
        }

        public Criteria andCanclelimitEqualTo(Integer value) {
            addCriterion("cancleLimit =", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitNotEqualTo(Integer value) {
            addCriterion("cancleLimit <>", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitGreaterThan(Integer value) {
            addCriterion("cancleLimit >", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancleLimit >=", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitLessThan(Integer value) {
            addCriterion("cancleLimit <", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitLessThanOrEqualTo(Integer value) {
            addCriterion("cancleLimit <=", value, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitIn(List<Integer> values) {
            addCriterion("cancleLimit in", values, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitNotIn(List<Integer> values) {
            addCriterion("cancleLimit not in", values, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitBetween(Integer value1, Integer value2) {
            addCriterion("cancleLimit between", value1, value2, "canclelimit");
            return (Criteria) this;
        }

        public Criteria andCanclelimitNotBetween(Integer value1, Integer value2) {
            addCriterion("cancleLimit not between", value1, value2, "canclelimit");
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
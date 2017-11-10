package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TLeagueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLeagueExample() {
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

        public Criteria andLeagueidIsNull() {
            addCriterion("leagueId is null");
            return (Criteria) this;
        }

        public Criteria andLeagueidIsNotNull() {
            addCriterion("leagueId is not null");
            return (Criteria) this;
        }

        public Criteria andLeagueidEqualTo(Integer value) {
            addCriterion("leagueId =", value, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidNotEqualTo(Integer value) {
            addCriterion("leagueId <>", value, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidGreaterThan(Integer value) {
            addCriterion("leagueId >", value, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidGreaterThanOrEqualTo(Integer value) {
            addCriterion("leagueId >=", value, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidLessThan(Integer value) {
            addCriterion("leagueId <", value, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidLessThanOrEqualTo(Integer value) {
            addCriterion("leagueId <=", value, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidIn(List<Integer> values) {
            addCriterion("leagueId in", values, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidNotIn(List<Integer> values) {
            addCriterion("leagueId not in", values, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidBetween(Integer value1, Integer value2) {
            addCriterion("leagueId between", value1, value2, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeagueidNotBetween(Integer value1, Integer value2) {
            addCriterion("leagueId not between", value1, value2, "leagueid");
            return (Criteria) this;
        }

        public Criteria andLeanguenameIsNull() {
            addCriterion("leangueName is null");
            return (Criteria) this;
        }

        public Criteria andLeanguenameIsNotNull() {
            addCriterion("leangueName is not null");
            return (Criteria) this;
        }

        public Criteria andLeanguenameEqualTo(String value) {
            addCriterion("leangueName =", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameNotEqualTo(String value) {
            addCriterion("leangueName <>", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameGreaterThan(String value) {
            addCriterion("leangueName >", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameGreaterThanOrEqualTo(String value) {
            addCriterion("leangueName >=", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameLessThan(String value) {
            addCriterion("leangueName <", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameLessThanOrEqualTo(String value) {
            addCriterion("leangueName <=", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameLike(String value) {
            addCriterion("leangueName like", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameNotLike(String value) {
            addCriterion("leangueName not like", value, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameIn(List<String> values) {
            addCriterion("leangueName in", values, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameNotIn(List<String> values) {
            addCriterion("leangueName not in", values, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameBetween(String value1, String value2) {
            addCriterion("leangueName between", value1, value2, "leanguename");
            return (Criteria) this;
        }

        public Criteria andLeanguenameNotBetween(String value1, String value2) {
            addCriterion("leangueName not between", value1, value2, "leanguename");
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

        public Criteria andDatetimeIsNull() {
            addCriterion("dateTime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("dateTime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(String value) {
            addCriterion("dateTime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(String value) {
            addCriterion("dateTime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(String value) {
            addCriterion("dateTime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("dateTime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(String value) {
            addCriterion("dateTime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(String value) {
            addCriterion("dateTime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLike(String value) {
            addCriterion("dateTime like", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotLike(String value) {
            addCriterion("dateTime not like", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<String> values) {
            addCriterion("dateTime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<String> values) {
            addCriterion("dateTime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(String value1, String value2) {
            addCriterion("dateTime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(String value1, String value2) {
            addCriterion("dateTime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanIsNull() {
            addCriterion("workWeekSpan is null");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanIsNotNull() {
            addCriterion("workWeekSpan is not null");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanEqualTo(String value) {
            addCriterion("workWeekSpan =", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanNotEqualTo(String value) {
            addCriterion("workWeekSpan <>", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanGreaterThan(String value) {
            addCriterion("workWeekSpan >", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanGreaterThanOrEqualTo(String value) {
            addCriterion("workWeekSpan >=", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanLessThan(String value) {
            addCriterion("workWeekSpan <", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanLessThanOrEqualTo(String value) {
            addCriterion("workWeekSpan <=", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanLike(String value) {
            addCriterion("workWeekSpan like", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanNotLike(String value) {
            addCriterion("workWeekSpan not like", value, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanIn(List<String> values) {
            addCriterion("workWeekSpan in", values, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanNotIn(List<String> values) {
            addCriterion("workWeekSpan not in", values, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanBetween(String value1, String value2) {
            addCriterion("workWeekSpan between", value1, value2, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorkweekspanNotBetween(String value1, String value2) {
            addCriterion("workWeekSpan not between", value1, value2, "workweekspan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanIsNull() {
            addCriterion("workTimeSpan is null");
            return (Criteria) this;
        }

        public Criteria andWorktimespanIsNotNull() {
            addCriterion("workTimeSpan is not null");
            return (Criteria) this;
        }

        public Criteria andWorktimespanEqualTo(String value) {
            addCriterion("workTimeSpan =", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanNotEqualTo(String value) {
            addCriterion("workTimeSpan <>", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanGreaterThan(String value) {
            addCriterion("workTimeSpan >", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanGreaterThanOrEqualTo(String value) {
            addCriterion("workTimeSpan >=", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanLessThan(String value) {
            addCriterion("workTimeSpan <", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanLessThanOrEqualTo(String value) {
            addCriterion("workTimeSpan <=", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanLike(String value) {
            addCriterion("workTimeSpan like", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanNotLike(String value) {
            addCriterion("workTimeSpan not like", value, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanIn(List<String> values) {
            addCriterion("workTimeSpan in", values, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanNotIn(List<String> values) {
            addCriterion("workTimeSpan not in", values, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanBetween(String value1, String value2) {
            addCriterion("workTimeSpan between", value1, value2, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andWorktimespanNotBetween(String value1, String value2) {
            addCriterion("workTimeSpan not between", value1, value2, "worktimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanIsNull() {
            addCriterion("restTimeSpan is null");
            return (Criteria) this;
        }

        public Criteria andResttimespanIsNotNull() {
            addCriterion("restTimeSpan is not null");
            return (Criteria) this;
        }

        public Criteria andResttimespanEqualTo(String value) {
            addCriterion("restTimeSpan =", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanNotEqualTo(String value) {
            addCriterion("restTimeSpan <>", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanGreaterThan(String value) {
            addCriterion("restTimeSpan >", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanGreaterThanOrEqualTo(String value) {
            addCriterion("restTimeSpan >=", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanLessThan(String value) {
            addCriterion("restTimeSpan <", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanLessThanOrEqualTo(String value) {
            addCriterion("restTimeSpan <=", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanLike(String value) {
            addCriterion("restTimeSpan like", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanNotLike(String value) {
            addCriterion("restTimeSpan not like", value, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanIn(List<String> values) {
            addCriterion("restTimeSpan in", values, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanNotIn(List<String> values) {
            addCriterion("restTimeSpan not in", values, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanBetween(String value1, String value2) {
            addCriterion("restTimeSpan between", value1, value2, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andResttimespanNotBetween(String value1, String value2) {
            addCriterion("restTimeSpan not between", value1, value2, "resttimespan");
            return (Criteria) this;
        }

        public Criteria andHourIsNull() {
            addCriterion("hour is null");
            return (Criteria) this;
        }

        public Criteria andHourIsNotNull() {
            addCriterion("hour is not null");
            return (Criteria) this;
        }

        public Criteria andHourEqualTo(Integer value) {
            addCriterion("hour =", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotEqualTo(Integer value) {
            addCriterion("hour <>", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThan(Integer value) {
            addCriterion("hour >", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("hour >=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThan(Integer value) {
            addCriterion("hour <", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThanOrEqualTo(Integer value) {
            addCriterion("hour <=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourIn(List<Integer> values) {
            addCriterion("hour in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotIn(List<Integer> values) {
            addCriterion("hour not in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourBetween(Integer value1, Integer value2) {
            addCriterion("hour between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotBetween(Integer value1, Integer value2) {
            addCriterion("hour not between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNull() {
            addCriterion("totalPrice is null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNotNull() {
            addCriterion("totalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceEqualTo(Double value) {
            addCriterion("totalPrice =", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotEqualTo(Double value) {
            addCriterion("totalPrice <>", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThan(Double value) {
            addCriterion("totalPrice >", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("totalPrice >=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThan(Double value) {
            addCriterion("totalPrice <", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThanOrEqualTo(Double value) {
            addCriterion("totalPrice <=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIn(List<Double> values) {
            addCriterion("totalPrice in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotIn(List<Double> values) {
            addCriterion("totalPrice not in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceBetween(Double value1, Double value2) {
            addCriterion("totalPrice between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotBetween(Double value1, Double value2) {
            addCriterion("totalPrice not between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andLeaguedescIsNull() {
            addCriterion("leagueDesc is null");
            return (Criteria) this;
        }

        public Criteria andLeaguedescIsNotNull() {
            addCriterion("leagueDesc is not null");
            return (Criteria) this;
        }

        public Criteria andLeaguedescEqualTo(String value) {
            addCriterion("leagueDesc =", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescNotEqualTo(String value) {
            addCriterion("leagueDesc <>", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescGreaterThan(String value) {
            addCriterion("leagueDesc >", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescGreaterThanOrEqualTo(String value) {
            addCriterion("leagueDesc >=", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescLessThan(String value) {
            addCriterion("leagueDesc <", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescLessThanOrEqualTo(String value) {
            addCriterion("leagueDesc <=", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescLike(String value) {
            addCriterion("leagueDesc like", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescNotLike(String value) {
            addCriterion("leagueDesc not like", value, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescIn(List<String> values) {
            addCriterion("leagueDesc in", values, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescNotIn(List<String> values) {
            addCriterion("leagueDesc not in", values, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescBetween(String value1, String value2) {
            addCriterion("leagueDesc between", value1, value2, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andLeaguedescNotBetween(String value1, String value2) {
            addCriterion("leagueDesc not between", value1, value2, "leaguedesc");
            return (Criteria) this;
        }

        public Criteria andMaxmanIsNull() {
            addCriterion("maxMan is null");
            return (Criteria) this;
        }

        public Criteria andMaxmanIsNotNull() {
            addCriterion("maxMan is not null");
            return (Criteria) this;
        }

        public Criteria andMaxmanEqualTo(Integer value) {
            addCriterion("maxMan =", value, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanNotEqualTo(Integer value) {
            addCriterion("maxMan <>", value, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanGreaterThan(Integer value) {
            addCriterion("maxMan >", value, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxMan >=", value, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanLessThan(Integer value) {
            addCriterion("maxMan <", value, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanLessThanOrEqualTo(Integer value) {
            addCriterion("maxMan <=", value, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanIn(List<Integer> values) {
            addCriterion("maxMan in", values, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanNotIn(List<Integer> values) {
            addCriterion("maxMan not in", values, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanBetween(Integer value1, Integer value2) {
            addCriterion("maxMan between", value1, value2, "maxman");
            return (Criteria) this;
        }

        public Criteria andMaxmanNotBetween(Integer value1, Integer value2) {
            addCriterion("maxMan not between", value1, value2, "maxman");
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

        public Criteria andAppointmentmanIsNull() {
            addCriterion("appointmentMan is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanIsNotNull() {
            addCriterion("appointmentMan is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanEqualTo(Integer value) {
            addCriterion("appointmentMan =", value, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanNotEqualTo(Integer value) {
            addCriterion("appointmentMan <>", value, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanGreaterThan(Integer value) {
            addCriterion("appointmentMan >", value, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanGreaterThanOrEqualTo(Integer value) {
            addCriterion("appointmentMan >=", value, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanLessThan(Integer value) {
            addCriterion("appointmentMan <", value, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanLessThanOrEqualTo(Integer value) {
            addCriterion("appointmentMan <=", value, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanIn(List<Integer> values) {
            addCriterion("appointmentMan in", values, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanNotIn(List<Integer> values) {
            addCriterion("appointmentMan not in", values, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanBetween(Integer value1, Integer value2) {
            addCriterion("appointmentMan between", value1, value2, "appointmentman");
            return (Criteria) this;
        }

        public Criteria andAppointmentmanNotBetween(Integer value1, Integer value2) {
            addCriterion("appointmentMan not between", value1, value2, "appointmentman");
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
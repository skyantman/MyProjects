package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TMsgExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TMsgExample() {
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

		public Criteria andVerifyidIsNull() {
			addCriterion("verifyId is null");
			return (Criteria) this;
		}

		public Criteria andVerifyidIsNotNull() {
			addCriterion("verifyId is not null");
			return (Criteria) this;
		}

		public Criteria andVerifyidEqualTo(Integer value) {
			addCriterion("verifyId =", value, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidNotEqualTo(Integer value) {
			addCriterion("verifyId <>", value, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidGreaterThan(Integer value) {
			addCriterion("verifyId >", value, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidGreaterThanOrEqualTo(Integer value) {
			addCriterion("verifyId >=", value, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidLessThan(Integer value) {
			addCriterion("verifyId <", value, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidLessThanOrEqualTo(Integer value) {
			addCriterion("verifyId <=", value, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidIn(List<Integer> values) {
			addCriterion("verifyId in", values, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidNotIn(List<Integer> values) {
			addCriterion("verifyId not in", values, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidBetween(Integer value1, Integer value2) {
			addCriterion("verifyId between", value1, value2, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifyidNotBetween(Integer value1, Integer value2) {
			addCriterion("verifyId not between", value1, value2, "verifyid");
			return (Criteria) this;
		}

		public Criteria andVerifycodeIsNull() {
			addCriterion("verifyCode is null");
			return (Criteria) this;
		}

		public Criteria andVerifycodeIsNotNull() {
			addCriterion("verifyCode is not null");
			return (Criteria) this;
		}

		public Criteria andVerifycodeEqualTo(String value) {
			addCriterion("verifyCode =", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotEqualTo(String value) {
			addCriterion("verifyCode <>", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeGreaterThan(String value) {
			addCriterion("verifyCode >", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeGreaterThanOrEqualTo(String value) {
			addCriterion("verifyCode >=", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeLessThan(String value) {
			addCriterion("verifyCode <", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeLessThanOrEqualTo(String value) {
			addCriterion("verifyCode <=", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeLike(String value) {
			addCriterion("verifyCode like", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotLike(String value) {
			addCriterion("verifyCode not like", value, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeIn(List<String> values) {
			addCriterion("verifyCode in", values, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotIn(List<String> values) {
			addCriterion("verifyCode not in", values, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeBetween(String value1, String value2) {
			addCriterion("verifyCode between", value1, value2, "verifycode");
			return (Criteria) this;
		}

		public Criteria andVerifycodeNotBetween(String value1, String value2) {
			addCriterion("verifyCode not between", value1, value2, "verifycode");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoIsNull() {
			addCriterion("mobilePhoneNo is null");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoIsNotNull() {
			addCriterion("mobilePhoneNo is not null");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoEqualTo(String value) {
			addCriterion("mobilePhoneNo =", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoNotEqualTo(String value) {
			addCriterion("mobilePhoneNo <>", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoGreaterThan(String value) {
			addCriterion("mobilePhoneNo >", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoGreaterThanOrEqualTo(String value) {
			addCriterion("mobilePhoneNo >=", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoLessThan(String value) {
			addCriterion("mobilePhoneNo <", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoLessThanOrEqualTo(String value) {
			addCriterion("mobilePhoneNo <=", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoLike(String value) {
			addCriterion("mobilePhoneNo like", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoNotLike(String value) {
			addCriterion("mobilePhoneNo not like", value, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoIn(List<String> values) {
			addCriterion("mobilePhoneNo in", values, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoNotIn(List<String> values) {
			addCriterion("mobilePhoneNo not in", values, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoBetween(String value1, String value2) {
			addCriterion("mobilePhoneNo between", value1, value2, "mobilephoneno");
			return (Criteria) this;
		}

		public Criteria andMobilephonenoNotBetween(String value1, String value2) {
			addCriterion("mobilePhoneNo not between", value1, value2, "mobilephoneno");
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

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
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

		public Criteria andCodetypeIsNull() {
			addCriterion("codeType is null");
			return (Criteria) this;
		}

		public Criteria andCodetypeIsNotNull() {
			addCriterion("codeType is not null");
			return (Criteria) this;
		}

		public Criteria andCodetypeEqualTo(Integer value) {
			addCriterion("codeType =", value, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeNotEqualTo(Integer value) {
			addCriterion("codeType <>", value, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeGreaterThan(Integer value) {
			addCriterion("codeType >", value, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("codeType >=", value, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeLessThan(Integer value) {
			addCriterion("codeType <", value, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeLessThanOrEqualTo(Integer value) {
			addCriterion("codeType <=", value, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeIn(List<Integer> values) {
			addCriterion("codeType in", values, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeNotIn(List<Integer> values) {
			addCriterion("codeType not in", values, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeBetween(Integer value1, Integer value2) {
			addCriterion("codeType between", value1, value2, "codetype");
			return (Criteria) this;
		}

		public Criteria andCodetypeNotBetween(Integer value1, Integer value2) {
			addCriterion("codeType not between", value1, value2, "codetype");
			return (Criteria) this;
		}

		public Criteria andFromidIsNull() {
			addCriterion("fromid is null");
			return (Criteria) this;
		}

		public Criteria andFromidIsNotNull() {
			addCriterion("fromid is not null");
			return (Criteria) this;
		}

		public Criteria andFromidEqualTo(Integer value) {
			addCriterion("fromid =", value, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidNotEqualTo(Integer value) {
			addCriterion("fromid <>", value, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidGreaterThan(Integer value) {
			addCriterion("fromid >", value, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidGreaterThanOrEqualTo(Integer value) {
			addCriterion("fromid >=", value, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidLessThan(Integer value) {
			addCriterion("fromid <", value, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidLessThanOrEqualTo(Integer value) {
			addCriterion("fromid <=", value, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidIn(List<Integer> values) {
			addCriterion("fromid in", values, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidNotIn(List<Integer> values) {
			addCriterion("fromid not in", values, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidBetween(Integer value1, Integer value2) {
			addCriterion("fromid between", value1, value2, "fromid");
			return (Criteria) this;
		}

		public Criteria andFromidNotBetween(Integer value1, Integer value2) {
			addCriterion("fromid not between", value1, value2, "fromid");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
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
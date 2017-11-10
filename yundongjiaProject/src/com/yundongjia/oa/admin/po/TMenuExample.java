package com.yundongjia.oa.admin.po;

import java.util.ArrayList;
import java.util.List;

public class TMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuStatusIsNull() {
            addCriterion("menu_status is null");
            return (Criteria) this;
        }

        public Criteria andMenuStatusIsNotNull() {
            addCriterion("menu_status is not null");
            return (Criteria) this;
        }

        public Criteria andMenuStatusEqualTo(String value) {
            addCriterion("menu_status =", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusNotEqualTo(String value) {
            addCriterion("menu_status <>", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusGreaterThan(String value) {
            addCriterion("menu_status >", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusGreaterThanOrEqualTo(String value) {
            addCriterion("menu_status >=", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusLessThan(String value) {
            addCriterion("menu_status <", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusLessThanOrEqualTo(String value) {
            addCriterion("menu_status <=", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusLike(String value) {
            addCriterion("menu_status like", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusNotLike(String value) {
            addCriterion("menu_status not like", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusIn(List<String> values) {
            addCriterion("menu_status in", values, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusNotIn(List<String> values) {
            addCriterion("menu_status not in", values, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusBetween(String value1, String value2) {
            addCriterion("menu_status between", value1, value2, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusNotBetween(String value1, String value2) {
            addCriterion("menu_status not between", value1, value2, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuPidIsNull() {
            addCriterion("menu_pid is null");
            return (Criteria) this;
        }

        public Criteria andMenuPidIsNotNull() {
            addCriterion("menu_pid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPidEqualTo(String value) {
            addCriterion("menu_pid =", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotEqualTo(String value) {
            addCriterion("menu_pid <>", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidGreaterThan(String value) {
            addCriterion("menu_pid >", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidGreaterThanOrEqualTo(String value) {
            addCriterion("menu_pid >=", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLessThan(String value) {
            addCriterion("menu_pid <", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLessThanOrEqualTo(String value) {
            addCriterion("menu_pid <=", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLike(String value) {
            addCriterion("menu_pid like", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotLike(String value) {
            addCriterion("menu_pid not like", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidIn(List<String> values) {
            addCriterion("menu_pid in", values, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotIn(List<String> values) {
            addCriterion("menu_pid not in", values, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidBetween(String value1, String value2) {
            addCriterion("menu_pid between", value1, value2, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotBetween(String value1, String value2) {
            addCriterion("menu_pid not between", value1, value2, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumIsNull() {
            addCriterion("menu_ordernum is null");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumIsNotNull() {
            addCriterion("menu_ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumEqualTo(Integer value) {
            addCriterion("menu_ordernum =", value, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumNotEqualTo(Integer value) {
            addCriterion("menu_ordernum <>", value, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumGreaterThan(Integer value) {
            addCriterion("menu_ordernum >", value, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_ordernum >=", value, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumLessThan(Integer value) {
            addCriterion("menu_ordernum <", value, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("menu_ordernum <=", value, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumIn(List<Integer> values) {
            addCriterion("menu_ordernum in", values, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumNotIn(List<Integer> values) {
            addCriterion("menu_ordernum not in", values, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("menu_ordernum between", value1, value2, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_ordernum not between", value1, value2, "menuOrdernum");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowIsNull() {
            addCriterion("menu_isshow is null");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowIsNotNull() {
            addCriterion("menu_isshow is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowEqualTo(Byte value) {
            addCriterion("menu_isshow =", value, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowNotEqualTo(Byte value) {
            addCriterion("menu_isshow <>", value, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowGreaterThan(Byte value) {
            addCriterion("menu_isshow >", value, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowGreaterThanOrEqualTo(Byte value) {
            addCriterion("menu_isshow >=", value, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowLessThan(Byte value) {
            addCriterion("menu_isshow <", value, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowLessThanOrEqualTo(Byte value) {
            addCriterion("menu_isshow <=", value, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowIn(List<Byte> values) {
            addCriterion("menu_isshow in", values, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowNotIn(List<Byte> values) {
            addCriterion("menu_isshow not in", values, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowBetween(Byte value1, Byte value2) {
            addCriterion("menu_isshow between", value1, value2, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuIsshowNotBetween(Byte value1, Byte value2) {
            addCriterion("menu_isshow not between", value1, value2, "menuIsshow");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameIsNull() {
            addCriterion("menu_pathname is null");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameIsNotNull() {
            addCriterion("menu_pathname is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameEqualTo(String value) {
            addCriterion("menu_pathname =", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameNotEqualTo(String value) {
            addCriterion("menu_pathname <>", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameGreaterThan(String value) {
            addCriterion("menu_pathname >", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_pathname >=", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameLessThan(String value) {
            addCriterion("menu_pathname <", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameLessThanOrEqualTo(String value) {
            addCriterion("menu_pathname <=", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameLike(String value) {
            addCriterion("menu_pathname like", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameNotLike(String value) {
            addCriterion("menu_pathname not like", value, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameIn(List<String> values) {
            addCriterion("menu_pathname in", values, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameNotIn(List<String> values) {
            addCriterion("menu_pathname not in", values, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameBetween(String value1, String value2) {
            addCriterion("menu_pathname between", value1, value2, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuPathnameNotBetween(String value1, String value2) {
            addCriterion("menu_pathname not between", value1, value2, "menuPathname");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootIsNull() {
            addCriterion("menu_isroot is null");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootIsNotNull() {
            addCriterion("menu_isroot is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootEqualTo(Byte value) {
            addCriterion("menu_isroot =", value, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootNotEqualTo(Byte value) {
            addCriterion("menu_isroot <>", value, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootGreaterThan(Byte value) {
            addCriterion("menu_isroot >", value, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootGreaterThanOrEqualTo(Byte value) {
            addCriterion("menu_isroot >=", value, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootLessThan(Byte value) {
            addCriterion("menu_isroot <", value, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootLessThanOrEqualTo(Byte value) {
            addCriterion("menu_isroot <=", value, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootIn(List<Byte> values) {
            addCriterion("menu_isroot in", values, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootNotIn(List<Byte> values) {
            addCriterion("menu_isroot not in", values, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootBetween(Byte value1, Byte value2) {
            addCriterion("menu_isroot between", value1, value2, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsrootNotBetween(Byte value1, Byte value2) {
            addCriterion("menu_isroot not between", value1, value2, "menuIsroot");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelIsNull() {
            addCriterion("menu_isdel is null");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelIsNotNull() {
            addCriterion("menu_isdel is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelEqualTo(Byte value) {
            addCriterion("menu_isdel =", value, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelNotEqualTo(Byte value) {
            addCriterion("menu_isdel <>", value, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelGreaterThan(Byte value) {
            addCriterion("menu_isdel >", value, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelGreaterThanOrEqualTo(Byte value) {
            addCriterion("menu_isdel >=", value, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelLessThan(Byte value) {
            addCriterion("menu_isdel <", value, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelLessThanOrEqualTo(Byte value) {
            addCriterion("menu_isdel <=", value, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelIn(List<Byte> values) {
            addCriterion("menu_isdel in", values, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelNotIn(List<Byte> values) {
            addCriterion("menu_isdel not in", values, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelBetween(Byte value1, Byte value2) {
            addCriterion("menu_isdel between", value1, value2, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuIsdelNotBetween(Byte value1, Byte value2) {
            addCriterion("menu_isdel not between", value1, value2, "menuIsdel");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridIsNull() {
            addCriterion("menu_powerid is null");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridIsNotNull() {
            addCriterion("menu_powerid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridEqualTo(String value) {
            addCriterion("menu_powerid =", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridNotEqualTo(String value) {
            addCriterion("menu_powerid <>", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridGreaterThan(String value) {
            addCriterion("menu_powerid >", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridGreaterThanOrEqualTo(String value) {
            addCriterion("menu_powerid >=", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridLessThan(String value) {
            addCriterion("menu_powerid <", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridLessThanOrEqualTo(String value) {
            addCriterion("menu_powerid <=", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridLike(String value) {
            addCriterion("menu_powerid like", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridNotLike(String value) {
            addCriterion("menu_powerid not like", value, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridIn(List<String> values) {
            addCriterion("menu_powerid in", values, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridNotIn(List<String> values) {
            addCriterion("menu_powerid not in", values, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridBetween(String value1, String value2) {
            addCriterion("menu_powerid between", value1, value2, "menuPowerid");
            return (Criteria) this;
        }

        public Criteria andMenuPoweridNotBetween(String value1, String value2) {
            addCriterion("menu_powerid not between", value1, value2, "menuPowerid");
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
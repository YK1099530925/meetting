package com.yk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeettingInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeettingInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMeettingidIsNull() {
            addCriterion("meettingId is null");
            return (Criteria) this;
        }

        public Criteria andMeettingidIsNotNull() {
            addCriterion("meettingId is not null");
            return (Criteria) this;
        }

        public Criteria andMeettingidEqualTo(Integer value) {
            addCriterion("meettingId =", value, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidNotEqualTo(Integer value) {
            addCriterion("meettingId <>", value, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidGreaterThan(Integer value) {
            addCriterion("meettingId >", value, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("meettingId >=", value, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidLessThan(Integer value) {
            addCriterion("meettingId <", value, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidLessThanOrEqualTo(Integer value) {
            addCriterion("meettingId <=", value, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidIn(List<Integer> values) {
            addCriterion("meettingId in", values, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidNotIn(List<Integer> values) {
            addCriterion("meettingId not in", values, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidBetween(Integer value1, Integer value2) {
            addCriterion("meettingId between", value1, value2, "meettingid");
            return (Criteria) this;
        }

        public Criteria andMeettingidNotBetween(Integer value1, Integer value2) {
            addCriterion("meettingId not between", value1, value2, "meettingid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andProfileIsNull() {
            addCriterion("profile is null");
            return (Criteria) this;
        }

        public Criteria andProfileIsNotNull() {
            addCriterion("profile is not null");
            return (Criteria) this;
        }

        public Criteria andProfileEqualTo(String value) {
            addCriterion("profile =", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotEqualTo(String value) {
            addCriterion("profile <>", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThan(String value) {
            addCriterion("profile >", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThanOrEqualTo(String value) {
            addCriterion("profile >=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThan(String value) {
            addCriterion("profile <", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThanOrEqualTo(String value) {
            addCriterion("profile <=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLike(String value) {
            addCriterion("profile like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotLike(String value) {
            addCriterion("profile not like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileIn(List<String> values) {
            addCriterion("profile in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotIn(List<String> values) {
            addCriterion("profile not in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileBetween(String value1, String value2) {
            addCriterion("profile between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotBetween(String value1, String value2) {
            addCriterion("profile not between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeIsNull() {
            addCriterion("meettingTime is null");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeIsNotNull() {
            addCriterion("meettingTime is not null");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeEqualTo(Date value) {
            addCriterion("meettingTime =", value, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeNotEqualTo(Date value) {
            addCriterion("meettingTime <>", value, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeGreaterThan(Date value) {
            addCriterion("meettingTime >", value, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meettingTime >=", value, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeLessThan(Date value) {
            addCriterion("meettingTime <", value, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeLessThanOrEqualTo(Date value) {
            addCriterion("meettingTime <=", value, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeIn(List<Date> values) {
            addCriterion("meettingTime in", values, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeNotIn(List<Date> values) {
            addCriterion("meettingTime not in", values, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeBetween(Date value1, Date value2) {
            addCriterion("meettingTime between", value1, value2, "meettingtime");
            return (Criteria) this;
        }

        public Criteria andMeettingtimeNotBetween(Date value1, Date value2) {
            addCriterion("meettingTime not between", value1, value2, "meettingtime");
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

        public Criteria andInfomationIsNull() {
            addCriterion("infomation is null");
            return (Criteria) this;
        }

        public Criteria andInfomationIsNotNull() {
            addCriterion("infomation is not null");
            return (Criteria) this;
        }

        public Criteria andInfomationEqualTo(String value) {
            addCriterion("infomation =", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationNotEqualTo(String value) {
            addCriterion("infomation <>", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationGreaterThan(String value) {
            addCriterion("infomation >", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationGreaterThanOrEqualTo(String value) {
            addCriterion("infomation >=", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationLessThan(String value) {
            addCriterion("infomation <", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationLessThanOrEqualTo(String value) {
            addCriterion("infomation <=", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationLike(String value) {
            addCriterion("infomation like", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationNotLike(String value) {
            addCriterion("infomation not like", value, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationIn(List<String> values) {
            addCriterion("infomation in", values, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationNotIn(List<String> values) {
            addCriterion("infomation not in", values, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationBetween(String value1, String value2) {
            addCriterion("infomation between", value1, value2, "infomation");
            return (Criteria) this;
        }

        public Criteria andInfomationNotBetween(String value1, String value2) {
            addCriterion("infomation not between", value1, value2, "infomation");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNull() {
            addCriterion("deptId is null");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNotNull() {
            addCriterion("deptId is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidEqualTo(Integer value) {
            addCriterion("deptId =", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotEqualTo(Integer value) {
            addCriterion("deptId <>", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThan(Integer value) {
            addCriterion("deptId >", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("deptId >=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThan(Integer value) {
            addCriterion("deptId <", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThanOrEqualTo(Integer value) {
            addCriterion("deptId <=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidIn(List<Integer> values) {
            addCriterion("deptId in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotIn(List<Integer> values) {
            addCriterion("deptId not in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidBetween(Integer value1, Integer value2) {
            addCriterion("deptId between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotBetween(Integer value1, Integer value2) {
            addCriterion("deptId not between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andReleaseuserIsNull() {
            addCriterion("releaseUser is null");
            return (Criteria) this;
        }

        public Criteria andReleaseuserIsNotNull() {
            addCriterion("releaseUser is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseuserEqualTo(String value) {
            addCriterion("releaseUser =", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserNotEqualTo(String value) {
            addCriterion("releaseUser <>", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserGreaterThan(String value) {
            addCriterion("releaseUser >", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserGreaterThanOrEqualTo(String value) {
            addCriterion("releaseUser >=", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserLessThan(String value) {
            addCriterion("releaseUser <", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserLessThanOrEqualTo(String value) {
            addCriterion("releaseUser <=", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserLike(String value) {
            addCriterion("releaseUser like", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserNotLike(String value) {
            addCriterion("releaseUser not like", value, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserIn(List<String> values) {
            addCriterion("releaseUser in", values, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserNotIn(List<String> values) {
            addCriterion("releaseUser not in", values, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserBetween(String value1, String value2) {
            addCriterion("releaseUser between", value1, value2, "releaseuser");
            return (Criteria) this;
        }

        public Criteria andReleaseuserNotBetween(String value1, String value2) {
            addCriterion("releaseUser not between", value1, value2, "releaseuser");
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
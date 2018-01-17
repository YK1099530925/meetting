package com.yk.pojo;

import java.util.ArrayList;
import java.util.List;

public class AskMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AskMessageExample() {
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

        public Criteria andAskuseridIsNull() {
            addCriterion("askUserId is null");
            return (Criteria) this;
        }

        public Criteria andAskuseridIsNotNull() {
            addCriterion("askUserId is not null");
            return (Criteria) this;
        }

        public Criteria andAskuseridEqualTo(Integer value) {
            addCriterion("askUserId =", value, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridNotEqualTo(Integer value) {
            addCriterion("askUserId <>", value, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridGreaterThan(Integer value) {
            addCriterion("askUserId >", value, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("askUserId >=", value, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridLessThan(Integer value) {
            addCriterion("askUserId <", value, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridLessThanOrEqualTo(Integer value) {
            addCriterion("askUserId <=", value, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridIn(List<Integer> values) {
            addCriterion("askUserId in", values, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridNotIn(List<Integer> values) {
            addCriterion("askUserId not in", values, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridBetween(Integer value1, Integer value2) {
            addCriterion("askUserId between", value1, value2, "askuserid");
            return (Criteria) this;
        }

        public Criteria andAskuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("askUserId not between", value1, value2, "askuserid");
            return (Criteria) this;
        }

        public Criteria andManageridIsNull() {
            addCriterion("managerId is null");
            return (Criteria) this;
        }

        public Criteria andManageridIsNotNull() {
            addCriterion("managerId is not null");
            return (Criteria) this;
        }

        public Criteria andManageridEqualTo(Integer value) {
            addCriterion("managerId =", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotEqualTo(Integer value) {
            addCriterion("managerId <>", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThan(Integer value) {
            addCriterion("managerId >", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerId >=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThan(Integer value) {
            addCriterion("managerId <", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThanOrEqualTo(Integer value) {
            addCriterion("managerId <=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridIn(List<Integer> values) {
            addCriterion("managerId in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotIn(List<Integer> values) {
            addCriterion("managerId not in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridBetween(Integer value1, Integer value2) {
            addCriterion("managerId between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotBetween(Integer value1, Integer value2) {
            addCriterion("managerId not between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andManagerflagIsNull() {
            addCriterion("managerFlag is null");
            return (Criteria) this;
        }

        public Criteria andManagerflagIsNotNull() {
            addCriterion("managerFlag is not null");
            return (Criteria) this;
        }

        public Criteria andManagerflagEqualTo(Integer value) {
            addCriterion("managerFlag =", value, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagNotEqualTo(Integer value) {
            addCriterion("managerFlag <>", value, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagGreaterThan(Integer value) {
            addCriterion("managerFlag >", value, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerFlag >=", value, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagLessThan(Integer value) {
            addCriterion("managerFlag <", value, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagLessThanOrEqualTo(Integer value) {
            addCriterion("managerFlag <=", value, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagIn(List<Integer> values) {
            addCriterion("managerFlag in", values, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagNotIn(List<Integer> values) {
            addCriterion("managerFlag not in", values, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagBetween(Integer value1, Integer value2) {
            addCriterion("managerFlag between", value1, value2, "managerflag");
            return (Criteria) this;
        }

        public Criteria andManagerflagNotBetween(Integer value1, Integer value2) {
            addCriterion("managerFlag not between", value1, value2, "managerflag");
            return (Criteria) this;
        }

        public Criteria andUserflagIsNull() {
            addCriterion("userFlag is null");
            return (Criteria) this;
        }

        public Criteria andUserflagIsNotNull() {
            addCriterion("userFlag is not null");
            return (Criteria) this;
        }

        public Criteria andUserflagEqualTo(Integer value) {
            addCriterion("userFlag =", value, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagNotEqualTo(Integer value) {
            addCriterion("userFlag <>", value, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagGreaterThan(Integer value) {
            addCriterion("userFlag >", value, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("userFlag >=", value, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagLessThan(Integer value) {
            addCriterion("userFlag <", value, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagLessThanOrEqualTo(Integer value) {
            addCriterion("userFlag <=", value, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagIn(List<Integer> values) {
            addCriterion("userFlag in", values, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagNotIn(List<Integer> values) {
            addCriterion("userFlag not in", values, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagBetween(Integer value1, Integer value2) {
            addCriterion("userFlag between", value1, value2, "userflag");
            return (Criteria) this;
        }

        public Criteria andUserflagNotBetween(Integer value1, Integer value2) {
            addCriterion("userFlag not between", value1, value2, "userflag");
            return (Criteria) this;
        }

        public Criteria andAgreeIsNull() {
            addCriterion("agree is null");
            return (Criteria) this;
        }

        public Criteria andAgreeIsNotNull() {
            addCriterion("agree is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeEqualTo(Integer value) {
            addCriterion("agree =", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotEqualTo(Integer value) {
            addCriterion("agree <>", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThan(Integer value) {
            addCriterion("agree >", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("agree >=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThan(Integer value) {
            addCriterion("agree <", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThanOrEqualTo(Integer value) {
            addCriterion("agree <=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeIn(List<Integer> values) {
            addCriterion("agree in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotIn(List<Integer> values) {
            addCriterion("agree not in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeBetween(Integer value1, Integer value2) {
            addCriterion("agree between", value1, value2, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotBetween(Integer value1, Integer value2) {
            addCriterion("agree not between", value1, value2, "agree");
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

        public Criteria andAskusernameIsNull() {
            addCriterion("askUserName is null");
            return (Criteria) this;
        }

        public Criteria andAskusernameIsNotNull() {
            addCriterion("askUserName is not null");
            return (Criteria) this;
        }

        public Criteria andAskusernameEqualTo(String value) {
            addCriterion("askUserName =", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameNotEqualTo(String value) {
            addCriterion("askUserName <>", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameGreaterThan(String value) {
            addCriterion("askUserName >", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameGreaterThanOrEqualTo(String value) {
            addCriterion("askUserName >=", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameLessThan(String value) {
            addCriterion("askUserName <", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameLessThanOrEqualTo(String value) {
            addCriterion("askUserName <=", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameLike(String value) {
            addCriterion("askUserName like", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameNotLike(String value) {
            addCriterion("askUserName not like", value, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameIn(List<String> values) {
            addCriterion("askUserName in", values, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameNotIn(List<String> values) {
            addCriterion("askUserName not in", values, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameBetween(String value1, String value2) {
            addCriterion("askUserName between", value1, value2, "askusername");
            return (Criteria) this;
        }

        public Criteria andAskusernameNotBetween(String value1, String value2) {
            addCriterion("askUserName not between", value1, value2, "askusername");
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
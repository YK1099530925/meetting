package com.yk.pojo;

import java.util.ArrayList;
import java.util.List;

public class MeettingRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeettingRoomExample() {
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

        public Criteria andSeat0IsNull() {
            addCriterion("seat0 is null");
            return (Criteria) this;
        }

        public Criteria andSeat0IsNotNull() {
            addCriterion("seat0 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat0EqualTo(Integer value) {
            addCriterion("seat0 =", value, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0NotEqualTo(Integer value) {
            addCriterion("seat0 <>", value, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0GreaterThan(Integer value) {
            addCriterion("seat0 >", value, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat0 >=", value, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0LessThan(Integer value) {
            addCriterion("seat0 <", value, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0LessThanOrEqualTo(Integer value) {
            addCriterion("seat0 <=", value, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0In(List<Integer> values) {
            addCriterion("seat0 in", values, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0NotIn(List<Integer> values) {
            addCriterion("seat0 not in", values, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0Between(Integer value1, Integer value2) {
            addCriterion("seat0 between", value1, value2, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat0NotBetween(Integer value1, Integer value2) {
            addCriterion("seat0 not between", value1, value2, "seat0");
            return (Criteria) this;
        }

        public Criteria andSeat1IsNull() {
            addCriterion("seat1 is null");
            return (Criteria) this;
        }

        public Criteria andSeat1IsNotNull() {
            addCriterion("seat1 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat1EqualTo(Integer value) {
            addCriterion("seat1 =", value, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1NotEqualTo(Integer value) {
            addCriterion("seat1 <>", value, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1GreaterThan(Integer value) {
            addCriterion("seat1 >", value, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat1 >=", value, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1LessThan(Integer value) {
            addCriterion("seat1 <", value, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1LessThanOrEqualTo(Integer value) {
            addCriterion("seat1 <=", value, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1In(List<Integer> values) {
            addCriterion("seat1 in", values, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1NotIn(List<Integer> values) {
            addCriterion("seat1 not in", values, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1Between(Integer value1, Integer value2) {
            addCriterion("seat1 between", value1, value2, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat1NotBetween(Integer value1, Integer value2) {
            addCriterion("seat1 not between", value1, value2, "seat1");
            return (Criteria) this;
        }

        public Criteria andSeat2IsNull() {
            addCriterion("seat2 is null");
            return (Criteria) this;
        }

        public Criteria andSeat2IsNotNull() {
            addCriterion("seat2 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat2EqualTo(Integer value) {
            addCriterion("seat2 =", value, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2NotEqualTo(Integer value) {
            addCriterion("seat2 <>", value, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2GreaterThan(Integer value) {
            addCriterion("seat2 >", value, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat2 >=", value, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2LessThan(Integer value) {
            addCriterion("seat2 <", value, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2LessThanOrEqualTo(Integer value) {
            addCriterion("seat2 <=", value, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2In(List<Integer> values) {
            addCriterion("seat2 in", values, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2NotIn(List<Integer> values) {
            addCriterion("seat2 not in", values, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2Between(Integer value1, Integer value2) {
            addCriterion("seat2 between", value1, value2, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat2NotBetween(Integer value1, Integer value2) {
            addCriterion("seat2 not between", value1, value2, "seat2");
            return (Criteria) this;
        }

        public Criteria andSeat3IsNull() {
            addCriterion("seat3 is null");
            return (Criteria) this;
        }

        public Criteria andSeat3IsNotNull() {
            addCriterion("seat3 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat3EqualTo(Integer value) {
            addCriterion("seat3 =", value, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3NotEqualTo(Integer value) {
            addCriterion("seat3 <>", value, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3GreaterThan(Integer value) {
            addCriterion("seat3 >", value, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat3 >=", value, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3LessThan(Integer value) {
            addCriterion("seat3 <", value, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3LessThanOrEqualTo(Integer value) {
            addCriterion("seat3 <=", value, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3In(List<Integer> values) {
            addCriterion("seat3 in", values, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3NotIn(List<Integer> values) {
            addCriterion("seat3 not in", values, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3Between(Integer value1, Integer value2) {
            addCriterion("seat3 between", value1, value2, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat3NotBetween(Integer value1, Integer value2) {
            addCriterion("seat3 not between", value1, value2, "seat3");
            return (Criteria) this;
        }

        public Criteria andSeat4IsNull() {
            addCriterion("seat4 is null");
            return (Criteria) this;
        }

        public Criteria andSeat4IsNotNull() {
            addCriterion("seat4 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat4EqualTo(Integer value) {
            addCriterion("seat4 =", value, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4NotEqualTo(Integer value) {
            addCriterion("seat4 <>", value, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4GreaterThan(Integer value) {
            addCriterion("seat4 >", value, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat4 >=", value, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4LessThan(Integer value) {
            addCriterion("seat4 <", value, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4LessThanOrEqualTo(Integer value) {
            addCriterion("seat4 <=", value, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4In(List<Integer> values) {
            addCriterion("seat4 in", values, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4NotIn(List<Integer> values) {
            addCriterion("seat4 not in", values, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4Between(Integer value1, Integer value2) {
            addCriterion("seat4 between", value1, value2, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat4NotBetween(Integer value1, Integer value2) {
            addCriterion("seat4 not between", value1, value2, "seat4");
            return (Criteria) this;
        }

        public Criteria andSeat5IsNull() {
            addCriterion("seat5 is null");
            return (Criteria) this;
        }

        public Criteria andSeat5IsNotNull() {
            addCriterion("seat5 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat5EqualTo(Integer value) {
            addCriterion("seat5 =", value, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5NotEqualTo(Integer value) {
            addCriterion("seat5 <>", value, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5GreaterThan(Integer value) {
            addCriterion("seat5 >", value, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat5 >=", value, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5LessThan(Integer value) {
            addCriterion("seat5 <", value, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5LessThanOrEqualTo(Integer value) {
            addCriterion("seat5 <=", value, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5In(List<Integer> values) {
            addCriterion("seat5 in", values, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5NotIn(List<Integer> values) {
            addCriterion("seat5 not in", values, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5Between(Integer value1, Integer value2) {
            addCriterion("seat5 between", value1, value2, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat5NotBetween(Integer value1, Integer value2) {
            addCriterion("seat5 not between", value1, value2, "seat5");
            return (Criteria) this;
        }

        public Criteria andSeat6IsNull() {
            addCriterion("seat6 is null");
            return (Criteria) this;
        }

        public Criteria andSeat6IsNotNull() {
            addCriterion("seat6 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat6EqualTo(Integer value) {
            addCriterion("seat6 =", value, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6NotEqualTo(Integer value) {
            addCriterion("seat6 <>", value, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6GreaterThan(Integer value) {
            addCriterion("seat6 >", value, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat6 >=", value, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6LessThan(Integer value) {
            addCriterion("seat6 <", value, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6LessThanOrEqualTo(Integer value) {
            addCriterion("seat6 <=", value, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6In(List<Integer> values) {
            addCriterion("seat6 in", values, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6NotIn(List<Integer> values) {
            addCriterion("seat6 not in", values, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6Between(Integer value1, Integer value2) {
            addCriterion("seat6 between", value1, value2, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat6NotBetween(Integer value1, Integer value2) {
            addCriterion("seat6 not between", value1, value2, "seat6");
            return (Criteria) this;
        }

        public Criteria andSeat7IsNull() {
            addCriterion("seat7 is null");
            return (Criteria) this;
        }

        public Criteria andSeat7IsNotNull() {
            addCriterion("seat7 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat7EqualTo(Integer value) {
            addCriterion("seat7 =", value, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7NotEqualTo(Integer value) {
            addCriterion("seat7 <>", value, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7GreaterThan(Integer value) {
            addCriterion("seat7 >", value, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat7 >=", value, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7LessThan(Integer value) {
            addCriterion("seat7 <", value, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7LessThanOrEqualTo(Integer value) {
            addCriterion("seat7 <=", value, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7In(List<Integer> values) {
            addCriterion("seat7 in", values, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7NotIn(List<Integer> values) {
            addCriterion("seat7 not in", values, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7Between(Integer value1, Integer value2) {
            addCriterion("seat7 between", value1, value2, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat7NotBetween(Integer value1, Integer value2) {
            addCriterion("seat7 not between", value1, value2, "seat7");
            return (Criteria) this;
        }

        public Criteria andSeat8IsNull() {
            addCriterion("seat8 is null");
            return (Criteria) this;
        }

        public Criteria andSeat8IsNotNull() {
            addCriterion("seat8 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat8EqualTo(Integer value) {
            addCriterion("seat8 =", value, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8NotEqualTo(Integer value) {
            addCriterion("seat8 <>", value, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8GreaterThan(Integer value) {
            addCriterion("seat8 >", value, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat8 >=", value, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8LessThan(Integer value) {
            addCriterion("seat8 <", value, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8LessThanOrEqualTo(Integer value) {
            addCriterion("seat8 <=", value, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8In(List<Integer> values) {
            addCriterion("seat8 in", values, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8NotIn(List<Integer> values) {
            addCriterion("seat8 not in", values, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8Between(Integer value1, Integer value2) {
            addCriterion("seat8 between", value1, value2, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat8NotBetween(Integer value1, Integer value2) {
            addCriterion("seat8 not between", value1, value2, "seat8");
            return (Criteria) this;
        }

        public Criteria andSeat9IsNull() {
            addCriterion("seat9 is null");
            return (Criteria) this;
        }

        public Criteria andSeat9IsNotNull() {
            addCriterion("seat9 is not null");
            return (Criteria) this;
        }

        public Criteria andSeat9EqualTo(Integer value) {
            addCriterion("seat9 =", value, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9NotEqualTo(Integer value) {
            addCriterion("seat9 <>", value, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9GreaterThan(Integer value) {
            addCriterion("seat9 >", value, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9GreaterThanOrEqualTo(Integer value) {
            addCriterion("seat9 >=", value, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9LessThan(Integer value) {
            addCriterion("seat9 <", value, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9LessThanOrEqualTo(Integer value) {
            addCriterion("seat9 <=", value, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9In(List<Integer> values) {
            addCriterion("seat9 in", values, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9NotIn(List<Integer> values) {
            addCriterion("seat9 not in", values, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9Between(Integer value1, Integer value2) {
            addCriterion("seat9 between", value1, value2, "seat9");
            return (Criteria) this;
        }

        public Criteria andSeat9NotBetween(Integer value1, Integer value2) {
            addCriterion("seat9 not between", value1, value2, "seat9");
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
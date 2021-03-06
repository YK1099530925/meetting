package com.yk.pojo;

import java.util.ArrayList;
import java.util.List;

public class FileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileExample() {
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

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFiledirIsNull() {
            addCriterion("filedir is null");
            return (Criteria) this;
        }

        public Criteria andFiledirIsNotNull() {
            addCriterion("filedir is not null");
            return (Criteria) this;
        }

        public Criteria andFiledirEqualTo(String value) {
            addCriterion("filedir =", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirNotEqualTo(String value) {
            addCriterion("filedir <>", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirGreaterThan(String value) {
            addCriterion("filedir >", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirGreaterThanOrEqualTo(String value) {
            addCriterion("filedir >=", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirLessThan(String value) {
            addCriterion("filedir <", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirLessThanOrEqualTo(String value) {
            addCriterion("filedir <=", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirLike(String value) {
            addCriterion("filedir like", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirNotLike(String value) {
            addCriterion("filedir not like", value, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirIn(List<String> values) {
            addCriterion("filedir in", values, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirNotIn(List<String> values) {
            addCriterion("filedir not in", values, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirBetween(String value1, String value2) {
            addCriterion("filedir between", value1, value2, "filedir");
            return (Criteria) this;
        }

        public Criteria andFiledirNotBetween(String value1, String value2) {
            addCriterion("filedir not between", value1, value2, "filedir");
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
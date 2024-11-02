package io.ooruda.allclimb.module.database.utils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import java.math.BigDecimal;
import java.util.Optional;

public class QueryDslWhereExpressions {

    private QueryDslWhereExpressions() {
        throw new IllegalStateException("Utility class");
    }

    public static BooleanExpression containsIgnoreCase(String value, StringPath field) {
        return Optional.ofNullable(value).map(field::containsIgnoreCase).orElse(null);
    }

    public static <T extends Enum<T>> BooleanExpression equalsEnum(T value, EnumPath<T> field) {
        return Optional.ofNullable(value).map(field::eq).orElse(null);
    }

    public static BooleanExpression equalsInteger(Integer value, NumberPath<Integer> field) {
        return Optional.ofNullable(value).map(field::eq).orElse(null);
    }

    public static BooleanExpression equalsLong(Long value, NumberPath<Long> field) {
        return Optional.ofNullable(value).map(field::eq).orElse(null);
    }

    public static BooleanExpression greaterThan(Integer value, NumberPath<Integer> field) {
        return Optional.ofNullable(value).map(field::gt).orElse(null);
    }

    public static BooleanExpression greaterThan(BigDecimal value, NumberPath<BigDecimal> field) {
        return Optional.ofNullable(value).map(field::gt).orElse(null);
    }

    public static BooleanExpression lessThan(Integer value, NumberPath<Integer> field) {
        return Optional.ofNullable(value).map(field::lt).orElse(null);
    }

    public static BooleanExpression lessThan(BigDecimal value, NumberPath<BigDecimal> field) {
        return Optional.ofNullable(value).map(field::lt).orElse(null);
    }
}

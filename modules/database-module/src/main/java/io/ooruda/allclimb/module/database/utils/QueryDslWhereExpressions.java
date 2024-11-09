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

    public static BooleanExpression containsIgnoreCase(StringPath field, String value) {
        return Optional.ofNullable(value).map(field::containsIgnoreCase).orElse(null);
    }

    public static <T extends Enum<T>> BooleanExpression equalsEnum(EnumPath<T> field, T value) {
        return Optional.ofNullable(value).map(field::eq).orElse(null);
    }

    public static BooleanExpression equalsInteger(NumberPath<Integer> field, Integer value) {
        return Optional.ofNullable(value).map(field::eq).orElse(null);
    }

    public static BooleanExpression equalsLong(NumberPath<Long> field, Long value) {
        return Optional.ofNullable(value).map(field::eq).orElse(null);
    }

    public static BooleanExpression greaterThan(NumberPath<Integer> field, Integer value) {
        return Optional.ofNullable(value).map(field::gt).orElse(null);
    }

    public static BooleanExpression greaterThan(NumberPath<BigDecimal> field, BigDecimal value) {
        return Optional.ofNullable(value).map(field::gt).orElse(null);
    }

    public static BooleanExpression lessThan(NumberPath<Integer> field, Integer value) {
        return Optional.ofNullable(value).map(field::lt).orElse(null);
    }

    public static BooleanExpression lessThan(NumberPath<BigDecimal> field, BigDecimal value) {
        return Optional.ofNullable(value).map(field::lt).orElse(null);
    }
}

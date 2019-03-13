package com.dekopay.util;

import java.util.Objects;

public class NonEmptyString {

    private final String value;

    public NonEmptyString(String value) {
        this(value, "String");
    }

    public NonEmptyString(String value, String name) {
        if (value.length() == 0) {
            throw new IllegalArgumentException(String.format("%s must not be empty", name));
        }

        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonEmptyString that = (NonEmptyString) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

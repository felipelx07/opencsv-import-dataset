package com.softplan.challenge.util;

import lombok.Getter;

@Getter
public class ValidationMessageUtil {

    public static final String CANNOT_BE_NULL_FIELD = "This field cannot be null";
    public static final String CANNOT_BE_NOT_AVAILABLE = "This value cannot be 'Not Available'";
    public static final String CANNOT_HAVE_SPECIAL_CHARACTERS = "This value cannot have special characters";
    public static final String ONLY_NUMBERS = "This value cannot be a string/character";
    public static final String ONLY_DATE = "This value can be only Date";
}

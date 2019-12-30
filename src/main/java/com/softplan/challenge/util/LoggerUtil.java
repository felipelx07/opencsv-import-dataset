package com.softplan.challenge.util;

public class LoggerUtil {

    public static String fieldCannotBeNullErrorLog(String fieldName, String referenceCode) {
        return "(" + fieldName + " :: "
                + ValidationMessageUtil.CANNOT_BE_NULL_FIELD
                + ") - Reference from RA_Record# "
                + referenceCode;
    }

    public static String fieldCannotBeNotAvailable(String fieldName, String referenceCode) {
        return "(" + fieldName + " :: "
                + ValidationMessageUtil.CANNOT_BE_NOT_AVAILABLE
                + ") - Reference from RA_Record# "
                + referenceCode;
    }

    public static String fieldCannotHaveSpecialCharacters(String fieldName, String referenceCode) {
        return "(" + fieldName + " :: "
                + ValidationMessageUtil.CANNOT_HAVE_SPECIAL_CHARACTERS
                + ") - Reference from RA_Record# "
                + referenceCode;
    }

    public static String fieldAcceptOnlyDataErrorLog(String fieldName, String referenceCode) {
        return "(" + fieldName + " :: "
                + ValidationMessageUtil.ONLY_DATE
                + ") - Reference from RA_Record# "
                + referenceCode;
    }

    public static String fieldAcceptOnlyNumbersLog(String fieldName, String referenceCode) {
        return "(" + fieldName + " :: "
                + ValidationMessageUtil.ONLY_NUMBERS
                + ") - Reference from RA_Record# "
                + referenceCode;
    }
}

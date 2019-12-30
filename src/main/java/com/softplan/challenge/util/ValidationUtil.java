package com.softplan.challenge.util;

import com.softplan.challenge.model.Caers;
import com.softplan.challenge.model.Validation;
import org.jboss.logging.Logger;

import java.lang.reflect.Field;
import java.util.List;

public class ValidationUtil {

    private static final Logger log = Logger.getLogger(ValidationUtil.class);

    /*
     * This validate the old value from db and update with the new value
     */
    public static void setValuesFromParam(Validation validation, String columnName, String columnValue) {
        if (columnName.equals("acceptNull"))
            validation.setAcceptNull(!Boolean.parseBoolean(columnValue));
        if (columnName.equals("acceptNotAvailable"))
            validation.setAcceptNotAvailable(!Boolean.parseBoolean(columnValue));
        if (columnName.equals("acceptSpecialCharacters"))
            validation.setAcceptSpecialCharacters(!Boolean.parseBoolean(columnValue));
        if (columnName.equals("onlyNumbers"))
            validation.setOnlyNumbers(!Boolean.parseBoolean(columnValue));
        if (columnName.equals("onlyDate"))
            validation.setOnlyDate(!Boolean.parseBoolean(columnValue));
    }

    /*
     * Main Validator
     */
    public static void validate(List<Caers> caersListFromCSV, List<Validation> validations) {
        caersListFromCSV.forEach(c -> {
            validations.forEach(v -> {
                emptyValueOnFieldValidation(c, v);
                notAvailableValueOnFieldValidation(c, v);
                specialCharactersOnFieldValidation(c, v);
                dateValueOnFieldValidation(c, v);
                numbersOnFieldValidation(c, v);
            });
        });
    }

    /*
     * Condition
     */
    public static boolean emptyValueOnFieldValidation(Caers c, Validation v) {
        if (!v.isAcceptNull()) {
            try {
                Field field = c.getClass().getDeclaredField(v.getField());
                field.setAccessible(true);
                Object value = field.get(c);
                if (value == null || String.valueOf(value).isEmpty()) {
                    log.error(LoggerUtil.fieldCannotBeNullErrorLog(field.getName(), c.getRA_Report()));
                    return true;
                } else return false;
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                ex.printStackTrace();
                return false;
            }
        } else return false;
    }

    /*
     * Condition
     */
    public static boolean notAvailableValueOnFieldValidation(Caers c, Validation v) {
        if (!v.isAcceptNotAvailable()) {
            try {
                Field field = c.getClass().getDeclaredField(v.getField());
                field.setAccessible(true);
                Object value = field.get(c);
                if (value == null || String.valueOf(value).equals("Not Available")) {
                    log.error(LoggerUtil.fieldCannotBeNotAvailable(field.getName(), c.getRA_Report()));
                    return true;
                } else return false;
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                ex.printStackTrace();
                return false;
            }
        } else return false;
    }

    /*
     * Condition
     */
    public static boolean specialCharactersOnFieldValidation(Caers c, Validation v) {
        if (!v.isAcceptSpecialCharacters()) {
            try {
                Field field = c.getClass().getDeclaredField(v.getField());
                field.setAccessible(true);
                String value = field.get(c).toString();
                if (value == null || JavaUtil.haveSpecialCharacters(value)) {
                    log.error(LoggerUtil.fieldCannotHaveSpecialCharacters(field.getName(), c.getRA_Report()));
                    return true;
                } else return false;
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                ex.printStackTrace();
                return false;
            }
        } else return false;
    }

    /*
     * Condition
     */
    public static boolean dateValueOnFieldValidation(Caers c, Validation v) {
        if (v.isOnlyDate()) {
            try {
                Field field = c.getClass().getDeclaredField(v.getField());
                field.setAccessible(true);
                String value = field.get(c).toString();
                if (value == null || !value.matches(RegexUtil.datePattern)) {
                    log.error(LoggerUtil.fieldAcceptOnlyDataErrorLog(field.getName(), c.getRA_Report()));
                    return true;
                } else return false;
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                ex.printStackTrace();
                return false;
            }
        } else return false;
    }

    /*
     * Condition
     */
    public static boolean numbersOnFieldValidation(Caers c, Validation v) {
        if (v.isOnlyNumbers()) {
            try {
                Field field = c.getClass().getDeclaredField(v.getField());
                field.setAccessible(true);
                String value = field.get(c).toString();
                if (value == null || !value.matches(RegexUtil.numbersPattern)) {
                    log.error(LoggerUtil.fieldAcceptOnlyNumbersLog(field.getName(), c.getRA_Report()));
                    return true;
                } else return false;
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                log.fatal(ex.getMessage());
                return false;
            }
        } else return false;
    }
}

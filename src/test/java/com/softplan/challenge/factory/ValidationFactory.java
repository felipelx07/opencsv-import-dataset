package com.softplan.challenge.factory;

import com.softplan.challenge.model.Validation;

public class ValidationFactory {

    public static Validation nullOrEmptyValidate() {
        Validation validation = new Validation();
        validation.setField("RA_Report");
        validation.setAcceptNull(false);
        return validation;
    }

    public static Validation specialCharactersValidate() {
        Validation validation = new Validation();
        validation.setField("RA_Report");
        validation.setAcceptSpecialCharacters(false);
        return validation;
    }

    public static Validation notAvailableValidate() {
        Validation validation = new Validation();
        validation.setField("RA_Report");
        validation.setAcceptNotAvailable(false);
        return validation;
    }

    public static Validation onlyDateValidate() {
        Validation validation = new Validation();
        validation.setField("RA_Report");
        validation.setOnlyDate(true);
        return validation;
    }

    public static Validation onlyNumbersValidate() {
        Validation validation = new Validation();
        validation.setField("RA_Report");
        validation.setOnlyNumbers(true);
        return validation;
    }
}

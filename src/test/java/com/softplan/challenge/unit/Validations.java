package com.softplan.challenge.unit;

import com.softplan.challenge.factory.CaersFactory;
import com.softplan.challenge.factory.ValidationFactory;
import com.softplan.challenge.model.Caers;
import com.softplan.challenge.model.Validation;
import com.softplan.challenge.util.ValidationUtil;
import org.junit.Assert;
import org.junit.Test;

public class Validations {

    /*
     * Check Not Null or Empty Values
     */
    @Test
    public void checkIfHaveEmptyValueOnField() {
        Caers caers = CaersFactory.withEmptyValue();
        Validation validation = ValidationFactory.nullOrEmptyValidate();

        Assert.assertTrue(ValidationUtil.emptyValueOnFieldValidation(caers, validation));
    }

    @Test
    public void checkIfNullOrEmptyValidationIsFine() {
        Caers caers = CaersFactory.withoutEmptyValue();
        Validation validation = ValidationFactory.nullOrEmptyValidate();

        Assert.assertFalse(ValidationUtil.emptyValueOnFieldValidation(caers, validation));
    }

    /*
     * Check Not Available Values
     */
    @Test
    public void checkIfHaveNotAvailableValueOnField() {
        Caers caers = CaersFactory.withNotAvailable();
        Validation validation = ValidationFactory.notAvailableValidate();

        Assert.assertTrue(ValidationUtil.notAvailableValueOnFieldValidation(caers, validation));
    }

    @Test
    public void checkValidationNotAceitableIsFine() {
        Caers caers = CaersFactory.withoutNotAvailableValue();
        Validation validation = ValidationFactory.notAvailableValidate();

        Assert.assertFalse(ValidationUtil.notAvailableValueOnFieldValidation(caers, validation));
    }

    /*
     * Check Special Characters Values
     */
    @Test
    public void checkIfHaveSpecialCharactersValueOnField() {
        Caers caers = CaersFactory.withSpecialCharactersValue();
        Validation validation = ValidationFactory.specialCharactersValidate();

        Assert.assertTrue(ValidationUtil.specialCharactersOnFieldValidation(caers, validation));
    }

    @Test
    public void checkValidationSpecialCharactersIsFine() {
        Caers caers = CaersFactory.withoutSpecialCharactersValue();
        Validation validation = ValidationFactory.specialCharactersValidate();

        Assert.assertFalse(ValidationUtil.specialCharactersOnFieldValidation(caers, validation));
    }

    /*
     * Check Only Date Values
     */
    @Test
    public void checkIfHaveOnlyDateValueOnField() {
        Caers caers = CaersFactory.withoutDateType();
        Validation validation = ValidationFactory.onlyDateValidate();

        Assert.assertTrue(ValidationUtil.dateValueOnFieldValidation(caers, validation));
    }

    @Test
    public void checkValidationOnlyDateIsFine() {
        Caers caers = CaersFactory.withDateType();
        Validation validation = ValidationFactory.onlyDateValidate();

        Assert.assertFalse(ValidationUtil.dateValueOnFieldValidation(caers, validation));
    }

    /*
     * Check Only Numbers Values
     */
    @Test
    public void checkIfHaveOnlyNumbersValueOnField() {
        Caers caers = CaersFactory.withoutNumbers();
        Validation validation = ValidationFactory.onlyNumbersValidate();

        Assert.assertTrue(ValidationUtil.numbersOnFieldValidation(caers, validation));
    }

    @Test
    public void checkValidationOnlyNumbersIsFine() {
        Caers caers = CaersFactory.withNumbers();
        Validation validation = ValidationFactory.onlyNumbersValidate();

        Assert.assertFalse(ValidationUtil.numbersOnFieldValidation(caers, validation));
    }
}

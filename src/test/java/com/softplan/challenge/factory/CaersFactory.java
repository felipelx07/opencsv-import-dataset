package com.softplan.challenge.factory;

import com.softplan.challenge.model.Caers;

public class CaersFactory {

    public static Caers withEmptyValue() {
        Caers caers = new Caers();
        caers.setRA_Report("");
        return caers;
    }

    public static Caers withoutEmptyValue() {
        Caers caers = new Caers();
        caers.setRA_Report("41234");
        return caers;
    }

    public static Caers withNotAvailable() {
        Caers caers = new Caers();
        caers.setRA_Report("Not Available");
        return caers;
    }

    public static Caers withoutNotAvailableValue() {
        Caers caers = new Caers();
        caers.setRA_Report("Available");
        return caers;
    }

    public static Caers withSpecialCharactersValue() {
        Caers caers = new Caers();
        caers.setRA_Report("Tes*%$#t");
        return caers;
    }

    public static Caers withoutSpecialCharactersValue() {
        Caers caers = new Caers();
        caers.setRA_Report("Test");
        return caers;
    }

    public static Caers withDateType() {
        Caers caers = new Caers();
        caers.setRA_Report("1/6/2004");
        return caers;
    }

    public static Caers withoutDateType() {
        Caers caers = new Caers();
        caers.setRA_Report("abcdef123456");
        return caers;
    }


    public static Caers withNumbers() {
        Caers caers = new Caers();
        caers.setRA_Report("31551");
        return caers;
    }

    public static Caers withoutNumbers() {
        Caers caers = new Caers();
        caers.setRA_Report("test");
        return caers;
    }
}

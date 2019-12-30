package com.softplan.challenge.unit;

import com.softplan.challenge.factory.CSVtoJavaBeanFactory;
import com.softplan.challenge.model.Caers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CSVFileToBean {

    @Test
    public void checkNumberOfRecords() {
        List<Caers> caersListFromCSV = CSVtoJavaBeanFactory.list();
        Assert.assertEquals(90786, caersListFromCSV.size());
    }

    //TODO:: Test to check Valid File Type
    //TODO:: Test to check Invalid File Type
}

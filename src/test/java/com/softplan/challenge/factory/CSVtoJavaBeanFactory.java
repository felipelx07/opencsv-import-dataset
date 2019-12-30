package com.softplan.challenge.factory;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.softplan.challenge.model.Caers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVtoJavaBeanFactory {

    public static List<Caers> list() {
        String fileName = "src/main/resources/schema/CAERS_ASCII_2004_2017Q2.csv";

        // Hashmap to map CSV data to Bean attributes.
        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("RA_Report #", "RA_Report");
        mapping.put("RA_CAERS Created Date", "RA_CAERS_Created_Date");
        mapping.put("AEC_Event Start Date", "AEC_Even_Start_Date");
        mapping.put("PRI_Product Role", "PRI_Product_Role");
        mapping.put("PRI_Reported Brand/Product Name", "PRI_Reported_Brand_Product_Name");
        mapping.put("PRI_FDA Industry Code", "PRI_FDA_Industry_Code");
        mapping.put("PRI_FDA Industry Name", "PRI_FDA_Industry_Name");
        mapping.put("CI_Age at Adverse Event", "CI_Age_At_Adverse_Event");
        mapping.put("CI_Age Unit", "CI_Age_Unit");
        mapping.put("CI_Gender", "CI_Gender");
        mapping.put("AEC_One Row Outcomes", "AEC_One_Row_Outcomes");
        mapping.put("SYM_One Row Coded Symptoms", "SYM_One_Row_Coded_Symptoms");

        // HeaderColumnNameTranslateMappingStrategy
        // for Caers class
        HeaderColumnNameTranslateMappingStrategy<Caers> strategy = new HeaderColumnNameTranslateMappingStrategy<Caers>();
        strategy.setType(Caers.class);
        strategy.setColumnMapping(mapping);

        // Create castobaen and csvreader object
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean<Caers> csvToBean = new CsvToBean<>();
        csvToBean.setMappingStrategy(strategy);
        csvToBean.setCsvReader(csvReader);

        // call the parse method of CsvToBean
        // pass strategy, csvReader to parse method
        return csvToBean.parse();
    }
}

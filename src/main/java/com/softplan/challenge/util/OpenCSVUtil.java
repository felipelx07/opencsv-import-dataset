package com.softplan.challenge.util;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.softplan.challenge.model.Caers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class OpenCSVUtil {

    public static List<Caers> parse(File file) {
        HeaderColumnNameTranslateMappingStrategy<Caers> strategy = new HeaderColumnNameTranslateMappingStrategy<Caers>();
        strategy.setType(Caers.class);
        strategy.setColumnMapping(CaersUtil.caersFields());

        /*
         *  Create castobaen and csvreader object
         */
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean<Caers> csvToBean = new CsvToBean<>();
        csvToBean.setMappingStrategy(strategy);
        csvToBean.setCsvReader(csvReader);

        /*
         * call the parse method of CsvToBean
         * pass strategy, csvReader to parse method
         */
        return csvToBean.parse();
    }
}

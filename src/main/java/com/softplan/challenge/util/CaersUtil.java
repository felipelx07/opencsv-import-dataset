package com.softplan.challenge.util;

import java.util.HashMap;
import java.util.Map;

public class CaersUtil {

    /*
     * This a Map of Caers Entity Fields;
     * To reuse in any place
     */
    public static Map<String, String> caersFields() {
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
        return mapping;
    }
}

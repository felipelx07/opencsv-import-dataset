package com.softplan.challenge.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "caers_ascii_2004")
public class Caers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RA_Report")
    private String RA_Report;

    @Column(name = "RA_CAERS_Created_Date")
    private String RA_CAERS_Created_Date;

    @Column(name = "AEC_Even_Start_Date")
    private String AEC_Even_Start_Date;

    @Column(name = "PRI_Product_Role")
    private String PRI_Product_Role;

    @Column(name = "PRI_Reported_Brand_Product_Name")
    private String PRI_Reported_Brand_Product_Name;

    @Column(name = "PRI_FDA_Industry_Code")
    private String PRI_FDA_Industry_Code;

    @Column(name = "PRI_FDA_Industry_Name")
    private String PRI_FDA_Industry_Name;

    @Column(name = "CI_Age_At_Adverse_Event")
    private String CI_Age_At_Adverse_Event;

    @Column(name = "CI_Age_Unit")
    private String CI_Age_Unit;

    @Column(name = "CI_Gender")
    private String CI_Gender;

    @Column(name = "AEC_One_Row_Outcomes", length = 10000)
    private String AEC_One_Row_Outcomes;

    @Column(name = "SYM_One_Row_Coded_Symptoms", length = 10000)
    private String SYM_One_Row_Coded_Symptoms;

    private boolean active = true;
}

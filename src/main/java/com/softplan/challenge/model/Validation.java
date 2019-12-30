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
@Table(name = "caers_validation")
public class Validation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String field;

    @Column(name = "accept_existing_value")
    private boolean acceptExistingValue = true;

    @Column(name = "accept_null")
    private boolean acceptNull = true;

    @Column(name = "accept_not_available")
    private boolean acceptNotAvailable = true;

    @Column(name = "accept_special_characters")
    private boolean acceptSpecialCharacters = true;

    @Column(name = "only_numbers")
    private boolean onlyNumbers = false;

    @Column(name = "only_date_type")
    private boolean onlyDate = false;

}

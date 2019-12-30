package com.softplan.challenge.controller;

import com.softplan.challenge.model.Caers;
import com.softplan.challenge.model.Log;
import com.softplan.challenge.model.Validation;
import com.softplan.challenge.service.CaersService;
import com.softplan.challenge.service.LogService;
import com.softplan.challenge.service.ValidationService;
import com.softplan.challenge.util.FileUploadUtil;
import com.softplan.challenge.util.ValidationUtil;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
@Getter
@Setter
public class CaersController implements Serializable {

    @Inject
    private transient CaersService service;

    @Inject
    private transient ValidationService validationService;

    @Inject
    private transient LogService logService;

    @Inject
    private Caers caers;
    private List<Caers> caersListFromCSV;
    private UploadedFile file;

    private List<Validation> validations;
    private List<Log> logs;

    @PostConstruct
    private void init() {
        validations = validationService.list();
    }

    public void upload() throws IOException {
        caersListFromCSV = new ArrayList<>();
        caersListFromCSV = FileUploadUtil.upload(file);
    }

    private void validate() {
        ValidationUtil.validate(caersListFromCSV, validations);
    }

    public List<Caers> listInactiveRecords() {
        return service.listInactiveRecords();
    }

    private void insert() {
        caersListFromCSV.forEach(c -> service.update(c));
    }
}

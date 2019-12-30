package com.softplan.challenge.controller;

import com.softplan.challenge.model.Validation;
import com.softplan.challenge.service.ValidationService;
import com.softplan.challenge.util.ValidationUtil;
import lombok.Getter;
import lombok.Setter;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
@Getter
@Setter
public class ValidationController implements Serializable {

    @Inject
    private transient ValidationService validationService;

    @Inject
    private Validation validation;

    public void update() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        String value = params.get("id_validation");
        String columnName = params.get("column_name");
        String columnValue = params.get("column_value");

        if (value != null) {
            validation = validationService.find(Long.valueOf(value));
            ValidationUtil.setValuesFromParam(validation, columnName, columnValue);
            validation = validationService.update(validation);
            validation = new Validation();
        }
    }
}

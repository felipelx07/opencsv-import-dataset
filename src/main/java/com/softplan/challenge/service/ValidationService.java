package com.softplan.challenge.service;

import com.softplan.challenge.model.Validation;
import com.softplan.challenge.repository.ValidationRepository;
import com.softplan.challenge.util.JavaUtil;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationService extends ValidationRepository<Validation> {

    @Override
    @Transactional
    public List<Validation> list() {
        prepareValidations();
        return super.list().stream().sorted(Comparator.comparing(Validation::getId)).collect(Collectors.toList());
    }

    private void prepareValidations() {
        JavaUtil.getAllCaersFields().forEach(f -> {
            if (f != null && !f.getName().equals("id") && !f.getName().equals("active") && !existField(f.getName())) {
                Validation validation = new Validation();
                validation.setField(f.getName());
                super.update(validation);
            }
        });
    }
}

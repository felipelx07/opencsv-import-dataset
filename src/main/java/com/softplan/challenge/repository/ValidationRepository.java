package com.softplan.challenge.repository;


import com.softplan.challenge.model.Validation;

import javax.persistence.TypedQuery;

public class ValidationRepository<T> extends ApplicationRepository<Validation> {

    public boolean existField(String field) {
        TypedQuery<Long> typedQuery = getEm().createQuery("SELECT COUNT(v) FROM Validation v WHERE v.field = :field",
                Long.class);
        typedQuery.setParameter("field", field);
        return typedQuery.getSingleResult() > 0;
    }
}

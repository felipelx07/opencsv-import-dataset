package com.softplan.challenge.repository;


import com.softplan.challenge.model.Caers;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CaersRepository<T> extends ApplicationRepository<Caers> {

    public List<Caers> listInactiveRecords() {
        TypedQuery<Caers> typedQuery = getEm().createQuery("SELECT c FROM Caers c WHERE c.active = false", Caers.class);
        return typedQuery.getResultList();
    }

    public List<Caers> list() {
        TypedQuery<Caers> typedQuery = getEm().createQuery("SELECT c FROM Caers c WHERE c.active = true", Caers.class);
        return typedQuery.getResultList();
    }

    public List<Caers> list(int start, int size) {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Caers> q = cb.createQuery(Caers.class);
        Root<Caers> r = q.from(Caers.class);
        CriteriaQuery<Caers> select = q.select(r);
        TypedQuery<Caers> query = getEm().createQuery(select);
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.getResultList();
    }
}

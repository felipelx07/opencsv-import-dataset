package com.softplan.challenge.repository;

import lombok.AccessLevel;
import lombok.Getter;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ApplicationRepository<T> {

    @Inject
    @Getter(AccessLevel.PROTECTED)
    private EntityManager em;

    @Getter(AccessLevel.PROTECTED)
    private Class<T> entityClass;

    @Getter(AccessLevel.PROTECTED)
    private String entityClassName;

    ApplicationRepository() {
        Type type = getClass().getGenericSuperclass();

        if (!(type instanceof ParameterizedType)) {
            type = getClass().getSuperclass().getGenericSuperclass();
        }
        ParameterizedType paramType = (ParameterizedType) type;
        entityClass = (Class<T>) paramType.getActualTypeArguments()[0];
        entityClassName = entityClass.getSimpleName();
    }

    public T find(Long id) {
        T entity = em.find(entityClass, id);
        return entity;
    }

    @Transactional
    public T insert(T entity) {
        em.persist(entity);
        return em.merge(entity);
    }

    @Transactional
    public T update(T entity) {
        return em.merge(entity);
    }

    public List<T> list() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        query.from(entityClass);
        return em.createQuery(query).getResultList();
    }

    public Integer count() {
        TypedQuery<Integer> typedQuery = em.createQuery("FROM " + entityClassName, Integer.class);
        return typedQuery.getSingleResult();
    }
}

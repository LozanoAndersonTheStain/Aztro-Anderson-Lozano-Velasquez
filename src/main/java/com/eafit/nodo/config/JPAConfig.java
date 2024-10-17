package com.eafit.nodo.config;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.function.Consumer;

public class JPAConfig<T> {
    @Getter
    private static EntityManagerFactory entityManagerFactory;

    @Getter
    private static EntityManager entityManager;

    public JPAConfig() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(T entity) {
        executeInsideTransaction(entityManager -> entityManager.persist(entity));
    }

    public T find(Class<T> entityClass, Object primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    public List<T> findAll(Class<T> entityClass) {
        TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
        return query.getResultList();
    }

    public void delete(Class<T> entityClass, Object primaryKey) {
        executeInsideTransaction(entityManager -> {
            T entity = entityManager.find(entityClass, primaryKey);
            if (entity != null) {
                entityManager.remove(entity);
            }
        });
    }

    public void update(T entity) {
        executeInsideTransaction(entityManager -> entityManager.merge(entity));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            action.accept(entityManager);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        }
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
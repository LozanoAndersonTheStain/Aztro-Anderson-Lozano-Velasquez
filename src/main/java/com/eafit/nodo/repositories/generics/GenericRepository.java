package com.eafit.nodo.repositories.generics;

import com.eafit.nodo.config.JPAConfig;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericRepository<T> {
    private static final Logger LOGGER = Logger.getLogger(GenericRepository.class.getName());
    private final JPAConfig<T> jpaConfig;

    public GenericRepository(JPAConfig<T> jpaConfig) {
        this.jpaConfig = jpaConfig;
    }

    public void create(T entity) {
        try {
            jpaConfig.save(entity);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error creating entity", e);
        }
    }

    public T findById(Class<T> entityClass, Object id) {
        try {
            return jpaConfig.find(entityClass, id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error finding entity by ID", e);
            return null;
        }
    }

    public List<T> findAll(Class<T> entityClass) {
        try {
            return jpaConfig.findAll(entityClass);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error finding all entities", e);
            return null;
        }
    }

    public void update(T entity) {
        try {
            jpaConfig.update(entity);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating entity", e);
        }
    }

    public void delete(Class<T> entityClass, Object id) {
        try {
            jpaConfig.delete(entityClass, id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error deleting entity", e);
        }
    }
}
package com.eafit.nodo.repositories.supermercado;

import com.eafit.nodo.config.JPAConfig;
import com.eafit.nodo.models.supermercado.Compra;
import jakarta.persistence.*;

import java.util.List;

public class CompraRepository {
    private final EntityManagerFactory emf;

    public CompraRepository() {
        this.emf = JPAConfig.getEntityManagerFactory();
    }

    public void create(Compra compra) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Compra existingCompra = entityManager.find(Compra.class, compra.getId());
            if (existingCompra != null) {
                System.out.println("La compra ya existe y se va a omitir.");
            } else {
                entityManager.merge(compra);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Compra findById(long id) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager.find(Compra.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Compra> findAll() {
        try (EntityManager entityManager = emf.createEntityManager()) {
            TypedQuery<Compra> query = entityManager.createQuery("SELECT c FROM Compra c", Compra.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(long id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Compra compra = entityManager.find(Compra.class, id);
            if (compra != null) {
                entityManager.remove(compra);
                transaction.commit();
            } else {
                System.out.println("La compra no existe y no se puede eliminar.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void update(Compra compra) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Compra existingCompra = entityManager.find(Compra.class, compra.getId());
            if (existingCompra != null) {
                existingCompra.setFecha(compra.getFecha());
                existingCompra.setTotal(compra.getTotal());
                existingCompra.setPagado(compra.isPagado());
                existingCompra.setEntregado(compra.isEntregado());
                existingCompra.setProductos(compra.getProductos());
                entityManager.merge(existingCompra);
                transaction.commit();
            } else {
                System.out.println("La compra no existe y no se puede actualizar.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}

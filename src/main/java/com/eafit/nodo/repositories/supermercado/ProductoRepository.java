package com.eafit.nodo.repositories.supermercado;

import com.eafit.nodo.models.supermercado.Producto;
import jakarta.persistence.*;

import java.util.List;

public class ProductoRepository {
    private final EntityManagerFactory emf;

    public ProductoRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Producto producto) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Producto existingProducto = entityManager.find(Producto.class, producto.getId());
            if (existingProducto != null) {
                System.out.println("El producto ya existe y se va a omitir.");
            } else {
                entityManager.merge(producto);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Producto findById(long id) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager.find(Producto.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Producto> findAll() {
        try (EntityManager entityManager = emf.createEntityManager()) {
            TypedQuery<Producto> query = entityManager.createQuery("SELECT c FROM Producto c", Producto.class);
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
            Producto producto = entityManager.find(Producto.class, id);
            if (producto != null) {
                entityManager.remove(producto);
                transaction.commit();
            } else {
                System.out.println("El producto no existe.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Producto producto) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Producto existingProducto = entityManager.find(Producto.class, producto.getId());
            if (existingProducto != null) {
                entityManager.merge(producto);
                transaction.commit();
            } else {
                System.out.println("El producto no existe.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}

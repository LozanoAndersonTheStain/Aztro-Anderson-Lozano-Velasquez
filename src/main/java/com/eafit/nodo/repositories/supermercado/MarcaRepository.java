package com.eafit.nodo.repositories.supermercado;

import com.eafit.nodo.models.supermercado.Marca;
import jakarta.persistence.*;

import java.util.List;

public class MarcaRepository {
    private final EntityManagerFactory emf;

    public MarcaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Marca marca) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Marca existingMarca = entityManager.find(Marca.class, marca.getId());
            if (existingMarca != null) {
                System.out.println("La marca ya existe y se va a omitir.");
            } else {
                entityManager.merge(marca);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Marca findById(long id) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager.find(Marca.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Marca> findAll() {
        try (EntityManager entityManager = emf.createEntityManager()) {
            TypedQuery<Marca> query = entityManager.createQuery("SELECT c FROM Marca c", Marca.class);
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
            Marca marca = entityManager.find(Marca.class, id);
            if (marca != null) {
                entityManager.remove(marca);
                transaction.commit();
            } else {
                System.out.println("La marca no existe.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void update(Marca marca) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(marca);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}

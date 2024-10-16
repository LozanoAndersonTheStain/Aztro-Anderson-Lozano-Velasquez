package com.eafit.nodo.repositories.supermercado;

import com.eafit.nodo.config.JPAConfig;
import com.eafit.nodo.models.supermercado.Cliente;
import jakarta.persistence.*;

import java.util.List;

public class ClienteRepository {

    private final EntityManagerFactory emf;

    public ClienteRepository() {
        this.emf = JPAConfig.getEntityManagerFactory();
    }

    public void create(Cliente cliente) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Cliente existingCliente = entityManager.find(Cliente.class, cliente.getId());
            if (existingCliente != null) {
                System.out.println("El cliente ya existe y se va a omitir.");
            } else {
                entityManager.merge(cliente);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Cliente findById(long id) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager.find(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cliente> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public List<Cliente> findAllPaginated(int pageNumber, int pageZise) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
            query.setFirstResult((pageNumber - 1) * pageZise);
            query.setMaxResults(pageZise);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void delete(long id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Cliente cliente = entityManager.find(Cliente.class, id);
            if (cliente != null) {
                entityManager.remove(cliente);
                transaction.commit();
            } else {
                System.out.println("El cliente no existe y no se puede eliminar.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void update(Cliente cliente) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Cliente existingCliente = entityManager.find(Cliente.class, cliente.getId());
            if (existingCliente != null) {
                existingCliente.setNombre(cliente.getNombre());
                existingCliente.setApellido(cliente.getApellido());
                entityManager.merge(existingCliente);
                transaction.commit();
            } else {
                System.out.println("El cliente no existe y no se puede actualizar.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}

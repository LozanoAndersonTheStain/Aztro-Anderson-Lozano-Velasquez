package com.eafit.nodo;

import com.eafit.nodo.config.JPAConfig;
import com.eafit.nodo.models.supermercado.Cliente;
import com.eafit.nodo.repositories.supermercado.ClienteRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();

        Cliente cliente = new Cliente();
        cliente.setNombre("Anderson");
        cliente.setApellido("Lozano");
        cliente.setDireccion("Calle 123");
        cliente.setTelefono("555-5679-0850");
        clienteRepository.create(cliente);

        List<Cliente> clientes = clienteRepository.findAll();

        for (Cliente c : clientes) {
            System.out.println(c.getCompras());
            System.out.println(c);
        }

        JPAConfig.closeEntityManagerFactory();
    }
}
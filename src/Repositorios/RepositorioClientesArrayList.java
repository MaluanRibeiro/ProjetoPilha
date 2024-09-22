package Repositorios;

import java.util.ArrayList;
import Entidades.Cliente;
import Interfaces.RepositorioClientes;

public class RepositorioClientesArrayList implements RepositorioClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(String cpf) {
        clientes.removeIf(c -> c.getCpf().equals(cpf));
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }
}

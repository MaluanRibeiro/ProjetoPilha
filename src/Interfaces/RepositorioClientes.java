package Interfaces;

import Entidades.Cliente;
import java.util.ArrayList;

public interface RepositorioClientes {
    void adicionarCliente(Cliente cliente);
    void removerCliente(String cpf);
    Cliente buscarClientePorCpf(String cpf);
    ArrayList<Cliente> listarClientes();
}


package Repositorios;

import java.util.ArrayList;
import Entidades.Contrato;
import Interfaces.RepositorioContratos;

public class RepositorioContratosArrayList implements RepositorioContratos {
    private ArrayList<Contrato> contratos = new ArrayList<>();

    public void adicionarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public void removerContrato(Contrato contrato) {
        contratos.remove(contrato);
    }

    public ArrayList<Contrato> listarContratos() {
        return new ArrayList<>(contratos);
    }
}


package Repositorios;

import java.util.ArrayList;
import Entidades.Veiculo;
import Interfaces.RepositorioVeiculos;

public class RepositorioVeiculosArrayList implements RepositorioVeiculos {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(String placa) {
        veiculos.removeIf(v -> v.getPlaca().equals(placa));
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public ArrayList<Veiculo> listarVeiculosDisponiveis() {
        ArrayList<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel()) {
                disponiveis.add(veiculo);
            }
        }
        return disponiveis;
    }
}


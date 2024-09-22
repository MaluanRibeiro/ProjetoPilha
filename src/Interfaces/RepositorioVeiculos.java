package Interfaces;

import Entidades.Veiculo;
import java.util.ArrayList;

public interface RepositorioVeiculos {
    void adicionarVeiculo(Veiculo veiculo);
    void removerVeiculo(String placa);
    Veiculo buscarVeiculoPorPlaca(String placa);
    ArrayList<Veiculo> listarVeiculos();
    ArrayList<Veiculo> listarVeiculosDisponiveis();
}

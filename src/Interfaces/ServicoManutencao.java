package Interfaces;

import Entidades.Veiculo;
public interface ServicoManutencao {
    void realizarManutencao(Veiculo veiculo);
    void agendarManutencao(String placaVeiculo);
}


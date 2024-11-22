package Servicos;

import Entidades.Veiculo;
import Interfaces.ServicoManutencao;
import Repositorios.RepositorioVeiculosArrayList;

public class ServicoManutencaoImpl implements ServicoManutencao {
    private RepositorioVeiculosArrayList repositorioVeiculos;

    public ServicoManutencaoImpl(RepositorioVeiculosArrayList repositorioVeiculos) {
        this.repositorioVeiculos = repositorioVeiculos;
    }

    public void realizarManutencao(Veiculo veiculo) {
        if (veiculo.isDisponivel()) {
            veiculo.setDisponivel(false);
            System.out.println("Manutenção realizada no veículo: " + veiculo.getPlaca());

            veiculo.setDisponivel(true);
            System.out.println("Veículo está disponível novamente após a manutenção.");
        } else {
            System.out.println("Veículo já está em manutenção ou alugado.");
        }
    }

    public void agendarManutencao(String placaVeiculo) {
        Veiculo veiculo = repositorioVeiculos.buscarVeiculoPorPlaca(placaVeiculo);
        if (veiculo != null && veiculo.isDisponivel()) {
            realizarManutencao(veiculo);
        } else {
            System.out.println("Veículo não encontrado ou já está indisponível.");
        }
    }
}


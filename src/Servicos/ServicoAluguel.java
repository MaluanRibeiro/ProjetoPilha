package Servicos;

import java.util.Date;
import Repositorios.RepositorioVeiculosArrayList;
import Repositorios.RepositorioClientesArrayList;
import Repositorios.RepositorioContratosArrayList;
import Entidades.Cliente;
import Entidades.Veiculo;
import Entidades.AluguelCurtoPrazo;
import Entidades.AluguelLongoPrazo;

public class ServicoAluguel {
    private RepositorioVeiculosArrayList repositorioVeiculos;
    private RepositorioClientesArrayList repositorioClientes;
    private RepositorioContratosArrayList repositorioContratos;

    public ServicoAluguel(RepositorioVeiculosArrayList repositorioVeiculos, RepositorioClientesArrayList repositorioClientes, RepositorioContratosArrayList repositorioContratos) {
        this.repositorioVeiculos = repositorioVeiculos;
        this.repositorioClientes = repositorioClientes;
        this.repositorioContratos = repositorioContratos;
    }

    public void alugarVeiculoCurtoPrazo(String cpfCliente, String placaVeiculo, Date dataInicio, Date dataFim, double valorDiaria) {
        Cliente cliente = repositorioClientes.buscarClientePorCpf(cpfCliente);
        Veiculo veiculo = repositorioVeiculos.buscarVeiculoPorPlaca(placaVeiculo);

        if (cliente != null && veiculo != null && veiculo.isDisponivel()) {
            AluguelCurtoPrazo contrato = new AluguelCurtoPrazo(cliente, veiculo, dataInicio, dataFim, valorDiaria);
            repositorioContratos.adicionarContrato(contrato);
            veiculo.setDisponivel(false);
            System.out.println("Veículo alugado com sucesso por curto prazo!");
        } else {
            System.out.println("Cliente ou veículo não encontrado, ou veículo não disponível.");
        }
    }

    public void alugarVeiculoLongoPrazo(String cpfCliente, String placaVeiculo, Date dataInicio, Date dataFim, double valorMensal) {
        Cliente cliente = repositorioClientes.buscarClientePorCpf(cpfCliente);
        Veiculo veiculo = repositorioVeiculos.buscarVeiculoPorPlaca(placaVeiculo);

        if (cliente != null && veiculo != null && veiculo.isDisponivel()) {
            AluguelLongoPrazo contrato = new AluguelLongoPrazo(cliente, veiculo, dataInicio, dataFim, valorMensal);
            repositorioContratos.adicionarContrato(contrato);
            veiculo.setDisponivel(false);
            System.out.println("Veículo alugado com sucesso por longo prazo!");
        } else {
            System.out.println("Cliente ou veículo não encontrado, ou veículo não disponível.");
        }
    }

    public void devolverVeiculo(String placaVeiculo) {
        Veiculo veiculo = repositorioVeiculos.buscarVeiculoPorPlaca(placaVeiculo);
        if (veiculo != null) {
            veiculo.setDisponivel(true);
            System.out.println("Veículo devolvido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public void listarContratos() {
        System.out.println("Lista de contratos:");
        repositorioContratos.listarContratos().forEach(contrato -> {
            System.out.println("Cliente: " + contrato.getCliente().getNome() +
                    " | Veículo: " + contrato.getVeiculo().getPlaca() +
                    " | Início: " + contrato.getDataInicio() +
                    " | Fim: " + contrato.getDataFim());
        });
    }
}

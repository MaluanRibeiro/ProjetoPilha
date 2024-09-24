package app;

import java.util.Date;
import java.util.Scanner;
import java.util.Stack;
import Entidades.Cliente;
import Entidades.Veiculo;
import Repositorios.RepositorioClientesArrayList;
import Repositorios.RepositorioContratosArrayList;
import Repositorios.RepositorioVeiculosArrayList;
import Servicos.ServicoAluguel;
import Servicos.ServicoManutencaoImpl;

public class App {
    public static void main(String[] args) {

        RepositorioVeiculosArrayList repositorioVeiculos = new RepositorioVeiculosArrayList();
        RepositorioClientesArrayList repositorioClientes = new RepositorioClientesArrayList();
        RepositorioContratosArrayList repositorioContratos = new RepositorioContratosArrayList();


        ServicoAluguel servicoAluguel = new ServicoAluguel(repositorioVeiculos, repositorioClientes, repositorioContratos);
        ServicoManutencaoImpl servicoManutencao = new ServicoManutencaoImpl(repositorioVeiculos);

        Stack<String> historicoAcoes = new Stack<>();

        Cliente cliente1 = new Cliente("Maluan", "12345678900");
        Veiculo veiculo1 = new Veiculo("ABC-1234", "Honda Civic");
        repositorioClientes.adicionarCliente(cliente1);
        repositorioVeiculos.adicionarVeiculo(veiculo1);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n=== Sistema de Locação de Veículos ===");
            System.out.println("1. Alugar Veículo Curto Prazo");
            System.out.println("2. Alugar Veículo Longo Prazo");
            System.out.println("3. Devolver Veículo");
            System.out.println("4. Agendar Manutenção");
            System.out.println("5. Listar Veículos");
            System.out.println("6. Listar Contratos");
            System.out.println("7. Sair");
            System.out.println("8. Exibir Histórico de Ações");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Aluguel Curto Prazo:");
                    System.out.print("Digite o CPF do Cliente: ");
                    String cpfCurto = scanner.nextLine();
                    System.out.print("Digite a Placa do Veículo: ");
                    String placaCurto = scanner.nextLine();
                    System.out.print("Digite o valor da diária: ");
                    double valorDiaria = scanner.nextDouble();
                    servicoAluguel.alugarVeiculoCurtoPrazo(cpfCurto, placaCurto, new Date(), new Date(System.currentTimeMillis() + 86400000L), valorDiaria);
                    historicoAcoes.push("Aluguel Curto Prazo: Cliente " + cpfCurto + " alugou o veículo " + placaCurto);

                    break;

                case 2:
                    System.out.println("Aluguel Longo Prazo:");
                    System.out.print("Digite o CPF do Cliente: ");
                    String cpfLongo = scanner.nextLine();
                    System.out.print("Digite a Placa do Veículo: ");
                    String placaLongo = scanner.nextLine();
                    System.out.print("Digite o valor mensal: ");
                    double valorMensal = scanner.nextDouble();
                    servicoAluguel.alugarVeiculoLongoPrazo(cpfLongo, placaLongo, new Date(), new Date(System.currentTimeMillis() + (86400000L * 30)), valorMensal);
                    break;

                case 3:
                    System.out.print("Digite a Placa do Veículo para Devolver: ");
                    String placaDevolver = scanner.nextLine();
                    servicoAluguel.devolverVeiculo(placaDevolver);
                    historicoAcoes.push("Devolução: Veículo " + placaDevolver + " devolvido.");

                    break;

                case 4:
                    System.out.print("Digite a Placa do Veículo para Manutenção: ");
                    String placaManutencao = scanner.nextLine();
                    servicoManutencao.agendarManutencao(placaManutencao);
                    break;

                case 5:
                    System.out.println("Lista de Veículos:");
                    for (Veiculo veiculo : repositorioVeiculos.listarVeiculos()) {
                        System.out.println("Placa: " + veiculo.getPlaca() + " | Modelo: " + veiculo.getModelo() + " | Disponível: " + (veiculo.isDisponivel() ? "Sim" : "Não"));
                    }
                    break;

                case 6:
                    servicoAluguel.listarContratos();
                    break;
                case 8:
                    if (!historicoAcoes.isEmpty()) {
                        System.out.println("Histórico de Ações:");
                        for (String acao : historicoAcoes) {
                            System.out.println(acao);
                        }
                    } else {
                        System.out.println("Nenhuma ação registrada ainda.");
                    }
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }

        } while (opcao != 7);

        scanner.close();
    }
}

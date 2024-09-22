package Entidades;

import java.util.Date;

public class AluguelCurtoPrazo extends Contrato {
    private double valorDiaria;

    public AluguelCurtoPrazo(Cliente cliente, Veiculo veiculo, Date dataInicio, Date dataFim, double valorDiaria) {
        super(cliente, veiculo, dataInicio, dataFim);
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double calcularValorTotal() {
        long diffInMillis = getDataFim().getTime() - getDataInicio().getTime();
        int diasAluguel = (int) (diffInMillis / (1000 * 60 * 60 * 24));
        return diasAluguel * valorDiaria;
    }
}


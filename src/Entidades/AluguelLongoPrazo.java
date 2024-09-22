package Entidades;

import java.util.Date;

public class AluguelLongoPrazo extends Contrato {
    private double valorMensal;

    public AluguelLongoPrazo(Cliente cliente, Veiculo veiculo, Date dataInicio, Date dataFim, double valorMensal) {
        super(cliente, veiculo, dataInicio, dataFim);
        this.valorMensal = valorMensal;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public double calcularValorTotal() {
        long diffInMillis = getDataFim().getTime() - getDataInicio().getTime();
        int mesesAluguel = (int) (diffInMillis / (1000L * 60 * 60 * 24 * 30));
        return mesesAluguel * valorMensal;
    }
}

package Entidades;

import java.util.Date;

public abstract class Contrato {

    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataInicio;
    private Date dataFim;

    public Contrato(Cliente cliente, Veiculo veiculo, Date dataInicio, Date dataFim) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }
}


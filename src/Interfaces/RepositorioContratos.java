package Interfaces;

import java.util.ArrayList;
import Entidades.Contrato;

public interface RepositorioContratos {
    void adicionarContrato(Contrato contrato);
    void removerContrato(Contrato contrato);
    ArrayList<Contrato> listarContratos();
}


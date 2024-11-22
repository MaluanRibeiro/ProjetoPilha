package Entidades;
import jakarta.persistence.*;
import java.util.List;

@Entity()
@Table(name="veiculos")
public class Veiculo {
    @id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Colunm()
    private String placa;
    @Column()
    private String modelo;
    @Column()
    private boolean disponivel;



    public Veiculo(String placa, String modelo, boolean disponivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.disponivel = disponivel;
    }

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}


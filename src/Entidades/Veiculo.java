package Entidades;

public class Veiculo {
        private String placa;
        private String modelo;
        private boolean disponivel;

        public Veiculo(String placa, String modelo) {
            this.placa = placa;
            this.modelo = modelo;
            this.disponivel = true;
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


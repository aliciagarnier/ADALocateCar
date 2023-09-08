package org.example;

public class Vehicle implements Entidade<String> {

    private String nome;
    private String placa;

    private final Tamanho tamanho;

    private final double precoDiaria;
    private boolean disponivel;

    public Vehicle(String nome, String placa, Tamanho tamanho) {

        this.nome = nome;
        this.placa = placa;
        this.tamanho = tamanho;
        this.disponivel = true;
        this.precoDiaria = setPrecoDiaria(tamanho);

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca (String placa) {
        this.placa = placa;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setStatus (boolean status) {
        this.disponivel = status;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    @Override
    public String getID() {
        return this.placa;
    }

    private double setPrecoDiaria(Tamanho tamanho) {

        if (tamanho.equals(Tamanho.PEQUENO)) {
            return 100.00;
        }

        if (tamanho.equals(Tamanho.MEDIO)) {
            return 150.00;
        } else {

            return 200.00;

        }


    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "nome='" + nome + '\'' +
                ", placa='" + placa + '\'' +
                ", tamanho=" + tamanho +
                ", precoDiaria=" + precoDiaria +
                ", disponivel=" + disponivel +
                '}';
    }
}
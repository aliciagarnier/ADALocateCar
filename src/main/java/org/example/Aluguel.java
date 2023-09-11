package org.example;
import java.time.LocalDateTime;

public class Aluguel implements Entidade<String> {

    private String IDLocacao;
    private final Vehicle veiculoAlugado;
    private final Pessoa pessoaLocataria;
    private final LocalDateTime dataInicioLocacao;


    public Aluguel (Vehicle veiculoAlugado, Pessoa pessoaLocataria, Endereco enderecoDevolucao, LocalDateTime dataInicioLocacao, LocalDateTime dataFim) {

        this.veiculoAlugado = veiculoAlugado;
        this.pessoaLocataria = pessoaLocataria;
        this.dataInicioLocacao = dataInicioLocacao;
    }

    @Override
    public String getID() {
        return IDLocacao;
    }

    public String getIDLocacao() {
        return IDLocacao;
    }

    public Vehicle getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public Pessoa getPessoaLocataria() {
        return pessoaLocataria;
    }


    public LocalDateTime getDataInicio() {
        return dataInicioLocacao;
    }


}

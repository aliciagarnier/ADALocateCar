package org.example.domain;
import org.example.Status;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Aluguel implements Entidade<Long> {

    private final Long IDLocacao;
    private final Vehicle veiculoAlugado;
    private final Pessoa pessoaLocataria;
    private final LocalDateTime dataInicioLocacao;
    private final LocalDateTime dataFinalDaLocacao;
    private final Long periodoDeLocacao;
    private final String enderecoDaLocacao;
    private final String  enderecoDaDevolucao;
    private Status statusDoAluguel;

    private double valorDaLocacao;

    public Aluguel (Vehicle veiculoAlugado, Pessoa pessoaLocataria, LocalDateTime dataInicioLocacao, LocalDateTime dataFinalDaLocacao, String enderecoDaLocacao, String enderecoDaDevolucao) {

        Random random = new Random();
        this.IDLocacao = random.nextLong();
        this.veiculoAlugado = veiculoAlugado;
        this.pessoaLocataria = pessoaLocataria;
        this.enderecoDaLocacao = enderecoDaLocacao;
        this.enderecoDaDevolucao = enderecoDaDevolucao;
        this.dataInicioLocacao = dataInicioLocacao;
        this.dataFinalDaLocacao = dataFinalDaLocacao;
        this.periodoDeLocacao = calcularTempoDeLocacao();
        this.statusDoAluguel = Status.VIGENTE;
    }

    public long calcularTempoDeLocacao () {

       return Duration.between(dataInicioLocacao, dataFinalDaLocacao).plusDays(1).toDays();
    }
    public Long getPeriodoDeLocacao() {
        return periodoDeLocacao;
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

    public LocalDateTime getDataInicioLocacao() {

        return dataInicioLocacao;
    }


    public double getValorDaLocacao() {
        return valorDaLocacao;
    }

    public void setValorDaLocacao(double valorDaLocacao) {
        this.valorDaLocacao = valorDaLocacao;
    }

    public String getLocalDaLocacao() {
        return enderecoDaLocacao;
    }

    public LocalDateTime getDataFinalDaLocacao() {
        return dataFinalDaLocacao;
    }

    public String getEnderecoDaLocacao() {
        return enderecoDaLocacao;
    }

    public String getEnderecoDaDevolucao() {
        return enderecoDaDevolucao;
    }

    public Long getIDLocacao() {
        return IDLocacao;
    }

    public Status getStatusDoAluguel() {
        return statusDoAluguel;
    }

    public void alterarStatusDoAluguelParaFinalizado () {

          setStatusDoAluguel(Status.FINALIZADO);

    }

    private void setStatusDoAluguel(Status statusDoAluguel) {
        this.statusDoAluguel = statusDoAluguel;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "IDLocacao=" + IDLocacao + "\n" +
                ", veiculoAlugado=" + veiculoAlugado + "\n" +
                ", pessoaLocataria=" + pessoaLocataria + "\n" +
                ", dataInicioLocacao=" + dataInicioLocacao + "\n" +
                ", dataFinalDaLocacao=" + dataFinalDaLocacao + "\n" +
                ", periodoDeLocacao=" + periodoDeLocacao + "\n" +
                ", enderecoDaLocacao='" + enderecoDaLocacao + '\'' + "\n" +
                ", enderecoDaDevolucao='" + enderecoDaDevolucao + '\'' + "\n" +
                ", statusDoAluguel=" + statusDoAluguel + "\n" +
                ", valorDaLocacao=" + valorDaLocacao +
                '}';
    }

    @Override
    public Long getID() {
        return IDLocacao;

    }


}

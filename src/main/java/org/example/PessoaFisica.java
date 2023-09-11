package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class PessoaFisica extends Pessoa implements Entidade<String> {

    private String cpf;
    private LocalDate dataDeNascimento;

    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }


    public void setDataDeNascimento(String dataDeNascimento){
        this.dataDeNascimento = LocalDate.parse(dataDeNascimento);
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento){
        this.dataDeNascimento =dataDeNascimento;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return " Nome: " +getNome()+ "\n CPF: " +cpf;
    }

    @Override
    public String getID() {
        return cpf;
    }
}
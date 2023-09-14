package org.example.service;

import org.example.domain.Aluguel;

public class CalculadoraDescontoPessoaFisica implements RegraDeCalculo {

    public  double calcular(Aluguel aluguel) {

        double valorAluguel = aluguel.getVeiculoAlugado().getPrecoDiaria() * aluguel.getPeriodoDeLocacao();

        if (aluguel.getPeriodoDeLocacao() > 5) {

            valorAluguel = valorAluguel - (valorAluguel * 0.05);
            return valorAluguel;

        }

        return valorAluguel;
    }
}

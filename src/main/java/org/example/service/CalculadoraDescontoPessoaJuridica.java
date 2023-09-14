package org.example.service;

import org.example.domain.Aluguel;

public class CalculadoraDescontoPessoaJuridica implements RegraDeCalculo {
    @Override
    public double calcular (Aluguel aluguel) {

        double valorAluguel = aluguel.getVeiculoAlugado().getPrecoDiaria() * aluguel.getPeriodoDeLocacao();

        if (aluguel.getPeriodoDeLocacao() > 3) {

            valorAluguel = valorAluguel - (valorAluguel * 0.1);
            return valorAluguel;

        }

        return valorAluguel;

    }
}

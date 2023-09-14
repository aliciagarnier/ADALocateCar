package org.example.service;

import org.example.Status;
import org.example.domain.Aluguel;
import org.example.domain.Pessoa;
import org.example.domain.PessoaFisica;
import org.example.domain.Vehicle;
import org.example.repository.AluguelRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AluguelService {
    private final AluguelRepository aluguelRepository;
    private final RegraDeCalculo calculadoraDescontoPessoaFisica = new CalculadoraDescontoPessoaFisica();

    private final RegraDeCalculo calculadoraDescontoPessoaJuridica = new CalculadoraDescontoPessoaJuridica();

    public AluguelService (AluguelRepository aluguelRepository)
    {

        this.aluguelRepository = aluguelRepository;

    }
    public Aluguel alugarVeiculo (Vehicle veiculoAlugado, Pessoa pessoaLocataria, String dataFinalDaLocacao, String enderecoDaLocacao, String enderecoDaDevolucao)
    {

        LocalDateTime dataFinalDaLocacaoFormatada = transformarDataDeAluguel(dataFinalDaLocacao);

        Aluguel novoAluguel = new Aluguel(veiculoAlugado, pessoaLocataria, LocalDateTime.now(), dataFinalDaLocacaoFormatada, enderecoDaLocacao, enderecoDaDevolucao);

        aluguelRepository.salvar(novoAluguel);
        veiculoAlugado.atualizarStatusDoVeiculoParaAlugado();
        
        System.out.println("Veículo alugado com sucesso!"); 

        return novoAluguel;
    }

       LocalDateTime transformarDataDeAluguel(String input)
       {
        try (Scanner scanner = new Scanner(input)) {
            String dateString = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return LocalDateTime.parse(dateString, formatter);
        }

       }
       public Aluguel finalizarAluguel (Long IDLocacao)
       {

        if (existeAluguel(IDLocacao)) {

            Aluguel aluguelASerFinalizado = aluguelRepository.buscarPorID(IDLocacao);

            aluguelASerFinalizado.setValorDaLocacao(calcularValorDaLocacao(aluguelASerFinalizado));

            setarAluguelParaFinalizado(aluguelASerFinalizado); setarAluguelParaFinalizado(aluguelASerFinalizado);

            aluguelASerFinalizado.getVeiculoAlugado().atualizarStatusDoVeiculoParaDisponivel();

            return aluguelASerFinalizado;

        }
           throw new RuntimeException("Aluguel não cadastrado no sistema, verifique os dados e tente novamente.");
      }

      private void setarAluguelParaFinalizado (Aluguel aluguel) {

        if (aluguel.getStatusDoAluguel().equals(Status.FINALIZADO)) {
            throw new RuntimeException("Aluguel encontra-se como FINALIZADO.");
        }

          aluguel.alterarStatusDoAluguelParaFinalizado();

      }

      private double calcularValorDaLocacao (Aluguel aluguel) {

        if (aluguel.getPessoaLocataria() instanceof PessoaFisica)
        {

            return calculadoraDescontoPessoaFisica.calcular(aluguel);
        }

          return calculadoraDescontoPessoaJuridica.calcular(aluguel);

      }


    public boolean existeAluguel (Long IDLocacao) {

        Aluguel aluguel = aluguelRepository.buscarPorID(IDLocacao);
        return aluguel != null;
    }

    public List<Aluguel> buscarAluguelPorCliente (String identificadorCliente) {

        List<Aluguel> alugueisDoCliente = new ArrayList<>();

        for (Aluguel aluguel : aluguelRepository.listarTodos()) {
            if (aluguel.getPessoaLocataria().getID().equals(identificadorCliente)) {

                alugueisDoCliente.add(aluguel);

            }
        }
        return alugueisDoCliente;
    }

}

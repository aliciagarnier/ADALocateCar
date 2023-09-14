package org.example.service;

import org.example.domain.PessoaFisica;
import org.example.repository.PessoaFisicaRepository;

public class PessoaFisicaService {
    private final PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisicaService (PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    public PessoaFisica CadastrarPessoaFisica (String nome, String cpf) throws Exception {

        if (existePessoaFisica(cpf)) {
            throw new Exception("Pessoa física ja cadastrada no sistema!");
        }

        if (nome == null || cpf == null) {
            throw new RuntimeException("Argumentos nulos, não é possível cadastrar");
        }

        PessoaFisica novaPessoaFisica = new PessoaFisica(nome, cpf);
        return pessoaFisicaRepository.salvar(novaPessoaFisica);

    }

    public PessoaFisica atualizarPessoaFisica(String nome, String cpf) throws Exception {

         if (!existePessoaFisica(cpf)) {
             throw new Exception("Pessoa nao cadastrada no sistema");
         }

         PessoaFisica pessoaFisicaAtualizada = new PessoaFisica(nome, cpf);

         return pessoaFisicaRepository.salvar(pessoaFisicaAtualizada);


    }
    public boolean existePessoaFisica (String cpf) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.buscarPorID(cpf);
        return pessoaFisica != null;

    }

    public void listarTodasPessoasFisicas () {
        pessoaFisicaRepository.listarPessoasFisicas();
    }

    public PessoaFisicaRepository getPessoaFisicaRepository() {
        return pessoaFisicaRepository;
    }
}

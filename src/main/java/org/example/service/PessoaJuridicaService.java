package org.example.service;

import org.example.domain.PessoaJuridica;
import org.example.repository.PessoaJuridicaRepository;

public class PessoaJuridicaService {

    private final PessoaJuridicaRepository pessoaJuridicaRepository;


    public PessoaJuridicaService  (PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    public PessoaJuridica CadastrarPessoaJuridica (String nome, String cnpj) throws Exception {

        if (validarCadastro(cnpj)) {

            PessoaJuridica pessoaJuridicaAtualizada = new PessoaJuridica(nome, cnpj);
            return pessoaJuridicaRepository.salvar(pessoaJuridicaAtualizada);
        }

        throw new Exception("Não foi possivel realizar o cadastro!");

    }

    public PessoaJuridica atualizarPessoaJuridica(String nome, String cnpj) throws Exception {

        if (!existePessoaJuridica(cnpj)) {
            throw new Exception("Pessoa nao cadastrada no sistema");
        }

        PessoaJuridica pessoaJuridicaAtualizada = new PessoaJuridica(nome, cnpj);

        return pessoaJuridicaRepository.salvar(pessoaJuridicaAtualizada);

    }

    public boolean existePessoaJuridica (String cpf) {

       PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.buscarPorID(cpf);
       return pessoaJuridica != null;

    }




    private boolean validarCadastro (String cnpj) {
        return !existePessoaJuridica(cnpj);
    }

    public void listarTodasPessoasJuridicas () {
        pessoaJuridicaRepository.listarTodos();
    }

    public PessoaJuridicaRepository getPessoaJuridicaRepository() {
        return pessoaJuridicaRepository;
    }
}

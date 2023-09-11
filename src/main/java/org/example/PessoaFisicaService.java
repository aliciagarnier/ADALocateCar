package org.example;

public class PessoaFisicaService {
    private final PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisicaService (PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    public PessoaFisica CadastrarPessoaFisica (String nome, String cpf) throws Exception {

        // Logica de validar o CPF. Criar um método?

        if (existePessoaFisica(cpf)) {
            throw new Exception("Pessoa fisica ja cadastrada no sistema");
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

    private boolean existePessoaFisica (String cpf) {

        PessoaFisica pessoaFisica = pessoaFisicaRepository.buscarPorID(cpf);
        return pessoaFisica != null;

    }


}

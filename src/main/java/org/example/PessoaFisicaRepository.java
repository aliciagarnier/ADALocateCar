package org.example;

import java.util.List;

public class PessoaFisicaRepository extends AbstractRepository<PessoaFisica, String> {


    private static final PessoaFisicaRepository pessoaFisicaRepository = new PessoaFisicaRepository();


    private PessoaFisicaRepository () {

    }
    public static PessoaFisicaRepository getPessoaFisicaRepository() {

        return pessoaFisicaRepository;
    }


    public void listarPessoasFisicas () {

        for (PessoaFisica pessoaFisica : listarTodos()) {

            System.out.println(pessoaFisica);
            System.out.println();
        }

    }



}

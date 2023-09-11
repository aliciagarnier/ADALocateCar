package org.example;

public class PessoaJuridicaRepository extends AbstractRepository<PessoaJuridica, String> {


   private static final PessoaJuridicaRepository  pessoaJuridicaRepository = new PessoaJuridicaRepository();


    private PessoaJuridicaRepository() {

   }

   public static PessoaJuridicaRepository getPessoaJuridicaRepository () {
        return pessoaJuridicaRepository;
   }
    public void listarPessoasJuridicas () {

        for (PessoaJuridica pessoaJuridica : listarTodos()) {
            System.out.println(pessoaJuridica);
            System.out.println();
        }

    }
}

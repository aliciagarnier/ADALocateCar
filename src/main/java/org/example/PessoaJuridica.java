package org.example;

public class PessoaJuridica extends Pessoa implements Entidade<String> {
        private String cnpj;

        public PessoaJuridica(String nome, String cnpj) {
            super(nome);
            this.cnpj = cnpj;
        }
        public String getCnpj(){
            return this.cnpj;
        }

        public void setCnpj (String cnpj){

            this.cnpj = cnpj;
        }

        @Override
        public String toString() {
            return " Nome: " +getNome()+ "\n CNPJ: " +cnpj;
        }

    @Override
    public String getID() {
        return cnpj;
    }
}




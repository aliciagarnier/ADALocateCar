package org.example;

public class Endereco {

    private String cidade;
    private String rua;
    private String numero;

    private String complemento;



    public Endereco(String cidade, String rua, String numero) {
        this(cidade, rua, numero, "");
    }


    public Endereco(String cidade, String rua, String numero, String complemento) {
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}

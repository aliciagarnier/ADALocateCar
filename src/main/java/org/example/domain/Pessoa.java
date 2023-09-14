package org.example.domain;

public abstract class Pessoa implements Entidade<String> {
        private String nome;

        public Pessoa (String nome){
            this.nome = nome;
        }

        public String getNome(){
            return this.nome;
        }

        public void setNome(String nome){
            this.nome = nome;
        }

    }

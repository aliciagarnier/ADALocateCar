package org.example;

public abstract class Pessoa  {
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

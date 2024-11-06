package br.com.cadastro.model;

import br.com.cadastro.dto.DtoEndereco;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco = new Endereco();

    public Cliente() {
    }

    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public void fromDto(DtoEndereco dtoEndereco){





    }




    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", endereco=" + endereco +
                '}';
    }
}

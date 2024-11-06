package br.com.cadastro.model;

import br.com.cadastro.dto.DtoEndereco;

public class Endereco {
    private String CEP;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String  uf;

    public Endereco() {
    }

    public Endereco(DtoEndereco dtoEndereco){

        this.CEP = dtoEndereco.cep();
        this.logradouro  = dtoEndereco.logradouro();
        this.localidade = dtoEndereco.localidade();
        this.bairro = dtoEndereco.bairro();
        this.uf = dtoEndereco.uf();
    }


    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "CEP='" + CEP + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", unidade='" + unidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}

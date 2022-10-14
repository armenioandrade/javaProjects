
package com.dio.springboot.appcep.app;

public class ViaCepResponse {
    public String cep;
    public String logradouro;
    public String localidade;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "ViaCepResponse{" + "cep=" + cep + ", logradouro=" + logradouro + ", localidade=" + localidade + '}';
    }
    
    
}

package jogo;

import gate.annotation.Name;
import gate.type.ID;

@Name("Jogo")
public class Jogo {
    public ID id;
    public String nome;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}

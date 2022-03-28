
package projetofinalcursoemvideo;

public class Gafanhoto extends Pessoa{
    private String login;
    private Integer totAssistido;

    public Gafanhoto(String login, Integer totAssistido, String nome, Integer idade, char sexo, Integer experiencia) {
        super(nome, idade, sexo, experiencia);
        this.login = login;
        this.totAssistido = 0;
    }
    
    
    
    private void viuMaisUm(){
        this.totAssistido++;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getTotAssistido() {
        return totAssistido;
    }

    public void setTotAssistido(Integer totAssistido) {
        this.totAssistido = totAssistido;
    }

    @Override
    public String toString() {
        return "Gafanhoto " + super.toString() + "{" + "login=" + login + ", totAssistido=" + totAssistido + '}';
    }
    
    
    
}

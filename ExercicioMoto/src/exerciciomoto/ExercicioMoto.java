package exerciciomoto;

public class ExercicioMoto {

    private Double velocidade;
    private int marcha;
    private boolean ligada;
    private boolean tripe;

    public ExercicioMoto() {
        this.velocidade = 0.0;
        this.marcha = 1;
        this.ligada = false;
        this.tripe = true;
    }

    
    
    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public int getMarcha() {
        if (this.velocidade == 0 && this.velocidade <= 20) {
            marcha = 1;
        } else if (this.velocidade > 30 && this.velocidade <= 40) {
            marcha = 2;
        } else if (this.velocidade > 40 && this.velocidade <= 50){
            marcha = 3;
        }else if (this.velocidade > 50 && this.velocidade <= 80){
            marcha = 4;
        }else if (this.velocidade > 80){
            marcha = 5;
        }
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public void acelerar() {
        this.velocidade = this.velocidade + 10.0;
    }

    public boolean getLigada() {
        return ligada;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
        if(this.ligada == true){
            System.out.println("moto esta ligada");
        }
    }

    public boolean getTripe() {
        return tripe;
    }

    public void setTripe(boolean tripe) {
        this.tripe = tripe;
    }
    
    public void frear(){
        this.velocidade -= 10;
    }
    
}

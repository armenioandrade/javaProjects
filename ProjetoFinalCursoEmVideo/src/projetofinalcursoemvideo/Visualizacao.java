package projetofinalcursoemvideo;
public class Visualizacao {
    private Gafanhoto espectador;
    private Video filme;
    
    public Visualizacao(Gafanhoto espectador, Video filme) {
        this.espectador = espectador;
        this.filme = filme;
        this.espectador.setTotAssistido(this.espectador.getTotAssistido()+1);
        this.filme.setViews(this.filme.getViews()+1);
    }
   

    public void avaliar(){
        filme.like();
        
    }
    
    public void avaliar(Integer nota){
        filme.setAvaliacao(nota);
    }
   

    @Override
    public String toString() {
        return "Visualizacao{" + "espectador=" + espectador + ", filme=" + filme + '}';
    }


    

}

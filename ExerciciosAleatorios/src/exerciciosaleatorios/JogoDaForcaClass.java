package exerciciosaleatorios;

public class JogoDaForcaClass {

    private String palavraParaAdivinhar;
    private String letraSelecionada;
    private char[] palavraDaForca;

    public char[] getPalavraDaForca() {
        return palavraDaForca;
    }

    public void setPalavraDaForca(char[] palavraDaForca) {
        this.palavraDaForca = palavraDaForca;
    }

    
    public String getPalavraParaAdivinhar() {
        return palavraParaAdivinhar;
    }

    public void setPalavraParaAdivinhar(String palavraParaAdivinhar) {
        this.palavraParaAdivinhar = palavraParaAdivinhar;
        palavraDaForca = new char[this.palavraParaAdivinhar.length()];
        for (int i = 0; i < palavraDaForca.length; i++) {
            palavraDaForca[i] = '-';
            
        }
    }

    public String getLetraSelecionada() {
        return letraSelecionada;
    }

    public void setLetraSelecionada(String letraSelecionada) {
        this.letraSelecionada = letraSelecionada;
    }

    public void procuraLetraNaPalavra(char letra) {
        char arrayAux[] = palavraParaAdivinhar.toCharArray();
        for (int i = 0; i < arrayAux.length; i++) {
            if (arrayAux[i] == letra) {
                System.out.println("contem a letra " + letra + " na posicao " + i);
                System.out.println("Preenchendo Forca");
                adicionaLetraNaPalavra(letra, i);
            }

        }

    }

    public void adicionaLetraNaPalavra(char letra, int posicao) {
        palavraDaForca[posicao] = letra;
    }
    
    public void imprimePalavraDaForca(){
        System.out.print(palavraDaForca);
    }
    
}

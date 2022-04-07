package exerciciosaleatorios;

public class JogoDaForcaClass {

    char[] arrayLetra;
    char[] arrayPalavra;
    char[] resultadoPalavra;
    int tamanhoDaPalavra;
    int qtdeMembros = 6;
    String palavra;
    String letra;

    public void procuraLetraNaPalavra(String letra, String palavra) {
        this.arrayLetra = letra.toCharArray();
        this.arrayPalavra = palavra.toCharArray();
        for (int i = 0; i < palavra.length(); i++) {
            if (arrayLetra[0] == arrayPalavra[i]) {
                this.resultadoPalavra[i] = arrayLetra[0];
            }

        }
    }
    
    public void imprimirPalavra() {
        System.out.println("A PALAVRA É");
        String palavra = String.valueOf(resultadoPalavra);
        System.out.println(palavra);
    }
    
    public boolean checarPalavra(int tentativa){
        if(tentativa < this.tamanhoDaPalavra){
            
            return true;
        }
        return false;
    }
    
    public void quadroNovo(){
        this.resultadoPalavra = new char[palavra.length()];
        for (int i = 0; i < resultadoPalavra.length; i++) {
           resultadoPalavra[i] = '_';
        }
        for (int i = 0; i < resultadoPalavra.length; i++) {
            System.out.print(resultadoPalavra[i]+" ");
            
        }
        System.out.println("");
    }
    
    public void quadroAtual(){
        System.out.println(String.valueOf(arrayPalavra));
    }
    
    public int getTamanhoDaPalavra() {
        return this.palavra.length();
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
        this.arrayPalavra = palavra.toCharArray();
                
    }
    

    
}

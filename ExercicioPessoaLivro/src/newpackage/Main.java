package newpackage;

public class Main {

    public static void main(String[] args) {
        Pessoa p = new Pessoa("Armenio", 30, 'M');

        Livro l = new Livro("hp", "jk rowling", 300, 0, false, p);
        
        System.out.println(l.detalhes());
        
    }

}

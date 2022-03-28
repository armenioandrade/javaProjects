package projetofinalcursoemvideo;

public class Main {

    public static void main(String[] args) {
        Gafanhoto g = new Gafanhoto("armenio", 1, "armenio", 31, 'M', 1);
        Video v = new Video("Duro de matar");
        System.out.println(v.toString());
        System.out.println(g.toString());
    }

}

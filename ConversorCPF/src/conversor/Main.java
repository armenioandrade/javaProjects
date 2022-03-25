package conversor;




public class Main   {

    public static void main(String[] args) {
        CPF objCPF = new CPF();
        objCPF.askCPF();
        objCPF.printCPF(objCPF.getCPF());
    }

}

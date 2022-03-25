package banco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente c = new Cliente("Armenio", "081", "Santander", 123, 321);
        Scanner scan = new Scanner(System.in);
        Cliente[] arrayClientes = new Cliente[999];

        String sair = "N";

        while (sair.equalsIgnoreCase("n")) {
            System.out.println("SITEMA BANCARIO");
            System.out.println("---------------------------------------------------");
            System.out.println("[1] CADASTRO");
            System.out.println("[2] LISTAR TODOS");
            System.out.println("[3] SAIR");
            System.out.print("ENTRE COM OPC DESEJADA: ");
            int opc = scan.nextInt();
            if (opc == 3) {
                System.out.println("SAINDO DO SISTEMA...");
                System.out.println("SISTEMA ENCERRADO");
                break;
            } else {

                switch (opc) {
                    case 1:
                        System.out.println("---------------------------------------------------");
                        System.out.println("Cadastro de Clientes: ");
                        System.out.println("---------------------------------------------------");
                        String continuar = "S";

                        for (int i = 0; i < arrayClientes.length; i++) {
                            if (continuar.equalsIgnoreCase("S")) {
                                System.out.print("Nome do cliente: ");
                                String nome = scan.next();
                                System.out.print("CPF: ");
                                String cpf = scan.next();
                                System.out.print("Nome do banco: ");
                                String nomebanco = scan.next();
                                System.out.print("Agencia: ");
                                int ag = scan.nextInt();
                                System.out.print("Conta: ");
                                int conta = scan.nextInt();
                                Cliente f = new Cliente(nome, cpf, nomebanco, ag, conta);
                                arrayClientes[i] = f;
                                System.out.println("Deseja continuar? [S][N]");
                                continuar = scan.next();
                            } else {
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("---------------------------------------------------");
                        System.out.println("Listagem de Clientes: ");
                        System.out.println("---------------------------------------------------");
                        System.out.print("Nome: " + c.getNome() + "\n");
                        System.out.print("CPF: " + c.getCpf() + "\n");
                        System.out.print("Nome do Banco: " + c.getConta().getNomeDoBanco() + "\n");
                        System.out.print("Numero Agencia: " + c.getConta().getAgencia() + "\n");
                        System.out.print(c.getConta().getConta() + "\n");
                        for (int i = 0; i < arrayClientes.length; i++) {

                            if (arrayClientes[i] == null) {
                                System.out.println("FIM DA LISTAGEM");
                                System.out.println("---------------------------------------------------");
                                break;
                            } else {
                                System.out.println("---------------------------------------------------");
                                System.out.print("Nome: " + arrayClientes[i].getNome() + "\n");
                                System.out.print("CPF: " + arrayClientes[i].getCpf() + "\n");
                                System.out.print("Nome do Banco: " + arrayClientes[i].getConta().getNomeDoBanco() + "\n");
                                System.out.print("Numero Agencia: " + arrayClientes[i].getConta().getAgencia() + "\n");
                                System.out.print(arrayClientes[i].getConta().getConta() + "\n");
                                System.out.println("---------------------------------------------------");
                            }

                        }
                        break;
                    default:

                }
            }
        }
    }
}

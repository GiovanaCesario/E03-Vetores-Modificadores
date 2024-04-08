import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        int opcao, opcao2, opcao3;

        //Criando e pondo endereco nas contas(inicializando)
        Conta contaUsuario = new Conta();
        Conta contaZe = new Conta();
        Conta contaMaria = new Conta();

        contaUsuario.dono = new Cliente();
        contaZe.dono = new Cliente();
        contaMaria.dono = new Cliente();

        //Atribuido valores a conta de Jose
        contaZe.dono.nome = "Jose";
        contaZe.dono.cpf = "34578654690";
        contaZe.dono.endereco = "Rua Marta 345";
        contaZe.dono.idade = 32;
        contaZe.dono.sexo = 'm';

        contaZe.saldo = 4000;
        contaZe.numero = 2345;
        contaZe.agencia = "0001";

        //Atribuido valores a conta de Maria
        contaMaria.dono.nome = "Maria";
        contaMaria.dono.cpf = "12345678910";
        contaMaria.dono.endereco = "Rua Sophia 1346";
        contaMaria.dono.idade = 24;
        contaMaria.dono.sexo = 'f';

        contaMaria.saldo = 569;
        contaMaria.numero = 3456;
        contaMaria.agencia = "0001";

        //Interagindo com o usuario
        System.out.println("Boa tarde!");
        System.out.println("Nesse sistema bancario ha 3 contas, a sua, a de Jose e a de Maria");

        //Atribuido valores a conta do usuario
        System.out.println("Digite suas informacoes");
        System.out.print("Nome: ");
        contaUsuario.dono.nome = entrada.next();

        System.out.print("CPF: ");
        contaUsuario.dono.cpf = entrada.next();
        entrada.nextLine();

        System.out.print("Endereco: ");
        contaUsuario.dono.endereco = entrada.nextLine();

        System.out.print("Idade: ");
        contaUsuario.dono.idade = entrada.nextInt();

        //Ciclo que dura ate o usuario digitar um dado valido
        do {
            System.out.print("Sexo (m/f): ");
            contaUsuario.dono.sexo = entrada.next().charAt(0);

            if (contaUsuario.dono.sexo != 'm' && contaUsuario.dono.sexo != 'f') {

                System.out.println("Dado invalido, tente de novo");
            }
        } while (contaUsuario.dono.sexo != 'm' && contaUsuario.dono.sexo != 'f');


        System.out.print("Saldo: ");
        contaUsuario.saldo = entrada.nextDouble();

        System.out.print("Numero da conta: ");
        contaUsuario.numero = entrada.nextInt();

        System.out.print("Agencia: ");
        contaUsuario.agencia = entrada.next();

        //Ciclo que se repete ate o usuario digitar 0
        do{
            System.out.println("");
            System.out.println("O que voce deseja fazer? (digite o numero correspondente a opcao escolhida");
            System.out.println("0 - Sair");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Tranferir");
            System.out.println("4 - Imprimir dados");
            System.out.print("Opcao: ");
            opcao = entrada.nextInt();

            switch (opcao) {

                //Se encerra o ciclo e consequentemente o programa
                case 0:

                    System.out.println("Volte sempre ao nosso banco " +contaUsuario.dono.nome+ "!");

                    break;

                //Saque
                case 1:

                    System.out.print("Valor do saque: ");
                    double valorSaque = entrada.nextDouble();

                    boolean saqueRealizado = contaUsuario.sacar(valorSaque);

                    if(saqueRealizado) {
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Novo saldo: " +contaUsuario.saldo);
                    } else {
                        System.out.println("Erro ao tentar realizar o saque!");
                    }

                    break;

                //Deposito
                case 2:

                    System.out.print("Valor do deposito: ");
                    double valorDeposito = entrada.nextDouble();

                    boolean depositoRealizado = contaUsuario.depositar(valorDeposito);

                    if(depositoRealizado) {
                        System.out.println("Deposito realizado com sucesso!");
                        System.out.println("Novo saldo: " +contaUsuario.saldo);
                    } else {
                        System.out.println("Erro ao tentar realizar o deposito!");
                    }

                    break;

                //Tranferencia
                case 3:

                    System.out.println("");
                    System.out.println("Para quem voce deseja transferir? (digite o numero correspondente a opcao escolhida)");
                    System.out.println("1 - Jose");
                    System.out.println("2 - Maria");
                    System.out.print("Opcao: ");
                    opcao2 = entrada.nextInt();

                    switch (opcao2) {

                        //Tranferencia para Jose
                        case 1:

                            System.out.print("Valor a transferir para Jose: ");
                            double valorTranferir = entrada.nextDouble();

                            boolean tranferenciaRealizada = contaUsuario.transferir(contaZe, valorTranferir);

                            if(tranferenciaRealizada) {
                                System.out.println("Tranferencia realizada com sucesso!");
                                System.out.println("Saldo da sua conta: " +contaUsuario.saldo);
                                System.out.println("Saldo da conta de Jose: " +contaZe.saldo);
                            } else {
                                System.out.println("Erro ao tentar realizar a tranferencia!");
                            }

                            break;

                        //Tranferencia para Maria
                        case 2:

                            System.out.print("Valor a transferir para Maria: ");
                            double valorTranferir2 = entrada.nextDouble();

                            boolean tranferenciaRealizada2 = contaUsuario.transferir(contaMaria, valorTranferir2);

                            if (tranferenciaRealizada2) {
                                System.out.println("Tranferencia realizada com sucesso!");
                                System.out.println("Saldo da sua conta: " +contaUsuario.saldo);
                                System.out.println("Saldo da conta de Maria: " +contaMaria.saldo);
                            } else {
                                System.out.println("Erro ao tentar realizar a tranferencia!");
                            }

                            break;
                        default:

                            System.out.println("Opcao invalida :(");
                            break;
                    }

                    break;

                //EXERCICIO 2
                //Imprimir
                case 4:

                    System.out.println("");
                    System.out.println("De qual conta voce deseja imprimir os dados? (digite o numero correspondente a opcao escolhida)");
                    System.out.println("1 - Sua conta");
                    System.out.println("2 - Jose");
                    System.out.println("3 - Maria");
                    System.out.print("Opcao: ");
                    opcao3 = entrada.nextInt();

                    switch (opcao3) {

                        case 1:

                            contaUsuario.imprimir();
                            break;
                        case 2:

                            contaZe.imprimir();
                            break;
                        case 3:

                            contaMaria.imprimir();
                            break;
                        default:

                            System.out.println("Opcao invalida :(");
                            break;
                    }

                    break;
                default:

                    System.out.println("Opcao invalida :(");
                    break;
            }
        } while (opcao != 0);
    }
}



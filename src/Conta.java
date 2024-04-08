public class Conta {

    //Atributos:
    //Os atributos devem estar fora de qualquer metodo e dentro da classe

    Cliente dono;
    double saldo;
    int numero;
    String agencia;
    Operacao[] operacoes = new Operacao[1000];
    private int operacaoAtual;

    //Metodo depositar
    boolean depositar(double valor) {

        if(valor > 0) {

            //This refencia um membro da classe dentro do metodo
            this.saldo += valor;
            return true;

        } else {

            //Não eh boa pratica colocar mensagem de erro no metodo
            return false;
        }
    }

    //Metodo sacar
    boolean sacar(double valor) {

        if(valor > 0 && valor <= this.saldo){

            this.saldo -= valor;
            return true;

        } else {

            return false;
        }
    }

    //Metodo transferir
    boolean transferir(Conta contaDestino, double valor) {

        boolean saqueRealizado = this.sacar(valor);

        if (saqueRealizado){

            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;

        } else {

            return false;
        }
    }

    //EXERCICIO 2
    //Metodo imprimir

    void imprimir() {
        System.out.println("");
        System.out.println("Dados da conta");

        System.out.println("Dono ");
        System.out.println("  Nome: " +this.dono.nome);
        System.out.println("  CPF: " +this.dono.cpf);
        System.out.println("  Endereco: " +this.dono.endereco);
        System.out.println("  Idade: " +this.dono.idade);
        System.out.println("  Sexo: " +this.dono.sexo);

        System.out.println("Saldo: " +this.saldo);
        System.out.println("Numero da conta: " +this.numero);
        System.out.println("Agencia: " +this.agencia);
    }
}


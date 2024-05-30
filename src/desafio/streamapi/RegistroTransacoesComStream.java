package desafio.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            double saldo = scanner.nextDouble();
            int quantidadeTransacoes = scanner.nextInt();

            List<Transacao> transacoes = new ArrayList<>();

            for (int i = 0; i < quantidadeTransacoes; i++) {
                char tipoTransacao = scanner.next().toUpperCase().charAt(0);
                double valorTransacao = scanner.nextDouble();

                Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
                transacoes.add(transacao);

                saldo = tipoTransacao == 'D' ? saldo + valorTransacao : saldo - valorTransacao;
            }

            System.out.println("\nSaldo : " + String.format("%.1f", saldo));
            System.out.println("Transacoes:");

            IntStream.range(0, transacoes.size())
                    .mapToObj(i -> (transacoes.get(i).getTipo() == 'D' ? "d de " : "s de ") + String.format("%.1f", transacoes.get(i).getValor()))
                    .forEach(System.out::println);
        }
    }
}

class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}

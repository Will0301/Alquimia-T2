package entities;

import java.math.BigInteger;
import java.util.*;

public class Grafo {
    private Map<String, Nodo> nodos = new HashMap<>();

    public void adicionarNodo(String nodoNome) {
        nodos.putIfAbsent(nodoNome, new Nodo());
    }

    public void adicionarAresta(String origem, String destino, int valorAresta) {
        if (Objects.nonNull(nodos.get(origem)) && Objects.nonNull(nodos.get(destino))) {
            nodos.get(origem).adicionarVizinho(destino);
            nodos.get(origem).adicionarAresta(destino, valorAresta);
        }
    }

    public void atribuirValorAresta(String nodoNome, BigInteger valor) {
        if (nodos.get(nodoNome) != null) {
            nodos.get(nodoNome).atribuirValor(valor);
        }
    }

    public BigInteger obterValorNodo(String nodoNome) {
        BigInteger valor;
        if (nodos.get(nodoNome) != null) {
            valor = nodos.get(nodoNome).obterValor();
        } else {
            valor = BigInteger.ZERO;
        }
        return valor;
    }

    public int obterValorAresta(String origem, String destino) {
        Nodo nodoOrigem = nodos.get(origem);
        int valorAresta;
        if (nodoOrigem != null) {
            valorAresta = nodoOrigem.obterValorAresta(destino);
        } else {
            valorAresta = -1;
        }
        return valorAresta;

    }

    public BigInteger swim(String nodoInicial) {
        long start = System.currentTimeMillis();

        Map<String, Integer> checkins = new HashMap<>();
        for (String node : nodos.keySet()) {
            checkins.put(node, 0);
        }

        for (Nodo nodo : nodos.values()) {
            for (String vizinho : nodo.obterVizinhos()) {
                checkins.put(vizinho, checkins.get(vizinho) + 1);
            }
        }

        Queue<String> fila = new LinkedList<>();
        fila.add(nodoInicial);

        while (!fila.isEmpty()) {
            String nodoAtual = fila.poll();

            if (nodos.get(nodoAtual) != null) {
                for (String vizinho : nodos.get(nodoAtual).obterVizinhos()) {
                    BigInteger valorAtual = obterValorNodo(nodoAtual);
                    int valorAresta = obterValorAresta(nodoAtual, vizinho);
                    BigInteger valorVizinho = obterValorNodo(vizinho);

                    BigInteger novoValor = valorAtual.multiply(BigInteger.valueOf(valorAresta));
                    novoValor = novoValor.add(valorVizinho);

                    atribuirValorAresta(vizinho, novoValor);

                    checkins.put(vizinho, checkins.get(vizinho) - 1);
                    if (checkins.get(vizinho) == 0) {
                        fila.add(vizinho);
                    }
                }
            }
        }

        long end = System.currentTimeMillis();
        long tempoTotal = (end - start);
        System.out.println("Executado em: " + tempoTotal + " ms");

        return obterValorNodo("ouro");
    }
}

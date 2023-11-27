package entities;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Grafo {
    private Map<String, Nodo> nodos = new HashMap<>();

    public void adicionarNodo(String nodoNome) {
        nodos.putIfAbsent(nodoNome, new Nodo());
    }

    public void adicionarAresta(String origem, String destino, int valorAresta) {
        Nodo nodoOrigem = nodos.get(origem);
        Nodo nodoDestino = nodos.get(destino);

        if (nodoOrigem != null && nodoDestino != null) {
            nodoOrigem.adicionarVizinho(destino);
            nodoOrigem.adicionarAresta(destino, valorAresta);
        }
    }

    public void atribuirValorAresta(String nodoNome, BigInteger valor) {
        Nodo nodo = nodos.get(nodoNome);
        if (nodo != null) {
            nodo.atribuirValor(valor);
        }
    }

    public BigInteger obterValorNodo(String nodoNome) {
        Nodo nodo = nodos.get(nodoNome);
        return (nodo != null) ? nodo.obterValor() : BigInteger.ZERO;
    }

    public int obterValorAresta(String origem, String destino) {
        Nodo nodoOrigem = nodos.get(origem);
        return (nodoOrigem != null) ? nodoOrigem.obterValorAresta(destino) : -1;
    }

    public BigInteger swim(String nodoInicial) {
        long startTime = System.currentTimeMillis();

        Map<String, Integer> checkins = new HashMap<>();
        for (String nodoNome : nodos.keySet()) {
            checkins.put(nodoNome, 0);
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

            Nodo nodo = nodos.get(nodoAtual);
            if (nodo != null) {
                for (String vizinho : nodo.obterVizinhos()) {
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

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Executado em: " + duration + " ms");

        return obterValorNodo("ouro");
    }
}

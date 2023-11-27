package entities;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Nodo {
    private Map<String, Integer> arestas = new HashMap<>();
    private BigInteger valor = BigInteger.ZERO;

    public void adicionarVizinho(String vizinho) {
        arestas.put(vizinho, 0);
    }

    public void adicionarAresta(String vizinho, int valorAresta) {
        arestas.put(vizinho, valorAresta);
    }

    public void atribuirValor(BigInteger novoValor) {
        valor = novoValor;
    }

    public BigInteger obterValor() {
        return valor;
    }

    public int obterValorAresta(String vizinho) {
        return arestas.getOrDefault(vizinho, 0);
    }

    public Set<String> obterVizinhos() {
        return arestas.keySet();
    }
}
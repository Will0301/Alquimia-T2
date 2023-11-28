package service;

import entities.Grafo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderService {

    public static void carregarArquivo(Grafo grafo, File arquivo) {
        try {
            List<String> linhas = Files.readAllLines(Path.of(arquivo.getPath()));
            for (String linha : linhas) {
                processarLinha(grafo, linha);
            }
        } catch (IOException e) {
            System.out.println("Erro! Arquivo não encontrado \n" +
                    "Mensagem de erro: " + e.getMessage() + "\n" +
                    "Causa do erro: " + e.getCause());
        }
    }

    private static void processarLinha(Grafo grafo, String linha) {
        String[] partes = linha.split(" ");

        String destino = partes[partes.length - 1];
        grafo.adicionarNodo(destino);

        for (int j = 0; !partes[j].equals("->"); j += 2) {
            int valorAresta = Integer.parseInt(partes[j]);
            String origem = partes[j + 1];

            grafo.adicionarNodo(origem);
            grafo.adicionarAresta(origem, destino, valorAresta);
        }
    }
}

package service;

import entities.Grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FileReaderService {

    public static void carregarArquivo(Grafo grafo, File arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo.getPath()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                processarLinha(grafo, linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo");
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

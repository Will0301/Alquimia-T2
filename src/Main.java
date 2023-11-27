import service.FileReaderService;
import entities.Grafo;

import java.io.File;
import java.math.BigInteger;

public class Main {

    static final FileReaderService fileReaderService = new FileReaderService();

    public static void main(String[] args) {
        caseOne("teste1.txt");
    }

    private static void caseOne(String filePath){
        Grafo grafo = new Grafo();
        File testFile = new File(filePath);

        fileReaderService.carregarArquivo(grafo, testFile);
        System.out.println("--------PRIMEIRO CASO--------");
        grafo.atribuirValorAresta("hidrogenio", BigInteger.ONE);
        System.out.println(grafo.swim("hidrogenio"));
    }
}

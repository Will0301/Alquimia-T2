import service.FileReaderService;
import entities.Grafo;

import java.io.File;
import java.math.BigInteger;

public class Main {

    static final FileReaderService fileReaderService = new FileReaderService();

    public static void main(String[] args) {
        caseOne("src/testes/z150.txt");
        caseTwo("src/testes/z200.txt");
        caseThree("src/testes/z300.txt");
        caseFour("src/testes/z350.txt");
    }

    private static void caseOne(String filePath){
        Grafo grafo = new Grafo();
        File testFile = new File(filePath);

        System.out.println("--------PRIMEIRO CASO--------");
        fileReaderService.carregarArquivo(grafo, testFile);
        grafo.atribuirValorAresta("hidrogenio", BigInteger.ONE);
        System.out.println(grafo.swim("hidrogenio"));
        System.out.println();
    }

    private static void caseTwo(String filePath){
        Grafo grafo = new Grafo();
        File testFile = new File(filePath);

        System.out.println("--------SEGUNDO CASO--------");
        fileReaderService.carregarArquivo(grafo, testFile);
        grafo.atribuirValorAresta("hidrogenio", BigInteger.ONE);
        System.out.println(grafo.swim("hidrogenio"));
        System.out.println();
    }

    private static void caseThree(String filePath){
        Grafo grafo = new Grafo();
        File testFile = new File(filePath);

        System.out.println("--------TERCEIRO CASO--------");
        fileReaderService.carregarArquivo(grafo, testFile);
        grafo.atribuirValorAresta("hidrogenio", BigInteger.ONE);
        System.out.println(grafo.swim("hidrogenio"));
        System.out.println();
    }

    private static void caseFour(String filePath){
        Grafo grafo = new Grafo();
        File testFile = new File(filePath);

        System.out.println("--------QUARTO CASO--------");
        fileReaderService.carregarArquivo(grafo, testFile);
        grafo.atribuirValorAresta("hidrogenio", BigInteger.ONE);
        System.out.println(grafo.swim("hidrogenio"));
        System.out.println();
    }
}

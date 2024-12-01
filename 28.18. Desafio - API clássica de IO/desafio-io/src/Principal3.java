

import java.io.File;
import java.io.IOException;

public class Principal3 {

    public static void main(String[] args) {
        try {
            var escritor = new EscritorArquivoMaiusculo(
                    new File("28.18. Desafio - API clássica de IO/desafio-io/arquivos/textos/poema1.txt"),
                    new File("28.18. Desafio - API clássica de IO/desafio-io/arquivos/textos/poema2.txt"));
            escritor.processar();
        } catch (IOException e) {
            System.out.println("Erro processando e escrevendo novo arquivo");
            e.printStackTrace();
        }
    }

}

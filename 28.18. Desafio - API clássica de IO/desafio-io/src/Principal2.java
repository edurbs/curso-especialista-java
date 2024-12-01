

import java.io.File;
import java.io.IOException;

public class Principal2 {

    public static void main(String[] args) {
        try {
            var unificador = new UnificadorDeArquivos(
                    new File("28.18. Desafio - API clássica de IO/desafio-io/arquivos/fotos/picanha-unificado.jpg"));
            unificador.unificar();
        } catch (IOException e) {
            System.out.println("Erro ao unificar arquivos");
            e.printStackTrace();
        }
    }

}

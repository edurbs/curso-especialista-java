import java.io.File;
import java.io.IOException;

public class Principal1 {

    public static void main(String[] args) {
        try {
            var fragmentador = new FragmentadorDeArquivo(
                    new File("28.18. Desafio - API clássica de IO/desafio-io/arquivos/fotos/picanha.jpg"),
                    1024 * 50);
            fragmentador.fragmentar();
        } catch (IOException e) {
            System.out.println("Erro fragmentando arquivo");
            e.printStackTrace();
        }
    }

}

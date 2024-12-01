import com.algaworks.crm.Cliente;
import com.algaworks.crm.Endereco;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class Serializacao {

    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua das Ameixas", "1000", "Centro");
        Cliente cliente = new Cliente("João da Silva", endereco, new BigDecimal("100000"));

        System.out.println(cliente);

        // TODO implementar serialização
        Path pathCliente = Path.of("/home/eduardo/IdeaProjects/curso-especialista-java/30.08. Desafio - serialização de objetos/desafio-serializacao/src/com/algaworks/crm/cliente");
        Path pathEndereco = Path.of("/home/eduardo/IdeaProjects/curso-especialista-java/30.08. Desafio - serialização de objetos/desafio-serializacao/src/com/algaworks/crm/endereco");
        serialize(pathCliente, cliente);
        serialize(pathEndereco, endereco);

    }

    private static <T extends Serializable> void serialize(Path path, T aClass) {
        try (var outputStream = new ObjectOutputStream(Files.newOutputStream(path, WRITE, CREATE, StandardOpenOption.TRUNCATE_EXISTING))) {
            outputStream.writeObject(aClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

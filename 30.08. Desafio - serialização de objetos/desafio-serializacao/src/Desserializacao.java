import com.algaworks.crm.Cliente;
import com.algaworks.crm.Endereco;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.*;

public class Desserializacao {

    public static void main(String[] args) {
        Cliente cliente = null; // TODO implementar desserialização
        Endereco endereco = null;

        Path pathCliente = Path.of("/home/eduardo/IdeaProjects/curso-especialista-java/30.08. Desafio - serialização de objetos/desafio-serializacao/src/com/algaworks/crm/cliente");
        Path pathEndereco = Path.of("/home/eduardo/IdeaProjects/curso-especialista-java/30.08. Desafio - serialização de objetos/desafio-serializacao/src/com/algaworks/crm/endereco");

        endereco = desserialize(pathEndereco, endereco);
        cliente = desserialize(pathCliente, cliente);

        System.out.println(cliente);
    }

    private static <T extends Serializable> T desserialize(Path path, T aClass) {
        try(var inputStream = new ObjectInputStream(Files.newInputStream(path, READ))){
            return (T) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

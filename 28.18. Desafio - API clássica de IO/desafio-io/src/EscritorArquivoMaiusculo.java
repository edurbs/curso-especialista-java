import java.io.*;

public class EscritorArquivoMaiusculo {
    private final File oldFile;
    private final File newFile;

    public EscritorArquivoMaiusculo(File oldFile, File newFile) {
        this.oldFile = oldFile;
        this.newFile = newFile;
    }

    public void processar() throws IOException {
        write(read());
    }

    private String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(oldFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line.toUpperCase());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private void write(String inputString) throws IOException {
        try (FileWriter fileWriter = new FileWriter(newFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write(inputString);
        }
    }
}

import java.io.*;

public class FragmentadorDeArquivo {
    private final File file;
    private final int part;

    public FragmentadorDeArquivo(File file, int part) {
        this.file = file;
        this.part = part;
    }

    public void fragmentar() throws IOException {
        File path = file.getParentFile();
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis, part)) {
            byte[] content = new byte[part];
            int count = 1;
            int bytesRead;
            while ((bytesRead = bis.read(content)) > 0) {
                read(path, count, content, bytesRead);
                count++;
            }
        }
    }

    private void read(File path, int count, byte[] content, int bytesRead) throws IOException {
        File newFile = new File(path, "file" + count);
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            fileOutputStream.write(content, 0, bytesRead);
        }
    }
}

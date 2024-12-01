import java.io.*;

public class UnificadorDeArquivos {
    private final File newFile;
    public UnificadorDeArquivos(File newFile) {
        this.newFile = newFile;
    }

    public void unificar() throws IOException {
        File path = newFile.getParentFile();
        int counter = 1;
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        File file = getFile(path, counter);
        while (file.exists()){
            readAndWrite(file, fileOutputStream);
            counter++;
            file = getFile(path, counter);
        }
        fileOutputStream.close();
    }

    private void readAndWrite (File fileInput, FileOutputStream fos) throws IOException {
        FileInputStream fis = new FileInputStream(fileInput);
        byte[] content = new byte[1024*50];
        int bytesRead;
        while((bytesRead = fis.read(content))>0){
            fos.write(content, 0, bytesRead);
        }
        fis.close();
        fileInput.delete();
    }

    private File getFile(File path, int counter) {
        return new File(path, "file" + counter);
    }
}

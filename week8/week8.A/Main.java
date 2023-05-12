import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] sourceFiles = {
                new File("src/source/wallpaper2.jpeg"),
                new File("src/source/wallpaper3.jpeg"),
                new File("src/source/wallpaper4.jpeg")
        };
        File[] targetFiles = {
                new File("src/target/wall2.jpeg"),
                new File("src/target/wall3.jpeg"),
                new File("src/target/wall4.jpeg")
        };

        for (int i = 0; i < sourceFiles.length; i++) {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFiles[i]));
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetFiles[i]));
            ) {
                byte[] buffer = new byte[4096];
                int numBytes;
                while ((numBytes = bufferedInputStream.read(buffer)) != -1) {
                    bufferedOutputStream.write(buffer, 0, numBytes);
                }
                System.out.println("For " + sourceFiles[i].getName() + " " + sourceFiles[i].length() + " bytes copied");
            } catch (IOException ex) {
                System.out.format("I/O error: %s%n", ex);
            }
        }
    }
}

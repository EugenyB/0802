import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReplacementInFile {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("file.txt"));
             PrintWriter writer = new PrintWriter("outfile.txt")
        ){
            String line = null;
            while ((line=reader.readLine())!=null) {
                String s = line.replaceAll("her", "his");
                writer.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

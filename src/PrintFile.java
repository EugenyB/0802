import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrintFile {
    public static void main(String[] args) {
        String filename = "file.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // 1
//            String line = reader.readLine();
//            while (line!=null) {
//                System.out.println(line);
//                line = reader.readLine();
//            }
            // 2
//            String line = null;
//            while((line = reader.readLine())!=null) {
//                System.out.println(line);
//            }
            // 3
            reader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

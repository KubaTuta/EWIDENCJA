import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

   public static void main(String[] args) {
//       Scanner scanner = new Scanner(System.in);
//       String text = scanner.nextLine();
//       System.out.println("Podałeś tekst: " + text);
//
//       writeTextToFile(text);

       try {
           System.out.println("zawartość pliku");
           Path path = Paths.get(FILE_PATH);
//           String[] strings = Files.readAllLines(path).toArray(new String[0]);
           List<String> strings = Files.readAllLines(path, StandardCharsets.UTF_8);
           for(String fileText : strings){
               String[] parts = fileText.split(";");
              for (String part : parts) {
                  System.out.print(part + "; ");
              }
               System.out.println(" ");
               System.out.println("-------------------------------------------------------------");
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }

//    private static void writeTextToFile(String text) {
//        try {
//            FileWriter fileWriter = new FileWriter(FILE_PATH);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.print("Podałeś: ");
//            printWriter.print(text);
//            printWriter.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

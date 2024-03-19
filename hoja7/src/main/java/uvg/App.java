package uvg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("TRADUCTOR GOOGLE");
        Scanner teclado = new Scanner(System.in);
        FileManager editor = new FileManager();
        ArrayList<String> lines = editor.readTXTFile("/dictionary.txt");
        BST<Association<String, String>> dictionary = new BST<>();
        for (int i = 0; i < lines.size(); i++) {
            ArrayList<String> chunks = Chunks.getChunks(lines.get(i));
            for (String chunk : chunks) {
                // separating english and spanish
                String[] part = chunk.substring(1, chunk.length() - 1).split(",");
                String key = part[0].trim(); // english
                String value = part[1].trim(); // spanish
                Association<String, String> entry = new Association<>(key, value);
                dictionary.add(entry);
            }
        }
        System.out.println(dictionary);
        System.out.println("Ingrese su oracion para traducir: ");
        String input = teclado.nextLine();

        String[] words = input.split("\\s+");

        StringBuilder translateGoogle = new StringBuilder();
        for (String word : words) {
            Association<String, String> a = new Association<>(word.toLowerCase(), "");
            Association<String, String> translatedWord = dictionary.get(a);
        }
    }
}

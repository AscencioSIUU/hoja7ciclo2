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
        ArrayList<String> files = editor.readTXTFile("/prueba1.txt");
        for(String file : files){
            String[] words = file.split("\\s+");

            StringBuilder GoogleTranslate = new StringBuilder();
            for (String word : words) {
                Association<String, String> a = new Association<>(word.toLowerCase(), "");
                Association<String, String> translatedWord = dictionary.get(a);
                if (translatedWord != null) {
                    GoogleTranslate.append(translatedWord.getValue()).append(" ");
    
                } else {
                    GoogleTranslate.append("*").append(word).append("*").append(" ");
                }
            }
            System.out.println("Traduccion: " + GoogleTranslate);
        }
    }
}

package uvg;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("TRADUCTOR GOOGLE");
        FileManager editor = new FileManager();
        ArrayList<String> line = editor.readTXTFile("resources/dictionary.txt");
    }
}

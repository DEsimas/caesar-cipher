package Programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import BinaryTree.BinaryTree;

public class Dictionary {
    private static BinaryTree dictionary;

    public static void read(String path) {
        dictionary = new BinaryTree();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine())
                dictionary.insert(scanner.nextLine());

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new Error("Dictionary not found");
        }
    }

    public static Boolean has(String word) {
        return dictionary.has(word.toLowerCase());
    }
}

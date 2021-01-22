package homework16.task2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Программа принимает на вход английский текст, произвольной длины,
 * обрабатывает его и выводит все слова, которые встречаются в тексте (без
 * дубликатов) группируя их по первой букве в алфавитном порядке. Знаки
 * препинания игнорируются. Регистр заглавных букв не учитывается.
 * <p>
 * Входной текст:
 * Once upon a time a Wolf was lapping at a spring on a hillside, when, looking
 * up, what should he see but a Lamb just beginning to drink a little lower down.
 *
 * Результат работы программы:
 * A: a at
 * B: but beginning
 * D: drink down
 * ….
 * И так далее…
 */

public class Runner {

    public static void main(String[] args) {

        final String regex = "regex";
        final Pattern pattern = Pattern.compile(regex);
        StringBuilder fileData = new StringBuilder();

        try (FileReader fileReader = new FileReader("D:/Self/Java/GitRepo/JavaClasses/src/homework16/task2/task.txt")) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                fileData.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file. Please, check if the file exists");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(fileData.toString());



    }

}

package homework16.task2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
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
 * <p>
 * Результат работы программы:
 * A: a at
 * B: but beginning
 * D: drink down
 * ….
 * И так далее…
 */

public class Runner {

    public static void main(String[] args) {

        //блок для чтения текста из файла закоментирован для простоты проверки
//        StringBuilder fileData = new StringBuilder();
//        try (FileReader fileReader = new FileReader("D:/JavaClasses/src/homework16/task2/task.txt")) {
//            Scanner scanner = new Scanner(fileReader);
//            while (scanner.hasNextLine()) {
//                fileData.append(scanner.nextLine()).append("\n");
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to find the file. Please, check if the file exists");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(fileData.toString());
//        String text = fileData.toString().replaceAll("\\p{Punct}", "").replaceAll("\n", " ").toLowerCase();

        String text = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking\n" +
                "up, what should he see but a Lamb just beginning to drink a little lower down.";
        System.out.println(text);

        getWordsSameLetterStartsWith(text);
    }

    public static String getWordsSameLetterStartsWith(String text) {
        text = text.replaceAll("\\p{Punct}", "").replaceAll("\n", " ").toLowerCase();
        List<String> listAllWords = new ArrayList<>(Arrays.asList(text.split(" ")));
        List<String> listWords = new ArrayList<>();
        Collections.sort(listAllWords);

        listWords.add(listAllWords.get(0));
        for (int i = 1; i < listAllWords.size(); i++) {
            if (!listAllWords.get(i).equals(listAllWords.get(i - 1))) {
                listWords.add(listAllWords.get(i));
            }
        }
        String firstLetter = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listWords.size(); i++) {
            if (i == 0) {
                firstLetter = listWords.get(i).substring(0, 1).toUpperCase();
                System.out.print(firstLetter + ": " + listWords.get(i));
                sb.append(firstLetter).append(": ").append(listWords.get(i));
            } else {
                if (firstLetter.equals(listWords.get(i).substring(0, 1).toUpperCase())) {
                    System.out.print(" " + listWords.get(i));
                    sb.append(" ").append(listWords.get(i));
                } else {
                    firstLetter = listWords.get(i).substring(0, 1).toUpperCase();
                    System.out.print("\n" + firstLetter + ": " + listWords.get(i));
                    sb.append("\n").append(firstLetter).append(": ").append(listWords.get(i));
                }
            }
        }
        return sb.toString();
    }
}

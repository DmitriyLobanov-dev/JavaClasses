package homework17.allTasks;

import Homework12.BoxMaterial;
import Homework12.HeavyBox;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {

        String str = "Жыве!";
        String nullStr = null;
        String emptyStr = "";

        System.out.println("Task1 ----------------------------------------------");
        // Task1. Написать лямбда выражение для интерфейса Printable, который содержит один метод void print().
        Printable<String> printable = i -> System.out.println(i);
        printable.print(str);
        System.out.println();

        System.out.println("Task2 ----------------------------------------------");
        // Task2. Создать лямбда выражение, которое возвращает значение true, если строка не null, используя функциональный интерфейс Predicate.
        Predicate<String> stringNotNull = i -> i != null;
        System.out.println(stringNotNull.test(str));
        Predicate<String> stringNotNull2 = Objects::nonNull; //этот способ подсказывает Идея
        System.out.println(stringNotNull2.test(nullStr));
        System.out.println();

        System.out.println("Task3 ----------------------------------------------");
        // Task3. Создать лямбда выражение, которое проверяет, что строка не пуста, используя функциональный интерфейс Predicate.
        Predicate<String> stringNotEmpty = (i) -> i != "";
        System.out.println(stringNotEmpty.test(str));
        System.out.println(stringNotEmpty.test(emptyStr));
        System.out.println();

        System.out.println("Task4 ----------------------------------------------");
        // Task5. Написать программу проверяющую, что строка не null и не пуста, используя метод and() функционального интерфейса Predicate.
        System.out.println(stringNotNull.and(stringNotEmpty).test(str));
        System.out.println(stringNotNull.and(stringNotEmpty).test(nullStr));
        System.out.println(stringNotNull.and(stringNotEmpty).test(emptyStr));
        System.out.println();

        System.out.println("Task5 ----------------------------------------------");
        // Task5. Написать программу, которая проверяет, что строка начинается буквой “J” или “N” и заканчивается “A”. Используем функциональный интерфейс Predicate.
        Predicate<String> startsWithJ = (i) -> i.startsWith("J");
        Predicate<String> startsWithN = (i) -> i.startsWith("N");
        Predicate<String> endsWithA = (i) -> i.endsWith("A");
        System.out.println(startsWithJ.or(startsWithN).and(endsWithA).test("JANNA"));
        System.out.println(startsWithJ.or(startsWithN).and(endsWithA).test("JACK"));
        System.out.println(startsWithJ.or(startsWithN).and(endsWithA).test("NANANA"));
        System.out.println(startsWithJ.or(startsWithN).and(endsWithA).test("NEO"));
        System.out.println();

        System.out.println("Task6 ----------------------------------------------");
        /* Task6. Написать лямбда выражение, которое принимает на вход объект типа HeavyBox и выводит на консоль сообщение “Отгрузили ящик с весом n”. “Отправляем ящик с весом n”
        Используем функциональный интерфейс Consumer и метод по умолчанию andThen. */
        HeavyBox box = new HeavyBox(200, 21, BoxMaterial.WOOD);
        Consumer<HeavyBox> boxTransfer = (i) -> System.out.println("Отгрузили ящик с весом " + i.getWeight() + "." + "\n" + "Отправляем ящик с весом " + i.getWeight() + ".");
        boxTransfer.accept(box);
        System.out.println();

        System.out.println("Task7 ----------------------------------------------");
        /* Task7. Написать лямбда выражение, которое принимает на вход число и возвращает значение “Положительное число”, “Отрицательное число” или “Ноль”.
        Используем функциональный интерфейс Function */
        Function<Integer, String> checkNumber = (i) -> {
            String result;
            if (i < 0) {
                result = "Отрицательное число";
            } else if (i > 0) {
                result = "Положительное число";
            } else result = "Ноль";
            return result;
        };
        System.out.println(checkNumber.apply(10));
        System.out.println();

        System.out.println("Task8 ----------------------------------------------");
        // Task8. Написать лямбда выражение, которое возвращает случайное число от 0 до 10. Используем функциональный интерфейс Supplier.
        final int min = 0;
        int max = 10;
        final int finalMax = max - min;
        Supplier getRndInt = () -> (int) (Math.random() * finalMax) + min;
        System.out.println(getRndInt.get());
        System.out.println();

        System.out.println("Task9 ----------------------------------------------");
        // Task9. Переделать класс использующий Printable используя ссылку на статический метод.
        // Я не понял что нужно делать )
        Printable<String> printable2 = System.out::println; //так?
        printable2.print(str);
        System.out.println("Понять и простить");
        System.out.println();

        //Задачи на Stream API:

        //System.out.println("Task10 ----------------------------------------------");
        //  Task10. Дана коллекция строк:
        List<String> list = new ArrayList<>();
        list.add("line0");
        list.add("line1");
        list.add("line2");
        list.add("line1");
        list.add("line4");
        list.add("line1");
        list.add("a line7");
        list.add("a line6");
        list.add("line5");
        list.add("line8");
        List<String> emptyList = new ArrayList<>();

        System.out.println("Task10a ----------------------------------------------");
        //10.a) Получить первый элемент коллекции или 0, если коллекция пуста
        System.out.println(list.stream().findFirst().orElse("0"));
        System.out.println(emptyList.stream().findFirst().orElse("0"));
        System.out.println();

        System.out.println("Task10b ----------------------------------------------");
        //10.b) Получить количество вхождений строки «line1»
        System.out.println(list.stream().filter(i -> i.equals("line1")).count());
        System.out.println();

        System.out.println("Task10c ----------------------------------------------");
        //10.c) Получить последний элемент коллекции или «empty», если коллекция пуста
        System.out.println(list.stream().sorted((a, b) -> b.compareTo(a)).findFirst().orElse("empty"));
        System.out.println(emptyList.stream().sorted(Comparator.reverseOrder()).findFirst().orElse("empty"));
        System.out.println();

        System.out.println("Task10d ----------------------------------------------");
        //10.d) Получить два элемента коллекции, начиная со второго
        list.stream().filter(i -> !i.equals(list.get(0))).limit(2).forEach(el -> System.out.println(el));
        list.stream().filter(i -> !i.equals(list.get(0))).limit(2).forEach(System.out::println); //этот способ подсказывает Идея
        System.out.println();

        System.out.println("Task10e ----------------------------------------------");
        //10.e) Получить все элементы, которые начинаются на букву «а»
        list.stream().filter(i -> i.startsWith("a")).forEach(System.out::println);
        System.out.println();

        System.out.println("Task10f ----------------------------------------------");
        //10.f) Найти существуют ли хоть один «line8» элемент в коллекции
        System.out.println(list.stream().anyMatch(i -> i.equals("line8")));
        System.out.println();

        System.out.println("Task10g ----------------------------------------------");
        //10.g) Найти есть ли символ «1» у всех элементов коллекции
        List<String> list2 = new ArrayList<>();
        list2.add("line0");
        list2.add("line1");
        list2.add("line2");
        System.out.println(list2.stream().map(s -> s.split("")).allMatch(i -> Arrays.stream(i).anyMatch(s -> s.equals("1"))));
        System.out.println();

        System.out.println("Task10h ----------------------------------------------");
        //10.h) Отсортировать коллекцию строк по алфавиту и убрать дубликаты
        List<String> list3 = new ArrayList<>();
        list3.add("Sex");
        list3.add("Rock n' Roll");
        list3.add("Drugs");
        list3.add("Drugs");
        list3.add("Drugs");
        list3.stream().sorted(String::compareTo).distinct().forEach(System.out::println);
        System.out.println();

        // Task11. Дана коллекция объектов класса People. Поля класса: name, age, sex.
        Set<People> peopleSet = new HashSet<>();
        peopleSet.add(new People("Philip J. Fry", 25, Sex.MALE));
        peopleSet.add(new People("Turanga Leela", 25, Sex.FEMALE));
        peopleSet.add(new People("Bender Bending Rodriguez", 6, Sex.MALE));
        peopleSet.add(new People("Hubert J. Farnsworth", 161, Sex.MALE));
        peopleSet.add(new People("Doctor John Zoidberg", 88, Sex.MALE));
        peopleSet.add(new People("Amy Wong", 21, Sex.FEMALE));
        peopleSet.add(new People("Hermes Conrad", 42, Sex.MALE));

        System.out.println("Task11a ----------------------------------------------");
        //11.a) Получить мужчин-военнообязанных (от 18 до 27 лет)
        peopleSet.stream().filter(male -> male.getSex().equals(Sex.MALE) && male.getAge() >= 18 && male.getAge() <= 27)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Task11b ----------------------------------------------");
        //11.b) Получить средний возраст женщин
        System.out.println(peopleSet.stream().filter(sex -> sex.getSex().equals(Sex.FEMALE))
                .mapToInt(People::getAge).average().getAsDouble());
        System.out.println();

        System.out.println("Task11c ----------------------------------------------");
        //11.c) Получить кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        System.out.println(peopleSet.stream()
                .filter(people -> people.getSex().equals(Sex.MALE) && people.getAge() >= 18 && people.getAge() <= 60 ||
                        people.getSex().equals(Sex.FEMALE) && people.getAge() >= 18 && people.getAge() <= 55)
                .count());
        // почему не получается через dropWhile ?????
        System.out.println(peopleSet.stream()
                .dropWhile(dropShe -> dropShe.getAge() < 18 && dropShe.getAge() >= 55 && dropShe.getSex().equals(Sex.FEMALE))
                .dropWhile(dropHe -> dropHe.getAge() < 18 && dropHe.getAge() >= 60 && dropHe.getSex().equals(Sex.MALE))
                .count());
        System.out.println();

        System.out.println("Task11d ----------------------------------------------");
        //11.d) Отсортировать коллекцию людей по имени в обратном алфавитном порядке
        peopleSet.stream().sorted((a, b) -> b.compareTo(a)).forEach(i -> System.out.println(i));
        peopleSet.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();

        System.out.println("Task11e ----------------------------------------------");
        //11.e) Получить человека с минимальным возрастом
        System.out.println(peopleSet.stream().min(new PeopleAgeComparator()).get()); //почему без get выводит с Optional????
        System.out.println("kill all humans!");
        System.out.println();

        /* Task12. Дана коллекция строк, состоящих из буквы и числа «a1», «a2», «a3», «a1»,...
                   и коллекция строк, сотоящих из цифр «1,2,0», «4,5», «1023,231», «34,0», ... */
        List<String> strNum = new ArrayList<>();
        List<String> figures = new ArrayList<>();
        strNum.add("a1");
        strNum.add("a2");
        strNum.add("a3");
        strNum.add("a1");
        strNum.add("a2");
        strNum.add("a3");
        figures.add("1,2,0");
        figures.add("4,5");
        figures.add("1023,231");
        figures.add("34,0");

        System.out.println("Task12a ----------------------------------------------");
        //12.a) Из первой коллекции убрать первый символ и вернуть массив чисел (int[])
        int[] array = strNum.stream().mapToInt(strEl -> Integer.parseInt(strEl.substring(1))).toArray();
        Arrays.stream(array).forEach(System.out::println);
        System.out.println();

        System.out.println("Task12b ----------------------------------------------");
        //12.b) Из второй коллекции получить все числа, перечисленные через запятую
        figures.stream().map(s -> s.split(",")).flatMap(Arrays::stream).forEach(s -> System.out.print(s + ", "));
        System.out.println("\n");

        System.out.println("Task12c ----------------------------------------------");
        //12.c) Из второй коллекции получить сумму всех чисел
        System.out.println(figures.stream().map(s -> s.split(",")).flatMap(Arrays::stream).mapToInt(Integer::parseInt).reduce((a, b) -> a + b).getAsInt());
        System.out.println();

        System.out.println("Task12d ----------------------------------------------");
        //12.d) Получить максимальное значение из всех чисел
        System.out.println(figures.stream().map(s -> s.split(",")).flatMap(Arrays::stream).mapToInt(Integer::parseInt).max().getAsInt());
        System.out.println();

        System.out.println("Task12e ----------------------------------------------");
        //12.e) Преобразовать первую коллекцию в Map, где первый символ – ключ, второй – значение
        Map<String, String> map = strNum.stream().collect(Collectors.toMap(s -> s.substring(0, 1), s -> s.substring(1)));
        //ловим IllegalStateException: Duplicate key a (attempted merging values 1 and 2) не придумал как избавится от дубликатов
//      map.entrySet().stream().forEach(System.out::println);


    }

}

package homework18.task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * В текстовом файле лежат данные о покупателях и их покупках (в любом удобном формате).
 * Создать классы Клиент (покупатель) и Покупка. Создать класс ClientRepository, в котором
 * разместить методы для работы с файлом: добавить нового покупателя со списком покупок, по
 * id покупателя найти список его покупок, по email найти покупателя (учитывать то, что
 * покупателя с нужным id или email может не быть, использовать Optional для возвращаемых
 * значений методов). Написать класс main с использованием методов класса ClientRepository.
 */

public class Runner {

    public static void main(String[] args) {

       //reading the source file and printing the content
       ClientRepository.getAllExistingCustomersFromFile().stream().sorted((a,b) -> (int) (a.getID() - b.getID())).forEach(System.out::println);

        System.out.println("\n" + "----------------------------------------------------------------------------------------" + "\n");

       //getting customer's shop list by his ID <Optional>
        System.out.println(ClientRepository.getPurchasesByID(2));

        System.out.println("\n" + "----------------------------------------------------------------------------------------" + "\n");

        //getting customer by his email <Optional>
        System.out.println(ClientRepository.getCustomerByEmail("customer4@email.com"));
        System.out.println(ClientRepository.getCustomerByEmail("customer10@email.com")); //doesn't exist

        System.out.println("\n" + "----------------------------------------------------------------------------------------" + "\n");

        //getting customer by his ID <Optional>
        System.out.println(ClientRepository.getCustomerByID(5));
        System.out.println(ClientRepository.getCustomerByID(50)); //doesn't exist

        System.out.println("\n" + "----------------------------------------------------------------------------------------" + "\n");

        //adding new customer with a purchase list and writing to the file
        ArrayList<Purchase> newPurchases = new ArrayList<>();
        newPurchases.add(new Purchase("milk"));
        newPurchases.add(new Purchase("sugar"));

        try {
            ClientRepository.writeCustomersFile(ClientRepository.addNewCustomer("name7", "customer7@email.com", newPurchases));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

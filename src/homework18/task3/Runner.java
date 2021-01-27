package homework18.task3;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        PropertyConfigurator.configure("Log4j.properties");
        Logger log = LoggerFactory.getLogger(Runner.class.getName());

        ClientRepository clientRepository = new ClientRepository();

       //reading the source file and printing the content
        clientRepository.getAllExistingCustomersFromFile().stream().sorted(Comparator.comparingLong(Customer::getID)).forEach(el -> log.info(String.valueOf(el)));

        log.info("\n" + "----------------------------------------------------------------------------------------" + "\n");

       //getting customer's shop list by his ID <Optional>
        log.info(clientRepository.getPurchasesByID(2).toString());

        log.info("\n" + "----------------------------------------------------------------------------------------" + "\n");

        //getting customer by his email <Optional>
        log.info(clientRepository.getCustomerByEmail("customer4@email.com").toString());
        log.info(clientRepository.getCustomerByEmail("customer10@email.com").toString()); //doesn't exist

        log.info("\n" + "----------------------------------------------------------------------------------------" + "\n");

        //getting customer by his ID <Optional>
        log.info(clientRepository.getCustomerByID(5).toString());
        log.info(clientRepository.getCustomerByID(50).toString()); //doesn't exist

        log.info("\n" + "----------------------------------------------------------------------------------------" + "\n");

        //adding new customer with a purchase list and writing to the file
        ArrayList<Purchase> newPurchases = new ArrayList<>();
        newPurchases.add(new Purchase("milk"));
        newPurchases.add(new Purchase("sugar"));

        try {
            clientRepository.writeCustomersFile(clientRepository.addNewCustomer("name7", "customer7@email.com", newPurchases));
        } catch (IOException e) {
            log.info("Error while adding new customer to the file " + e.getMessage());
        }


    }
}

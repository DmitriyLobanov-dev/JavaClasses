package homework18.task3;

import java.io.*;
import java.util.*;

/**
 * В текстовом файле лежат данные о покупателях и их покупках (в любом удобном формате).
 * Создать классы Клиент (покупатель) и Покупка. Создать класс ClientRepository, в котором
 * разместить методы для работы с файлом: добавить нового покупателя со списком покупок, по
 * id покупателя найти список его покупок, по email найти покупателя (учитывать то, что
 * покупателя с нужным id или email может не быть, использовать Optional для возвращаемых
 * значений методов). Написать класс main с использованием методов класса ClientRepository.
 */

public class ClientRepository {

    public static final File SOURCE = new File("D:\\JavaClasses\\src\\homework18\\task3\\CustomersList");
    public static final File SOURCE_NEW = new File("D:\\JavaClasses\\src\\homework18\\task3\\CustomersList_added");

    //Parse input file. Return HashSet collection with customers
    public static Set<Customer> getAllExistingCustomersFromFile() {
        Set<Customer> customers = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SOURCE))) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String[] customerLine = scanner.nextLine().replaceAll(" ", "").split("[|]+");
                long ID = Long.parseLong(customerLine[0]);
                String name = customerLine[1];
                String email = customerLine[2];
                if (customerLine.length > 3) {
                    List<Purchase> purchases = new ArrayList<>();
                    String[] purchasesArr = customerLine[3].split(",");
                    for (String s : purchasesArr) {
                        purchases.add(new Purchase(s));
                    }
                    customers.add(new Customer(ID, name, email, purchases));
                } else {
                    customers.add(new Customer(ID, name, email));
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    //write HashSet<Customer> collection into file
    public static void writeCustomersFile(Set<Customer> customers) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(SOURCE_NEW));
        customers.stream().sorted((a, b) -> (int) (a.getID() - b.getID())).forEach(customer -> {
            try {
                if (customer.getShopList() == null) {
                    writer.write(customer.getID() + " || " + customer.getName() + " || " + customer.getEmail() + " || " + "\n");
                } else {
                    writer.write(customer.getID() + " || " + customer.getName() + " || " + customer.getEmail() + " || " + customer.getShopList().toString()
                            .replaceAll("[\\[\\]]", "") + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }

    //Add new customer and his shop list
    public static Set<Customer> addNewCustomer(String name, String email, List<Purchase> purchases) {
        Set<Customer> newCustomersCollection = getAllExistingCustomersFromFile();
        long newID = newCustomersCollection.stream().max((a, b) -> (int) (a.getID() - b.getID())).get().getID() + 1;
        if (purchases.isEmpty()) {
            newCustomersCollection.add(new Customer(newID, name, email));
        } else {
            newCustomersCollection.add(new Customer(newID, name, email, purchases));
        }
        return newCustomersCollection;
    }

    //Get customer's shop list by his ID <Optional>
    public static Optional<List<Purchase>> getPurchasesByID(long ID) {
        if (getAllExistingCustomersFromFile().stream().filter(customer2 -> customer2.getID() == ID).findFirst().isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(getAllExistingCustomersFromFile().stream().filter(customer2 -> customer2.getID() == ID).findFirst().get().getShopList());
    }

    //Get customer by his email <Optional>
    public static Optional<Customer> getCustomerByEmail(String email) {
        if (getAllExistingCustomersFromFile().stream().filter(customer -> customer.getEmail().equals(email)).findFirst().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(getAllExistingCustomersFromFile().stream().filter(customer -> customer.getEmail().equals(email)).findFirst().get());
    }

    //Get customer by his ID <Optional>
    public static Optional<Customer> getCustomerByID(long ID) {
        if (getAllExistingCustomersFromFile().stream().filter(customer -> customer.getID() == ID).findFirst().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(getAllExistingCustomersFromFile().stream().filter(customer -> customer.getID() == ID).findFirst().get());
    }


}

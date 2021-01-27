package homework19.task2;

import org.apache.log4j.PropertyConfigurator;

public class Runner {

    public static void main(String[] args) {

        PropertyConfigurator.configure("Log4j.properties");

        Thread ship1 = new Thread(new Ship(true, true, 50, 35));
        Thread ship2 = new Thread(new Ship(false, true, 50, 10));
        Thread ship3 = new Thread(new Ship(true, false, 50, 40));
        Thread ship4 = new Thread(new Ship(true, false, 50, 35));
        Thread ship5 = new Thread(new Ship(true, true, 50, 50));
        Thread ship6 = new Thread(new Ship(true, true, 40, 35));
        Thread ship7 = new Thread(new Ship(true, true, 50, 20));
        Thread ship8 = new Thread(new Ship(true, true, 50, 50));
        Thread ship9 = new Thread(new Ship(false, true, 50, 0));
        Thread ship10 = new Thread(new Ship(false, true, 50, 0));

        ship1.start();
        ship2.start();
        ship3.start();
        ship4.start();
        ship5.start();
        ship6.start();
        ship7.start();
        ship8.start();
        ship9.start();
        ship10.start();
    }
}

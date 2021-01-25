package homework19.task3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Имеются один или несколько производителей, генерирующих данные некоторого типа
 * (например, числа) и помещающих их в коллекцию, а также единственный потребитель,
 * который извлекает помещенные в коллекцию элементы по одному. Необходимо
 * организовать безоопасный доступ к коллекции.
 */

public class Runner {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        ProducerThread producerThread = new ProducerThread(queue);
        ConsumerThread consumerThread = new ConsumerThread(queue);

        Thread producer1 = new Thread(producerThread);
        Thread producer2 = new Thread(producerThread);
        Thread consumer = new Thread(consumerThread);

        producer1.start();
        producer2.start();
        consumer.start();
    }

}

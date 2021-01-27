package homework19.task3;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable{

    Logger log = LoggerFactory.getLogger(ConsumerThread.class.getName());

    BlockingQueue<Integer> queue;

    public ConsumerThread(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.isEmpty()) {
            try {
                log.info("Consumer: Waiting while the queue is empty");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Consumer: Error while waiting the elements: " + e.getMessage());
            }
        }
        while (true) {
            try {
                int takenValue = queue.take();
                log.info("Consumer: The value " + takenValue + " has been taken from the queue");
                log.info("Consumer: Queue current size is: " + queue.size());
            } catch (InterruptedException e) {
                log.error("Consumer: Error trying to take an element: " + e.getMessage());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Consumer: Error trying to sleep: " + e.getMessage());
            }
        }
    }
}

package homework19.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerThread implements Runnable{

    Logger log = LoggerFactory.getLogger(ProducerThread.class.getName());

    BlockingQueue<Integer>  queue;

    public ProducerThread(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = (int) (Math.random() * 100);
                queue.put(value);
                log.info("Producer: The value " + value + " has been added to the queue");
                log.info("Producer: Queue current size is: " + queue.size());
            } catch (InterruptedException e) {
                log.error("Producer: Error trying to put an element: " + e.getMessage());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Producer: Error while trying to sleep: " + e.getMessage());
            }
        }
    }
}

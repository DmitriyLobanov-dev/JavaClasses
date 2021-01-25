package homework19.task3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerThread implements Runnable{

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
                System.out.println("Producer: The value " + value + " has been added to the queue");
                System.out.println("Producer: Queue current size is: " + queue.size());
            } catch (InterruptedException e) {
                System.out.println("Producer: Error trying to put an element: " + e.getMessage());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Producer: Error while trying to sleep: " + e.getMessage());
            }
        }
    }
}

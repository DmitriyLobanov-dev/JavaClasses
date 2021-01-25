package homework19.task3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerThread implements Runnable{

    BlockingQueue<Integer> queue;

    public ConsumerThread(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.isEmpty()) {
            try {
                System.out.println("Consumer: Waiting while the queue is empty");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Consumer: Error while waiting the elements: " + e.getMessage());
            }
        }
        while (true) {
            try {
                int takenValue = queue.take();
                System.out.println("Consumer: The value " + takenValue + " has been taken from the queue");
                System.out.println("Consumer: Queue current size is: " + queue.size());
            } catch (InterruptedException e) {
                System.out.println("Consumer: Error trying to take an element: " + e.getMessage());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Consumer: Error trying to sleep: " + e.getMessage());
            }
        }
    }
}

package homework19.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Ship implements Runnable {

    private final boolean canBeUnloaded;
    private final boolean canBeLoaded;
    private final int maxCapacity;
    private int currentCapacity;

    public Ship(boolean canBeUnloaded, boolean canBeLoaded, int maxCapacity, int currentCapacity) {
        this.canBeUnloaded = canBeUnloaded;
        this.canBeLoaded = canBeLoaded;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    @Override
    public void run() {
        boolean doUnload = this.canBeUnloaded && this.currentCapacity > 0;
        boolean portEnoughCapacity = Port.currentCapacity.get() < Port.MAX_CAPACITY;
        boolean shipEnoughCapacity = this.currentCapacity < this.maxCapacity;

        System.out.printf("The %s has arrived to the Port. Acquiring access.\n", Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.printf("Shit happened while acquiring the access for %s." + e.getMessage() + "\n", Thread.currentThread().getName());
        }
        try {
            Port.SEMAPHORE.acquire();
            int dockNumber = 0;
            synchronized (Port.DOCKS) {
                for (int i = 0; i < Port.DOCKS.length; i++) {
                    if (!Port.DOCKS[i]) {
                        Port.DOCKS[i] = true;
                        dockNumber = i;
                        System.out.printf("The %s has moored at the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
                        break;
                    }
                }
            }
            //если корабль может быть разгружен и есть куда разгружать
            if (doUnload) {
                System.out.printf("The %s has started to unload the cargo at the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
                while (portEnoughCapacity && this.currentCapacity > 0) {
                    Port.currentCapacity.incrementAndGet();
                    this.currentCapacity--;
                    System.out.printf("The %s has successfully unloaded 1 container at the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
                    Thread.sleep(500);
                }
            }
            getInfo(this.currentCapacity, this.maxCapacity);
            if (doUnload && Port.currentCapacity.get() == Port.MAX_CAPACITY) { //если корабль может быть загружен, но еще пока что недоразгрузился
                synchronized (Port.DOCKS) {
                    Port.DOCKS[dockNumber] = false;
                    Port.SEMAPHORE.release();
                    System.out.printf("The %s has left the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
                    run();
                }
            }
            //если корабль может быть загружен, есть куда загружать и порт не пуст
            if (this.canBeLoaded && this.currentCapacity < this.maxCapacity && Port.currentCapacity.get() > 0) {
                System.out.printf("The %s has started to load the cargo at the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
                while (shipEnoughCapacity && Port.currentCapacity.get() > 0) {
                    Port.currentCapacity.decrementAndGet();
                    this.currentCapacity++;
                    System.out.printf("The %s has successfully loaded 1 container at the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
                    Thread.sleep(500);
                }
            }
            getInfo(this.currentCapacity, this.maxCapacity);
            //если корабль не может быть загружен и недоразгрузился
            if (!this.canBeLoaded && this.currentCapacity < 0) {
                leaveTheDock(dockNumber);
                run();
            }
            //если корабль может быть загружен и недозагрузился
            if (this.canBeLoaded && this.currentCapacity < this.maxCapacity) {
                leaveTheDock(dockNumber);
                run();
            }
            leaveTheDock(dockNumber);
        } catch (InterruptedException e) {
            System.out.printf("Shit happened somewhere with the %s." + e.getMessage() + "\n", Thread.currentThread().getName());
        }
    }

    public static void leaveTheDock(int dockNumber) {
        synchronized (Port.DOCKS) {
            Port.DOCKS[dockNumber] = false;
            Port.SEMAPHORE.release();
            System.out.printf("The %s has left the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
        }
    }

    public static void getInfo(int shipCurrentCapacity, int shipMaxCapacity){
        System.out.print("The current Port capacity is " + Port.currentCapacity.get() + " out of " + Port.MAX_CAPACITY + "\n");
        System.out.printf("The current %s capacity is " + shipCurrentCapacity + " out of " + shipMaxCapacity + "\n", Thread.currentThread().getName());
//            System.out.print("The current Port capacity is " + Port.currentCapacity.get() + " out of " + Port.MAX_CAPACITY + "\n");
//            System.out.printf("The current %s capacity is " + this.currentCapacity + " out of " + this.maxCapacity + "\n", Thread.currentThread().getName());
    }


}
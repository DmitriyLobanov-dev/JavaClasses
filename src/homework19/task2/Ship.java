package homework19.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Ship implements Runnable {

    private final boolean canBeUnloaded;
    private final boolean canBeLoaded;
    private final Port PORT;
    private final int maxCapacity;
    private int currentCapacity;

    public Ship(boolean canBeUnloaded, boolean canBeLoaded, Port port, int maxCapacity, int currentCapacity) {
        this.canBeUnloaded = canBeUnloaded;
        this.canBeLoaded = canBeLoaded;
        this.PORT = port;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public boolean canBeUnloaded() {
        return canBeUnloaded;
    }

    public boolean canBeLoaded() {
        return canBeLoaded;
    }

    public Port getPort() {
        return PORT;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity <= maxCapacity ? currentCapacity : this.currentCapacity;
    }

    @Override
    public void run() {
        boolean doUnload = this.canBeUnloaded && this.currentCapacity > 0;
        boolean enoughCapacity = ;

        System.out.printf("The %s has arrived to the Port. Acquiring access.\n", Thread.currentThread().getName());
        try {
            Port.SEMAPHORE.acquire();
            int dockNumber = 0;
            synchronized (Port.DOCKS) {
                for (int i = 0; i < Port.DOCKS.length; i++) {
                    if (!Port.DOCKS[i]) {
                        Port.DOCKS[i] = true;
                        dockNumber = i;
                        System.out.printf("The %s has moored at the Dock №%d. Acquiring access.\n", Thread.currentThread().getName(), (dockNumber + 1));
                        break;
                    }
                }
            }
            Thread.sleep(5000); //pause for unload and load process imitation.
            //load and unload logic
            //если корабль может быть разгружен и не пустой
            if (doUnload) {
                while ()
//                //synchronized (PORT.getCurrentCapacity()) {
//                    if ((Port.MAX_CAPACITY - PORT.getCurrentCapacity().get()) >= this.currentCapacity) {
//                        PORT.setCurrentCapacity(new AtomicInteger(PORT.getCurrentCapacity().get() + this.currentCapacity));
//                    } else {
//
//                    }
//                //}
            }
            //если может быть загружен и хватает места
            synchronized (Port.DOCKS) {
                Port.DOCKS[dockNumber] = false;
                Port.SEMAPHORE.release();
                System.out.printf("The %s has left the Dock №%d.\n", Thread.currentThread().getName(), (dockNumber + 1));
            }
        } catch (InterruptedException e) {
            System.out.printf("Something went wrong with the %s." + e.getMessage() + "\n", Thread.currentThread().getName());
        }

    }
}

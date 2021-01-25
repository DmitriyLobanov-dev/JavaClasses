package homework19.task2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров,
 * находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и
 * превышающим заданную грузоподъемность судна и вместимость порта. В порту работает
 * несколько причалов. У одного причала может стоять один корабль. Корабль может
 * загружаться у причала, разгружаться или выполнять оба действия.
 */

public class Port {

    public static final int MAX_CAPACITY = 200; //max containers capacity
    public static final boolean[] DOCKS = new boolean[4]; //max ships capacity
    public static final Semaphore SEMAPHORE = new Semaphore(4, true);
    public static AtomicInteger currentCapacity = new AtomicInteger(0);

    public Port() {
    }

    @Override
    public String toString() {
        return "Port{" +
                "currentCapacity=" + currentCapacity +
                '}';
    }
}

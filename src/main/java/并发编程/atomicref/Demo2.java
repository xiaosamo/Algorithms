package 并发编程.atomicref;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yuan
 * @date 2020/6/27
 */
public class Demo2 {
    // 普通引用
    private static Person person;
    // 原子性引用
    private static AtomicReference<Person> aRperson;

    public static void main(String[] args) throws InterruptedException {
        person = new Person("Tom", 18);
        aRperson = new AtomicReference<>(person);

        System.out.println("Atomic Person is " + aRperson.get().toString());

        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Now Atomic Person is " + aRperson.get().toString());
    }

    static class Task1 implements Runnable {
        @Override
        public void run() {
            aRperson.getAndSet(new Person("Tom1", aRperson.get().getAge() + 1));

            System.out.println("Thread1 Atomic References "
                    + aRperson.get().toString());
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            aRperson.getAndSet(new Person("Tom2", aRperson.get().getAge() + 2));

            System.out.println("Thread2 Atomic References "
                    + aRperson.get().toString());
        }
    }
}

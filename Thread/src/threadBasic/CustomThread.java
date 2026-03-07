package threadBasic;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }
    }
}
class MyThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from Runnable");
    }
}



public class CustomThread {
    static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThread1 mt1 = new MyThread1();
        // mt.run(); // stored in heap area
        // mt1.start();
        Thread t1 = new Thread(mt1);
        t1.start();
//        mt.start();
        System.out.println("main");
    }
}

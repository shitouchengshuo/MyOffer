package concurrent.thread.test1;

/**
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class Thread1 extends Thread {

    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("子线程1....");
                // System.out.println(Thread.currentThread().getName()+" call notify()");
                // 唤醒当前的wait线程
                // notify();
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

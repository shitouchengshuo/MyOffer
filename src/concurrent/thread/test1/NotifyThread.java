package concurrent.thread.test1;

/**
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class NotifyThread extends Thread {

    public NotifyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println("enter child thread: " +Thread.currentThread().getName());
            System.out.println("notify main thread.....");
            notify();
        }

    }
}

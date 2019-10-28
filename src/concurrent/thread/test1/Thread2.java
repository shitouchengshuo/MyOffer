package concurrent.thread.test1;

/**
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class Thread2 extends Thread {

    public Thread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("子线程2.....");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

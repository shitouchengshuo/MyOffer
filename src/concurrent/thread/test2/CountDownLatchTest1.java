package concurrent.thread.test2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class CountDownLatchTest1 {

    private static final CountDownLatch ctl = new CountDownLatch(2);

    public static void main(String[] args){
        System.out.println("主线程正在执行前："+Thread.currentThread().getName());
        try {
            new Thread(()->{
                System.out.println("子线程1....");
                ctl.countDown();
            }).start();
            Thread.sleep(1000);
            new Thread(()->{
                System.out.println("子线程2....");
                ctl.countDown();
            }).start();
            Thread.sleep(1000);
            ctl.await();
            System.out.println("主线程正在执行后："+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

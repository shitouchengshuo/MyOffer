package concurrent.thread.test1;

/**
 * t.join()方法只会使主线程进入等待池并等待t线程执行完毕后才会被唤醒。并不影响同一时刻处在运行状态的其他线程。
 * 原理：
 * join()方法的底层是利用wait()方法实现的。可以看出，join方法是一个同步方法，当主线程调用t1.join()方法时，
 * 主线程先获得了t1对象的锁，随后进入方法，调用了t1对象的wait()方法，使主线程进入了t1对象的等待池，此时，
 * A线程则还在执行，并且随后的t2.start()还没被执行，因此，B线程也还没开始。等到A线程执行完毕之后，主线程继续执行，
 * 走到了t2.start()，B线程才会开始执行。
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class JoinTest extends Thread {

    public static void main(String[] args) throws Exception {
        System.out.println("主线程正在执行前："+Thread.currentThread().getName());
        Thread1 t = new Thread1("t1");
        Thread2 t2 = new Thread2("t2");
        t.start();
        t.join();
        // sleep(1000);
        System.out.println("当前线程： " + Thread.currentThread().getName());
        // t2.start();
        // t2.join();
        System.out.println("主线程正在执行后："+Thread.currentThread().getName());
    }

}

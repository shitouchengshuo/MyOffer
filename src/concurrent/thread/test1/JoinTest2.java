package concurrent.thread.test1;

/**
 * 使用join阻塞主线程，当子线程执行完后再执行主线程
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class JoinTest2 {

    public static void main(String[] args) throws Exception {
        System.out.println("主线程正在执行前："+Thread.currentThread().getName());
        Thread1 t1 = new Thread1("t1");
        t1.start();
        t1.join();

        Thread2 t2 = new Thread2("t2");
        t2.start();
        t2.join();

        System.out.println("主线程正在执行后："+Thread.currentThread().getName());
    }

}

package concurrent.thread.test2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class CountDownLatchTest {

    /**初始化CountDownLatch，值为线程数量*/
    private static final CountDownLatch ctl = new CountDownLatch(10);

    public static void test3(){
        try {
            for (int i = 1 ;i <= 10;i ++){
                Thread.sleep(1000);
                new Thread(()->{
                    System.out.println("子线程正在执行:"+Thread.currentThread().getName());
                }).start();
                ctl.countDown();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)throws Exception{
        System.out.println("主线程正在执行前："+Thread.currentThread().getName());
        test3();
        //最多等待20秒，不管子线程完没完
        ctl.await(20, TimeUnit.SECONDS);
        System.out.println("主线程正在执行后："+Thread.currentThread().getName());
    }

}

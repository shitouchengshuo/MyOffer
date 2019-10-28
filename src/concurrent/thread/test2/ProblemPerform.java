package concurrent.thread.test2;

/**
 * 问题描述：子线程还没执行完时，主线程进来了
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class ProblemPerform {

    public static void test(){
        try {
            for (int i = 0; i <= 10; i++ ){
                Thread.sleep(1000);
                new Thread(()->{
                    System.out.println("子线程正在执行：" + Thread.currentThread().getName());
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("主线程正在执行前： " + Thread.currentThread().getName());
        test();
        System.out.println("主线程正在执行后： " + Thread.currentThread().getName());
    }
}

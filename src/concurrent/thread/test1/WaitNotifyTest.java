package concurrent.thread.test1;

/**
 * 子线程使用notify唤醒主线程
 * @author qiqi.zhao
 * @date 2019/10/22
 */
public class WaitNotifyTest  {

    public static void main(String[] args) throws Exception {
        System.out.println("主线程正在执行前："+Thread.currentThread().getName());
        NotifyThread nt = new NotifyThread("nt");
        synchronized (nt){
            // 启动“线程nt”
            System.out.println(Thread.currentThread().getName()+" start nt");
            nt.start();
            // 主线程等待nt通过notify()唤醒。
            System.out.println(Thread.currentThread().getName()+" wait()");
            nt.wait();
            System.out.println("主线程正在执行后："+Thread.currentThread().getName());
        }
    }

}

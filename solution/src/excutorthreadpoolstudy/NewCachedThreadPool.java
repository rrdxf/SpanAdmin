package excutorthreadpoolstudy;
/*
使用场景
newCachedThreadPool:
    底层：返回ThreadPoolExecutor实例，corePoolSize为0；maxiumPoolSize
    为Integer.Max_value；keepAliveTime为60L;时间单位为TimeUnit.SECONDS;
    workQueue为SynchronousQueue（同步队列）
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程<br>
 * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务<br>
 * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小<br>
 */
//使用很多短期的异步任务
public class NewCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService ccachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int ii=i;
            try {
                Thread.sleep(ii*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ccachedThreadPool.execute(()-> System.out.println("线程名："+Thread.currentThread().getName()+",执行："+ii));
        }
    }
}

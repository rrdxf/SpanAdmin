package excutorthreadpoolstudy;
/*
newFixedThreadPool
    底层：返回ThreadPoolExecutor实例，接受参数为所设定线程数量n，corePoolSize
    和maximumPoolSize均为n；keepAliveTime为0L；单位时间TimeUnit.MILLISECONDS;
    workQueue为：new LinkedBlockingQueue<Runnable>（）无界阻塞队列
    通俗：创建可容纳固定数量线程的池子，每个线程的存货时间是无限的，当赤字满了就不再
    添加线程，如果赤字中的所有线程均在繁忙的状态，对于新任务会进入阻塞队列中。
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建固定大小的线程池，每次提交任务就创建以恶搞线程，知道达到线程池的最大大小
 * 线程池的大小一旦达到最大值，就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程
 * 因为线程池大小为3，每个恩物输出index后sleep2s，所有没两秒打印3个数
 */

public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii=i;
            fixedThreadPool.execute(()->{
                System.out.println("线程名称："+Thread.currentThread().getName()+",执行："+ii);
                try {
                    Thread.sleep(2*1008);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
/*
---out---
线程名称：pool-1-thread-1,执行：0
线程名称：pool-1-thread-3,执行：2
线程名称：pool-1-thread-2,执行：1
线程名称：pool-1-thread-2,执行：3
线程名称：pool-1-thread-1,执行：5
线程名称：pool-1-thread-3,执行：4
线程名称：pool-1-thread-3,执行：7
线程名称：pool-1-thread-1,执行：8
线程名称：pool-1-thread-2,执行：6
线程名称：pool-1-thread-3,执行：9
 */

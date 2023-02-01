package excutorthreadpoolstudy;
/*
newSingleThreadExecutor
    底层：FinalizableDelegatedExecutorService包装的ThreadPoolExecutor实例
    corePoolSize为1；maximumPoolSize为1；keepAliveTime为0L；时间单位TimeUnit.MILLISEconds
    workqueue为：new LinkedBlockingQueue<Runnable>（）无解阻塞队列
    适用：按顺序执行任务的场景
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用唯一线程工作，保证FIFO,LIFO，优先级执行
 */
public class NewSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int ii=i;
            singleThreadExecutor.execute(()-> System.out.println(Thread.currentThread().getName()+"=>"+ii));
        }
    }
}
/*
-----out----
pool-1-thread-1=>0
pool-1-thread-1=>1
pool-1-thread-1=>2
pool-1-thread-1=>3
pool-1-thread-1=>4
pool-1-thread-1=>5
pool-1-thread-1=>6
pool-1-thread-1=>7
pool-1-thread-1=>8
pool-1-thread-1=>9

 */

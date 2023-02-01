package excutorthreadpoolstudy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
NewScheduledThreadPool
底层：创建ScheduledThreadPoolExecutor实列，该对象继承了ThreadPoolExecutor
corePoolSize为传递来的参数，maximumPoolSize为Integer.Max_value;keepaliveTime
为0；时间单位：TimeUnit.NANOSECONDS；workqueue为 new DeleyedWorkQueue()按一个超时见
升序排列
通俗：从创建一个固定大小的线程池，线程池内线程存货无限制，线程池可以支持定时机器周期性任务，如果所有线程均处于
繁忙 ，对于新任务会进入workQueue队列中，这是一种按照超市时间顺序排列的队列结构
 */

/**
 * 创建以恶搞定长线程池，支持定时及周期性任务执行，延迟执行
 */
public class NewScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5);
        Runnable r1=()-> System.out.println("线程名称："+Thread.currentThread().getName()+",执行：三秒后执行");
        scheduledExecutorService.schedule(r1,3, TimeUnit.SECONDS);
        Runnable r2=()-> System.out.println("线程名称："+Thread.currentThread().getName()+",一秒后执行，三秒一次");
        scheduledExecutorService.scheduleAtFixedRate(r2,1,3,TimeUnit.SECONDS);
        Runnable r3=()-> System.out.println("线程名称："+Thread.currentThread().getName()+"，普通任务");
        for (int i = 0;i < 5;i++){
            scheduledExecutorService.execute(r3);
        }
    }
}
/*
----out-----
线程名称：pool-1-thread-3，普通任务
线程名称：pool-1-thread-1，普通任务
线程名称：pool-1-thread-2，普通任务
线程名称：pool-1-thread-4，普通任务
线程名称：pool-1-thread-3,一秒后执行，三秒一次
线程名称：pool-1-thread-1,执行：三秒后执行
线程名称：pool-1-thread-5,一秒后执行，三秒一次
线程名称：pool-1-thread-5,一秒后执行，三秒一次
线程名称：pool-1-thread-5,一秒后执行，三秒一次
线程名称：pool-1-thread-5,一秒后执行，三秒一次
 */
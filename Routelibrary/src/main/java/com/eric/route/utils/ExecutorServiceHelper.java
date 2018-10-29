package com.eric.route.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池管理类
 */
public class ExecutorServiceHelper {

    /**
     * 线程池核心数量
     **/
    private static final int CORE_POOL_SIZE = 4;

    /**
     * 线程池最大数量
     **/
    private static final int MAX_POOL_SIZE = 128;

    /**
     * 空闲线程等待销毁的时间
     **/
    private static final int KEEP_ALIVE_TIME = 30;

    /**
     * 无缓冲的阻塞队列
     **/

    private static SynchronousQueue<Runnable> syncQueue = new SynchronousQueue<Runnable>();

    /**
     * 线程工厂
     **/
    private static ThreadFactory factory = new ThreadFactory() {

        /** 标记创建的线程数量 **/
        AtomicInteger atomic = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    };

    private static ExecutorServiceHelper helper;

    /**
     * 创建的线程池
     **/
    private static ExecutorService executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit
            .SECONDS, syncQueue, factory, new ThreadPoolExecutor.DiscardPolicy());

    private ExecutorServiceHelper() {
    }

    /**
     * 获取单例对象，线程安全的
     *
     * @return 单例对象
     */
    public static ExecutorServiceHelper getInstance() {
        if (helper == null) {
            synchronized (ExecutorServiceHelper.class) {
                if (helper == null) {
                    helper = new ExecutorServiceHelper();
                }
            }
        }
        return helper;
    }

    /**
     * 提交Runnable对象给线程池执行
     *
     * @param run Runnable任务
     */
    public void execRun(Runnable run) {
        executor.execute(run);
    }

    /**
     * 提交Runnable对象给线程池执行
     *
     * @param run Runnable任务
     */
    public Future<?> submitRun(Runnable run) {
        return executor.submit(run);
    }

    /**
     * 关闭线程池
     */
    public void shutExecutor() {
        executor.shutdown();
    }

    /**
     * 立即关闭线程池，在程序退出时调用
     */
    public void shutExecutorNow() {
        executor.shutdownNow();
    }

    /**
     * 创建Runnable对象，自动将Runnable加入线程池
     *
     * @author Kristy_L
     */
    public static abstract class RunnableImpl implements Runnable {

        public RunnableImpl() {
            ExecutorServiceHelper.getInstance().execRun(this);
        }

    }

}

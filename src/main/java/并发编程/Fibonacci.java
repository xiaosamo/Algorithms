package 并发编程;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author yuan
 * @date 2020/2/15
 */
public class Fibonacci {
    public static void main(String[] args) {

        // 创建分治任务线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        // 创建分治任务
        Fib fib = new Fib(30);
        // 启动分治任务
        Integer result = forkJoinPool.invoke(fib);
        // 输出结果
        System.out.println(result);
    }

    // 递归任务
    private static class Fib extends RecursiveTask<Integer>{

        final int n;

        Fib(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }

            Fib f1 = new Fib(n - 1);
            // 创建子任务
            f1.fork();

            Fib f2 = new Fib(n - 2);

            return f2.compute() + f1.join();
        }
    }
}

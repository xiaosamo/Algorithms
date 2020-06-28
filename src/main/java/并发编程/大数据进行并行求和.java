package 并发编程;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yuan
 * @date 2020/2/19
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306581226487842
 */
public class 大数据进行并行求和 {
    public static void main(String[] args) {

        ThreadLocalRandom random = ThreadLocalRandom.current();


        // 创建2000个随机数组成的数组:
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextLong(10000);
            expectedSum += array[i];
        }


        System.out.println("Expected sum: " + expectedSum);

        // fork/join:
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    private static class SumTask    extends RecursiveTask<Long>{


        // 阈值
        private static final int THRESHOLD = 500;
        private long[] array;
        private int start;
        private int end;

        SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // 如果任务足够小,直接计算:
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += this.array[i];
                    // 故意放慢计算速度:
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
                return sum;
            }

            // 任务太大,一分为二:
            int middle = (end + start) / 2;

            System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));

            SumTask subtask1 = new SumTask(this.array, start, middle);
            SumTask subtask2 = new SumTask(this.array, middle, end);

            // invokeAll会并行运行两个子任务:
            invokeAll(subtask1, subtask2);

            // 获得子任务的结果:
            Long subresult1 = subtask1.join();
            Long subresult2 = subtask2.join();
            Long result = subresult1 + subresult2;

            System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
            return result;
        }
    }
}

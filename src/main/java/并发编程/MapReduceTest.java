package 并发编程;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuan
 * @date 2020/2/15
 * 模拟 MapReduce 统计单词数量
 */
public class MapReduceTest {

    private static class MR extends RecursiveTask<Map<String,Long>>{

        private String[] fc;
        private int start, end;
        // 构造函数
        MR(String[] fc, int fr, int to){
            this.fc = fc;
            this.start = fr;
            this.end = to;
        }

        @Override
        protected Map<String, Long> compute() {
            if (end - start == 1) {
                return calc(fc[start]);
            }

            int mid = start + (end - start) / 2;

            MR mr1 = new MR(fc, start, mid);
            mr1.fork();
            MR mr2 = new MR(fc, mid, end);
            // 计算子任务，并返回合并的结果

            return merge(mr2.compute(), mr1.join());
        }

        // 合并结果
        private Map<String, Long> merge(Map<String, Long> r1, Map<String, Long> r2) {

            // err
//           return  Stream.of(r1, r2)
//                    .map(Map::entrySet).flatMap(Set::stream)
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            Map<String, Long> result = new HashMap<>(r1);
            r2.forEach((k, v) -> result.merge(k, v, Long::sum));
            return result;
        }

        // 统计一行的单词数量
        private Map<String, Long> calc(String line) {
            return Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        }
    }


    public static void main(String[] args) {

        String[] fc = {"hello world",
                "hello me",
                "hello fork",
                "hello join",
                "fork join in world"};

        // 创建 ForkJoin 线程池

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        // 创建任务
        MR mr = new MR(fc, 0, fc.length);

        // 启动任务
        Map<String, Long> result = forkJoinPool.invoke(mr);

        // 输出结果
        result.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}

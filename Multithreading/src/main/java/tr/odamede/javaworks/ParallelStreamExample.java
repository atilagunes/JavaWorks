package tr.odamede.javaworks;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
How many thread will open for parallel stream and how parallel stream internally works ?
ChatGPT

In Java, when you use a parallel stream, the Java runtime automatically manages the threading for you. The number of threads used for parallel processing typically depends on the underlying hardware and the parallelism setting.

The parallelism setting is controlled by the java.util.concurrent.ForkJoinPool.common.parallelism system property, which by default is equal to the number of available processors on your machine.

However, you can also explicitly set the parallelism level using the java.util.concurrent.ForkJoinPool class or the parallel() method of the stream.

Here's a basic overview of how parallel streams work internally:

    Splitting: When you create a parallel stream, the stream's elements are divided into multiple chunks, each of which will be processed independently.

    Fork-Join Framework: Java uses the Fork-Join Framework, introduced in Java 7, to execute tasks in parallel. It's based on the "divide and conquer" principle.

    Worker Threads: The Fork-Join Pool manages a pool of worker threads. Each worker thread can execute tasks concurrently.

    Task Distribution: As elements are split into chunks, tasks are created to process these chunks. These tasks are submitted to the Fork-Join Pool, which distributes them among the available worker threads.

    Joining Results: After processing, the results from each chunk are combined to produce the final result.

Here's a simplified example illustrating how a parallel stream might work internally:
 */

// vm option added to run configuration : -Djava.util.concurrent.ForkJoinPool.common.parallelism=20

public class ParallelStreamExample {
    public static void main(String[] args) {
        // Create an array
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

        System.out.println("getParallelism=" + ForkJoinPool.commonPool().getParallelism());
        // Create a parallel stream
        Arrays.stream(array)
                .parallel() // Create a parallel stream
                .map(i -> {
                    System.out.println("Processing " + i + " on thread " + Thread.currentThread().getName());
                    return i * 2;
                })
                .forEach(System.out::println);
    }
/**
 In this example, the elements of the array are processed in parallel.
 The map operation is applied to each element, doubling its value.
 The parallel() method indicates that the stream should be processed in parallel.
 The output will show that elements are processed concurrently by multiple threads.
 The actual number of threads used depends on the parallelism setting and the available hardware resources.  */
}
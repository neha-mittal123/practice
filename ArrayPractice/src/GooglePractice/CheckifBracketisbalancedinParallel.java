package GooglePractice;

/*Question Link : https://leetcode.com/discuss/interview-question/239684/amazon-check-if-bracket-is-balanced-in-parallel
// Given a large file (cannot fit into main memory) with only open and close brackets, how can you check if they are balanced in parallel?*/

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CheckifBracketisbalancedinParallel {
    public static void main(String[] args) throws InterruptedException {
        int THREAD_NUM = 6;
        StrModel finalResult = new StrModel();
        String str = "(()(((())((())))((((((((((()))((((())))))))))))))()(())))(";

        // create the list of 6 threads each with its own chunk of the string
        List<StrThread> threads = new ArrayList<StrThread>();
        int chunkLength = (int)Math.ceil(str.length() / (double)THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            String chunk = str.substring(
                    chunkLength * i, Math.min(str.length(), chunkLength * (i + 1)));
            threads.add(new StrThread(i, chunk));
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_NUM);
        threadPool.invokeAll(threads)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    return null;
                })
                // it is important to sort, otherwise it will not work
                .sorted((a, b) -> a.index - b.index)
                .forEach(model -> {
                    // combine results
                    finalResult.negativeDepth = Math.min(
                            finalResult.negativeDepth,
                            finalResult.balance + model.negativeDepth);
                    finalResult.balance += model.balance;
                });
        threadPool.shutdown();

        System.out.println("final result " +
                " balance " + finalResult.balance +
                " negative depth " + finalResult.negativeDepth);
    }
}

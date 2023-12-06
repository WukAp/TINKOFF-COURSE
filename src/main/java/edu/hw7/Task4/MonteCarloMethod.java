package edu.hw7.Task4;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class MonteCarloMethod {

    private final double r = 0.5;

    public double countPiUsingOneThread(int amountOfExperience) {
        long circleCount = getsAmountOfPointsInCircle(amountOfExperience);
        return getPiByCircleAndTotalCounters(circleCount, amountOfExperience);
    }

    public double countPiUsingMultiThread(int amountOfExperience) throws ExecutionException, InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int amountOfThreadExperience = amountOfExperience / availableProcessors;
        long circleCountAccumulator = 0;
        List<CompletableFuture<Long>> futures =
            Stream.generate(() -> CompletableFuture.supplyAsync(() -> getsAmountOfPointsInCircle(
                amountOfThreadExperience))).limit(availableProcessors).toList();
        for (CompletableFuture<Long> future : futures) {
            circleCountAccumulator += future.get();
        }
        return getPiByCircleAndTotalCounters(
            circleCountAccumulator,
            (long) amountOfThreadExperience * availableProcessors
        );
    }

    @SuppressWarnings("MagicNumber") private double getPiByCircleAndTotalCounters(long circleCount, long totalCount) {
        return 4 * ((double) circleCount / totalCount);
    }

    private long getsAmountOfPointsInCircle(int amountOfExperience) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        long circleCount = 0;
        double sqrtR = r * r;
        for (int totalCount = 0; totalCount < amountOfExperience; totalCount++) {
            double x = random.nextDouble() - r;
            double y = random.nextDouble() - r;

            //if point(x, y) is in circle
            if (x * x + y * y < sqrtR) {
                circleCount++;
            }
        }
        return circleCount;
    }
}

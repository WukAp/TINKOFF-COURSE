package edu.hw9.Task2;

import edu.hw9.Task2.fileRecursiveTasks.FilesByPredicate;
import edu.hw9.Task2.fileRecursiveTasks.FilesInDirectoryCounter;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;

public class FilesSearcher {
    public long getAmountOfFileAsync(File rootFile) {
        if (rootFile.isFile()) {
            return 0;
        }
        FilesInDirectoryCounter counter = new FilesInDirectoryCounter(rootFile);

        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            return forkJoinPool.invoke(counter);
        }
    }

    public List<File> getFileByPredicateAsync(File rootFile, Predicate<File> filePredicate) {
        FilesByPredicate filesByPredicate = new FilesByPredicate(rootFile, filePredicate);

        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            return forkJoinPool.invoke(filesByPredicate);
        }
    }

    public List<File> getFileByPredicateSync(File rootFile, Predicate<File> filePredicate) {
        if (rootFile.isFile()) {
            return filePredicate.test(rootFile) ? Collections.singletonList(rootFile) : List.of();
        }
        return
            Arrays.stream(rootFile.listFiles())
                .map((file) -> getFileByPredicateSync(file, filePredicate))
                .flatMap(Collection::stream).toList();

    }

    public long getAmountOfFileSync(File rootFile) {
        if (rootFile.isFile()) {
            return 0;
        }
        return getAmountOfFileRecursiveHelper(rootFile);
    }

    private int getAmountOfFileRecursiveHelper(File rootFile) {
        if (rootFile.isFile()) {
            return 1;
        }
        return Arrays.stream(rootFile.listFiles())
            .mapToInt((this::getAmountOfFileRecursiveHelper))
            .sum();
    }

}

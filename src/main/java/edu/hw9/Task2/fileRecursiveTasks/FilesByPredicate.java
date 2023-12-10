package edu.hw9.Task2.fileRecursiveTasks;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public class FilesByPredicate extends RecursiveTask<List<File>> {
    private final File rootFile;
    private final Predicate<File> filePredicate;

    public FilesByPredicate(@NotNull File rootFile, @NotNull Predicate<File> filePredicate) {
        this.rootFile = rootFile;
        this.filePredicate = filePredicate;
    }

    @Override
    protected List<File> compute() {
        if (rootFile.isFile()) {
            return filePredicate.test(rootFile) ? Collections.singletonList(rootFile) : List.of();
        }
        if (rootFile.listFiles() == null) {
            return List.of();
        }
        var computedList =
            Arrays.stream(rootFile.listFiles())
                .map((file) -> new FilesByPredicate(file, filePredicate))
                .peek(ForkJoinTask::fork).toList();

        return computedList.stream().map(ForkJoinTask::join).flatMap(Collection::stream).toList();
    }
}

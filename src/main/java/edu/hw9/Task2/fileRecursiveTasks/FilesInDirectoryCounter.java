package edu.hw9.Task2.fileRecursiveTasks;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import org.jetbrains.annotations.NotNull;

public class FilesInDirectoryCounter extends RecursiveTask<Integer> {
    private final File rootFile;

    public FilesInDirectoryCounter(@NotNull File rootFile) {
        this.rootFile = rootFile;
    }

    @Override
    protected Integer compute() {
        if (rootFile.isFile()) {
            return 1;
        }
        if (rootFile.listFiles() == null) {
            return 0;
        }
        var computedList =
            Arrays.stream(rootFile.listFiles())
                .map(FilesInDirectoryCounter::new)
                .peek(ForkJoinTask::fork).toList();

        return computedList.stream().mapToInt(FilesInDirectoryCounter::join).sum();
    }
}

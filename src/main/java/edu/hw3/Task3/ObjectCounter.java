package edu.hw3.Task3;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class ObjectCounter<T> {

    /**
     * gets frequency list of object
     *
     * @param objects the not null list with objects to count
     * @return the frequency list
     */
    public Map<T, Integer> freqDict(@NotNull Collection<T> objects) {
        return objects.stream().collect(Collectors.toMap(key -> key, val -> 1, Integer::sum));
    }
}

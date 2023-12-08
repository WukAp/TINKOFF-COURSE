package edu.hw8.Task3;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

class PasswordsSearcherTest {
    HashMap<String, String> data = getInitialDataFromTask();

    PasswordsSearcher passwordsSearcher = new PasswordsSearcher(4, data);

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    void findPasswordsUsingOneThread() {
        var passwordMap = passwordsSearcher.findPasswordsUsingOneThread();
        assertEquals(3, passwordMap.size());
        assertEquals("cow", passwordMap.get("k.s.korovin"));
        assertEquals("cat", passwordMap.get("g.a.kotov"));
        assertEquals("dog", passwordMap.get("a.p.sobakevich"));
    }

    @Test
    void findPasswordsUsingManyThreads() throws ExecutionException, InterruptedException {
        var passwordMap = passwordsSearcher.findPasswordsUsingManyThreads();
        assertEquals(3, passwordMap.size());
        assertEquals("cow", passwordMap.get("k.s.korovin"));
        assertEquals("cat", passwordMap.get("g.a.kotov"));
        assertEquals("dog", passwordMap.get("a.p.sobakevich"));
    }

    void compareTime(int maxCharacter) throws ExecutionException, InterruptedException {
        PasswordsSearcher passwordsSearcher = new PasswordsSearcher(maxCharacter, data);
        long start = System.nanoTime();
        passwordsSearcher.findPasswordsUsingOneThread();
        long end = System.nanoTime();
        LOGGER.info("One thread, " + maxCharacter + " characters: " + (end - start) + "mls");

        start = System.nanoTime();
        passwordsSearcher.findPasswordsUsingManyThreads();
        end = System.nanoTime();
        LOGGER.info("Many threads,  " + maxCharacter + "  characters: " + (end - start) + "mls");
        /*
        4: 5sec vs 0,8sec
        5: 5min vs 0,8min
         */
    }

    private HashMap<String, String> getInitialDataFromTask() {
        HashMap<String, String> data = new HashMap<>(5);
        data.put("81566e986cf8cc685a05ac5b634af7f8", "k.s.korovin"); //cow
        data.put("06d80eb0c50b49a509b49f2424e8c805", "a.p.sobakevich"); //dog
        data.put("d077f244def8a70e5ea758bd8352fcd8", "g.a.kotov"); //cat
        return data;
    }

}

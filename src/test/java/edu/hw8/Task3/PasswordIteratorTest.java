package edu.hw8.Task3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class PasswordIteratorTest {
    HashMap<String, String> data = getInitialDataFromTask();

    PasswordsSearcher passwordsSearcher = new PasswordsSearcher(4, data);

    @Test
    void findPasswords() {
        var passwordMap = passwordsSearcher.findPasswords();
        assertEquals(3, passwordMap.size());
        assertEquals("cow", passwordMap.get("k.s.korovin"));
        assertEquals("cat", passwordMap.get("g.a.kotov"));
        assertEquals("dog", passwordMap.get("a.p.sobakevich"));
    }
    private HashMap<String, String> getInitialDataFromTask() {
        HashMap<String, String> data = new HashMap<>(5);
        data.put("81566e986cf8cc685a05ac5b634af7f8", "k.s.korovin"); //cow
        data.put("06d80eb0c50b49a509b49f2424e8c805", "a.p.sobakevich"); //dog
        data.put("d077f244def8a70e5ea758bd8352fcd8", "g.a.kotov"); //cat
        return data;
    }
}

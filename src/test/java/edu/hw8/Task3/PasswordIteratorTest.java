package edu.hw8.Task3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class PasswordIteratorTest {
    HashMap<String, String> data = new PasswordsData().getData();
    PasswordsSearcher passwordsSearcher = new PasswordsSearcher(5, data);

    @Test
    void findPasswords() {

        System.out.println(passwordsSearcher.findPasswords());
    }
}

package edu.hw8.Task3;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.xml.bind.DatatypeConverter;

public class PasswordsSearcher {

    private final int maxCharacter;
    private final HashMap<String, String> data;

    public PasswordsSearcher(int maxCharacter, HashMap<String, String> data) {
        this.maxCharacter = maxCharacter;
        this.data = data;
    }

    public Map<String, String> findPasswordsUsingOneThread() {
        Map<String, String> result = new HashMap<>();

        Iterator<String> passwordIterator = new PasswordIterator(maxCharacter);
        while (passwordIterator.hasNext()) {
            var currentPassword = passwordIterator.next();
            var name = getNameByPassword(currentPassword);
            if (name != null) {
                result.put(name, currentPassword);
            }
        }
        return result;
    }

    public Map<String, String> findPasswordsUsingManyThreads() throws ExecutionException, InterruptedException {
        Map<String, String> result = new ConcurrentHashMap<>();
        //var characterIterator = ;
        List<CompletableFuture<?>> futures = new ArrayList<>();
        PasswordIterator.getCharacterIterator()
            .forEachRemaining((character) -> futures.add(CompletableFuture.runAsync(() -> {
                Iterator<String> passwordIterator = new PasswordIterator(maxCharacter, character);
                while (passwordIterator.hasNext()) {
                    var currentPassword = passwordIterator.next();
                    var name = getNameByPassword(currentPassword);
                    if (name != null) {
                        result.put(name, currentPassword);
                    }
                }
            })));
        for (var future : futures) {
            future.get();
        }
        return result;
    }

    private String getNameByPassword(String password) {
        return data.get(getMD5Hash(password));
    }

    private String getMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(messageDigest).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Java Virtual Machine can't run MD5 algorithm");
        }
    }

}

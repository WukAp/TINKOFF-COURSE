package edu.hw8.Task3;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;

public class PasswordsSearcher {

    private final int maxCharacter;
    private final HashMap<String, String> data;

    public PasswordsSearcher(int maxCharacter, HashMap<String, String> data) {
        this.maxCharacter = maxCharacter;
        this.data = data;
    }

    public Map<String, String> findPasswords() {

        Map<String, String> result = new HashMap<>();
        for (int i = 1; i <= maxCharacter; i++) {
            var passwordsWithExtractLength = findPasswordsWithExtractLength(i);
            result.putAll(passwordsWithExtractLength);
        }
        return result;
    }

    private Map<String, String> findPasswordsWithExtractLength(int length) {
        Map<String, String> result = new HashMap<>();
        Iterator<String> passwordIterator = new PasswordIterator(length);
        while (passwordIterator.hasNext()) {
            var currentPassword = passwordIterator.next();
            var name = getNameByPassword(currentPassword);
            if (name != null) {
                result.put(name, currentPassword);
            }
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
            //System.out.println(DatatypeConverter.printHexBinary(messageDigest).toLowerCase());
            return DatatypeConverter.printHexBinary(messageDigest).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 должен быть поддержан вашей Java Virtual Machine.", e);
        }
    }

}

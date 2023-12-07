package edu.hw8.Task3;

import java.util.HashMap;

public class PasswordsData {
    private final HashMap<String, String> data;

    public PasswordsData() {
        data = getInitialDataFromTask();
    }

    public HashMap<String, String> getData() {
        return data;
    }

    private HashMap<String, String> getInitialDataFromTask() {
        HashMap<String, String> data = new HashMap<>(5);
        data.put("e10adc3949ba59abbe56e057f20f883e", "a.v.petrov");
        data.put("d8578edf8458ce06fbc5bb76a58c5ca4", "a.v.belov");
        data.put("482c811da5d5b4bc6d497ffa98491e38", "a.s.ivanov");
        data.put("5f4dcc3b5aa765d61d8327deb882cf99", "k.p.maslov");
        return data;
    }
}

package com.example;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Person person = new Person("田中太郎", 25);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);
    }
}

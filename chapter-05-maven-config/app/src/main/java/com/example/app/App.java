package com.example.app;

import com.example.lib.Greeter;

public class App {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.greet("田中太郎"));
    }
}

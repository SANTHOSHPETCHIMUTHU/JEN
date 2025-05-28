package org.example;

public class App {
    public String greet() {
        return "Hello CI/CD!";
    }

    public static void main(String[] args) {
        System.out.println(new App().greet());
    }
}

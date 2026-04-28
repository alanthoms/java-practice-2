package oop.practice;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StateCapitals2 {
    public static void main(String[] args) throws Exception{
        Map<String, String> states = new HashMap<>();

        Scanner scanner = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
            String[] parts = line.split("::");
            states.put(parts[0], parts[1]);

        }
        System.out.println(states.size() + " STATES AND CAPITALS LOADED");

    }



}

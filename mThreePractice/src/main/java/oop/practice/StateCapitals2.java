package oop.practice;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


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

        Set<String> keys = states.keySet();
        System.out.println("HERE ARE THE STATES");
        System.out.println(keys);

        Random rng = new Random();
        int randomStateNo = rng.nextInt(50);

        List<String> stateList = new ArrayList<>(states.keySet());
        String randomState = stateList.get(rng.nextInt(stateList.size()));
        Scanner sc = new Scanner(System.in);
        System.out.println("WHATS THE CAPITAL OF " + randomState);
        String capitalAnswer = sc.nextLine();

        if(capitalAnswer.equalsIgnoreCase(states.get(randomState))){
            System.out.println("nice work, you are right the correct answer is " + states.get(randomState));
        } else{

            System.out.println("INCORRECT the correct answer is " + states.get(randomState));
        }
    }



}

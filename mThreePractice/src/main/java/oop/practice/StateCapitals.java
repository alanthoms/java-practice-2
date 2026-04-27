package oop.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StateCapitals {


    public static void main(String[] args) {

        Map<String, String> states = new HashMap<>();
        states.put("Alabama", "Montgomery");
        states.put("Alaska", "Pennsylvania");
        states.put("Arizona", "Delaware");
        states.put("Arkansas", "Delaware");

        Set<String> keys = states.keySet();

        System.out.println("STATES");
        for(String k : keys){
            System.out.println(k);
        }

        System.out.println("CAPITALS");
        for (String k : keys){
            System.out.println(states.get(k));
        }


        System.out.println("BOTH");
        for (String k : keys){
            System.out.println(k + " - " + states.get(k));
        }






    }


}

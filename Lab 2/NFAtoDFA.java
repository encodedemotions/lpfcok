package com.LABS.lab2;

import java.util.*;

public class NFAtoDFA {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of states in NFA: ");
        int noOfStates = sc.nextInt();

        System.out.print("Enter the states (NOTE: The states should be denoted by single characters. EX: S, A, 0, 1...) : ");
        char[] statesArray = new char[noOfStates];
        HashMap<Character, Integer> States = new HashMap<>();
        for(int i=0; i<noOfStates; i++)
        {
            char ch = sc.next().charAt(0);
            statesArray[i] = ch;
            States.put(ch, i);
        }

        System.out.print("Enter the initial state : ");
        char initialState = sc.next().charAt(0);

        System.out.print("Enter the no. of final states : ");
        int nrOfFinals = sc.nextInt();

        System.out.print("Enter the final states : ");
        HashMap<Character, Integer> finalStates = new HashMap<>();
        for(int i=0; i<nrOfFinals; i++) {
            finalStates.put(sc.next().charAt(0), 1);
        }

        System.out.print("Enter the number of transition characters: ");
        int nrOfCharacters = sc.nextInt();

        System.out.print("Enter transition characters: ");
        char[] transitions = new char[nrOfCharacters];
        for(int i=0; i<nrOfCharacters; i++) {
            transitions[i] = sc.next().charAt(0);
        }

        Queue<String> newStates = new LinkedList<>();
        HashMap<String, Integer> DFAmap = new HashMap<>();
        newStates.add(initialState+"");
        DFAmap.put(initialState+"", 1);

        System.out.println("Enter the NFA transition table.");
        System.out.println("NOTE: if a character leads to multiple states, write all the states without spaces.");
        String[][] tableNFA = new String[noOfStates][nrOfCharacters];

        System.out.print("-------------------------------------\n\t");
        for(int i=0; i<nrOfCharacters; i++) {
            System.out.print(transitions[i] + "\t");
        }
        System.out.println();

        for(int i=0;i<noOfStates;i++)
        {
            System.out.print(statesArray[i]+"|\t");
            for(int j=0;j<nrOfCharacters;j++)
            {
                tableNFA[i][j] = sc.next();
            }
        }

        System.out.println("\nThe DFA transition table: ");

        for(int i=0; i<nrOfCharacters; i++) {
            System.out.print("\t" + transitions[i]);
        }
        System.out.println();
        String tableDFA[][] = new String[1000][nrOfCharacters];
        String finalStatesDFA[] = new String[1000];
        int top_finalstates = 0;
        HashMap<Character, Integer> states;
        for(int i = 0; newStates.size() > 0; i++)
        {
            String cur_state = newStates.remove();

            if (cur_state == ""){
                continue;
            }

            while (true){
                boolean isFinal = false;

                if (cur_state.length() == 1 && cur_state.charAt(0) == initialState) {
                    System.out.print("->"+cur_state+"|");
                    break;
                }

                for (int j = 0; j < cur_state.length(); j++) {
                    if (finalStates.containsKey(cur_state.charAt(j))) {
                        System.out.print("*"+cur_state+"|");
                        isFinal = true;
                        break;
                    }
                }
                if (!isFinal){
                    System.out.print(cur_state+"|");
                    break;
                }
                break;
            }

            for(int j=0;j<nrOfCharacters;j++)
            {
                tableDFA[i][j] = "";

                if(cur_state.length() == 1 && !States.containsKey(cur_state.charAt(0)))
                {
                    tableDFA[i][j] = cur_state;

                    if(!DFAmap.containsKey(tableDFA[i][j]))
                    {
                        newStates.add(tableDFA[i][j]);
                        DFAmap.put(tableDFA[i][j], 1);
                    }

                    if(finalStates.containsKey((tableDFA[i][j].charAt(0)))) {
                        finalStatesDFA[top_finalstates++] = tableDFA[i][j];
                    }
                    System.out.print(tableDFA[i][j]+"\t");
                    continue;
                }
                boolean isFinal = false;
                states = new HashMap<>();

                for(int k=0; k<cur_state.length(); k++)
                {
                    if(!States.containsKey(cur_state.charAt(k))) {
                        continue;
                    }

                    if(finalStates.containsKey(cur_state.charAt(k))) {
                        isFinal = true;
                    }

                    for(int ch=0; ch<tableNFA[States.get(cur_state.charAt(k))][j].length(); ch++)
                    {
                        if(!states.containsKey(tableNFA[States.get(cur_state.charAt(k))][j].charAt(ch)) && States.containsKey(tableNFA[States.get(cur_state.charAt(k))][j].charAt(ch)))
                        {
                            tableDFA[i][j] += tableNFA[States.get(cur_state.charAt(k))][j].charAt(ch);
                            states.put(tableNFA[States.get(cur_state.charAt(k))][j].charAt(ch), 1);
                        }
                    }
                }

                if(!DFAmap.containsKey(tableDFA[i][j]))
                {
                    newStates.add(tableDFA[i][j]);
                    DFAmap.put(tableDFA[i][j], 1);
                }

                if(isFinal) {
                    finalStatesDFA[top_finalstates++] = tableDFA[i][j];
                }
                System.out.print(tableDFA[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
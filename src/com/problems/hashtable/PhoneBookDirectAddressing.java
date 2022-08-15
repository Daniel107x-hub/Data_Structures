package com.problems.hashtable;

import java.util.Scanner;

public class PhoneBookDirectAddressing {
    private static String[] phoneBook = new String[10000000];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int queries = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<queries;i++){
            String[] query = scanner.nextLine().split(" ");
            executeQuery(query);
        }
    }

    private static void executeQuery(String[] query){
        int number = Integer.parseInt(query[1]);
        switch(query[0]){
            case "add":
                add(number, query[2]);
                break;

            case "del":
                del(number);
                break;

            case "find":
                find(number);
                break;

            default:
                System.out.println("ERROR");
                break;
        }
    }

    private static void add(int number, String name){
        phoneBook[number] = name;
    }

    private static void del(int number){
        phoneBook[number] = null;
    }

    private static void find(int number){
        String name = phoneBook[number];
        if(name == null || name.isBlank() || name.isEmpty()){
            System.out.println("not found");
            return;
        }
        System.out.println(name);
    }
}

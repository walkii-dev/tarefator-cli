package org.educational;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitCondition = false;
        String command;

        while(!exitCondition) {
            System.out.print("tarefator-cli ");
            command = input.nextLine();
            if (command.equals("exit")){
                exitCondition = true;
            }
        }
    }
}
package org.educational;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitCondition = false;
        String command;
        final String PURPLE = "\u001B[35m";

        while(!exitCondition) {
            System.out.print(PURPLE+"tarefator-cli "+PURPLE);
            command = input.nextLine();
            if (command.equals("exit")){
                exitCondition = true;
            }
        }
    }
}
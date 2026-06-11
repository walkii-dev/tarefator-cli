package org.educational;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitCondition = false;
        String command;
        final String PURPLE = "\u001B[35m";

        while(!exitCondition) {
            System.out.print(PURPLE + "tarefator-cli " + PURPLE);
            command = input.nextLine();

            switch (command) {
                case "exit": { exitCondition = true; break;}
                case "help": { System.out.print("\ncommands:\n>help: show all commands avaliable\n>exit: exit application\n\n"); break;}
                default: { System.out.println("command not allowed, please type 'help' to further informations."); }
            }

        }
    }
}
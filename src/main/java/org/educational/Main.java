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

                String[] processCommand = command.split(" ");
             if (command.split(" ").length > 3){
                 System.out.println("maximum of commands inputed. please try again.");
             } else {
                 switch (processCommand[0]) {
                     case "add": {
                         Task newTask = new Task(processCommand[1]);
                         System.out.println("task created: \"" + newTask.getDescription() + "\"");
                     }
                     // não está finalizado

                     //deleção de task

                     //edição de task

                     //marcação de task

                     //listagem de task

                     case "exit": {
                         exitCondition = true;
                         break;
                     }

                     case "help": {
                         System.out.print("\ncommands:\n>help: show all commands avaliable\n>exit: exit application\n\n");
                         break;
                     }

                     default: {
                         System.out.println("command not allowed, please type 'help' to further informations.");
                     }
                 }

             }
        }
    }
}
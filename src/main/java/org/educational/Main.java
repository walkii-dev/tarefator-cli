package org.educational;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        boolean exitCondition = false;
        String command;

        while(!exitCondition) {
            System.out.print(PURPLE + "tarefator-cli "+RESET);
            command = input.nextLine();

                String[] processCommand = command.split(" ");

                 switch (processCommand[0]) {
                     case "add": {
                         Task newTask = new Task(processCommand[1]);
                         System.out.println("task "+newTask.getDescription()+" created successfully (ID: "+newTask.getId()+")");
                         break;
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
                         System.out.print("\ncommands:\n" +
                                 ">add \"<taskname>\": add a new task\n" +
                                 ">help: show all commands avaliable\n" +
                                 ">exit: exit application\n\n");
                         break;
                     }

                     default: {
                         System.out.println("command not allowed, please type 'help' to further informations.");
                     }
                 }


        }
    }
}
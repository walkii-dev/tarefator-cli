package org.educational;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    public static final Path FILE_NAME = Path.of("tasks.json");

    public static void main(String[] args) {


        boolean exitCondition = false;
        String command;

        while(!exitCondition) {
            System.out.print(PURPLE + "tarefator-cli "+RESET);
            command = input.nextLine();

                String[] processCommand = command.split(" ");

                 switch (processCommand[0]) {
                     case "add": {
                         Task.createTask(command.substring(4));
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
                         System.out.print("""
                                 
                                 commands:
                                 >add "<taskname>": add a new task
                                 >help: show all commands avaliable
                                 >exit: exit application
                                 
                                 """);
                         break;
                     }

                     default: {
                         System.out.println("command not allowed, please type 'help' to further informations.");
                     }
                 }


        }
    }
}
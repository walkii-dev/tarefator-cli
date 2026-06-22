package org.educational;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static final Scanner INPUT = new Scanner(System.in);

    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    public static final Path FILE_NAME = Path.of("C:\\Users\\Usuário\\Desktop\\tasks.json");

    public static void main(String[] args) {

        verifyDataExistence();

        var taskData = new ArrayList<Task>();

        boolean exitCondition = false;
        String command;

        while (!exitCondition) {
            System.out.print(PURPLE + "tarefator-cli " + RESET);
            command = INPUT.nextLine();

            String[] processCommand = command.split(" ");
            switch (processCommand[0]) {

                case "list": {
                    // função que serializa o string json em item tarefa.
                }

                case "add": {
                    Task.createTask(command.substring(4));
                    break;
                }

                //deleção de task

                //edição de task

                //marcação de task

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
    public static void verifyDataExistence() {
        try {
            if (!Files.exists(FILE_NAME)) {
                Files.createFile(FILE_NAME);
                System.out.println("arquivo criado!");
                Files.writeString(FILE_NAME, "{}");
            }else{
                System.out.println("Arquivo existente.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeJsonStringToTask(){

    }

    //funcao de serialização de itens da lista

    // trigger de verificação de alteração de dados, evitando apagar dados indiretamente ao reinício do programa.
}
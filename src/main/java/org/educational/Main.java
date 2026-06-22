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

                case "add": {
                    taskData.add(Task.createTask(command.substring(4)));
                    taskData.getLast().setId(taskData.indexOf(taskData.getLast()) + 1);
                    System.out.println(String.format("task \"%s\" created with success! (ID: %d )",
                            taskData.getLast().getDescription(),
                            taskData.getLast().getId()));
                    //vai dar null pois está incompleto!!!
                    break;
                }

                //deleção de task

                //edição de task

                //marcação de task

                case "list": {
                    if (command.substring(4).length() > 1) {
                        switch (command.substring(5)) {
                            case "todo": {
                                System.out.println("todo tasks.");
                                break;
                            }
                            case "done": {
                                System.out.println("done tasks.");
                                break;
                            }
                            case "in-progress": {
                                System.out.println("tasks in progress.");
                                break;
                            }
                            default: {
                                System.out.println(" please type \"list done\", \"list todo\"" +
                                        " or \"list in-progress\" to see specific tasks status.");
                            }
                        }
                    } else {
                        System.out.println("All tasks:");
                        System.out.println(taskData);
                    }
                    break;
                }

                case "exit": {
                    saveAlterations(taskData);
                    exitCondition = true;
                    break;
                }

                case "help": {
                    System.out.print("""
                            commands:
                            >add "<taskname>": add a new task
                            >list: list all tasks
                            >list todo,done or in-progress: list tasks by status
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
        //funcao de serialização de itens da lista
    }

    public static void saveAlterations(ArrayList<Task> tasks){
        StringBuilder sb = new StringBuilder();
        tasks.forEach(t -> sb.append(t.toString()));
        //função que salva as alterações no array e entrega ao json.
    }



    // trigger de verificação de alteração de dados, evitando apagar dados indiretamente ao reinício do programa.
}
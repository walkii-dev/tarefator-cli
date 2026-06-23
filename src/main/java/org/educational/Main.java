package org.educational;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.educational.Task.getTaskFromString;

public class Main {

    public static List<Task> taskData = new ArrayList<>();

    public static final Scanner INPUT = new Scanner(System.in);

    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    public static final Path FILE_LOCATION = Path.of("C:\\Users\\Usuário\\Desktop\\tasks.json");

    public static void main(String[] args) {

        verifyDataExistence();


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

                    //trigger para verificar se houve alterações na lista de tarefas.

                    try {
                        saveAlterations(taskData);
                    } catch (IOException e) {
                        System.out.println("error on save tasks.");
                        e.printStackTrace();
                    }
                    exitCondition = true;
                    break;
                }

                case "help": {
                    System.out.print("""
                            commands:
                            >add "<taskname>": add a new task
                            >list: list all tasks
                            >list <todo/done/in-progress>: list tasks by status
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
            if (!Files.exists(FILE_LOCATION)) {
                Files.createFile(FILE_LOCATION);
                System.out.println("arquivo criado!");
                Files.writeString(FILE_LOCATION, "{}");
            }else{
                System.out.println("Arquivo existente.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> verifyPreviousData(List<Task> tasks){
        return taskData;
    }

    public static void serializeJsonStringToTask() throws IOException {
        String firstData = Files.readString(FILE_LOCATION).split("\\\\[\\\\]")[1];
        //função que transforma o texto em uma lista de tarefas que ja estavam salvas no início do programa.
    }

    public static void saveAlterations(List<Task> tasks) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"tasks\":[");
        tasks.forEach(t -> { sb.append(t.toString()).append(",\n"); });
        sb.deleteCharAt(sb.length()-2);
        sb.append("]}");
        Files.writeString(FILE_LOCATION,sb);
    }
}
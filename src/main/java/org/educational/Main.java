package org.educational;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static List<Task> taskData = new ArrayList<>();

    public static final Scanner INPUT = new Scanner(System.in);

    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    public static int counter;

    public static final Path FILE_LOCATION = Path.of("tasks.json");

    public static void main(String[] args) throws IOException {

        verifyPreviousDataExistence(FILE_LOCATION);

        boolean exitCondition = false;
        String command;

        while (!exitCondition) {
            System.out.print(PURPLE + "tarefator-cli " + RESET);
            command = INPUT.nextLine();

            String[] processCommand = command.split(" ");
            switch (processCommand[0]) {

                case "add": {
                    if (command.equals("add")) {
                        System.out.println("please type the description of the action. example: 'add \"sleep\"'.");
                    } else {
                        counter++;
                        taskData.add(new Task(command.substring(4), counter));
                        /*
                        vai até a lista de tarefas, localiza o indice do último item pra procurar o indice anterior
                        que é o item que foi criado antes do novo item, pega o id dele e adiciona mais um. sempre
                        com base no item criado na iteração anterior.

                        obs.: paradas repentinas (sem o exit) não salva as alterações!
                         */

                        System.out.printf("task \"%s\" created with success! (ID: %d )%n", taskData.getLast().getDescription(), taskData.getLast().getId());
                    }
                    break;
                }

                case "delete": {
                    if (command.equals("delete")) {
                        System.out.println("please type the id of the task. example: 'delete 1'.");
                    } else {
                        if (Integer.parseInt(command.substring(7)) == 0) {
                            System.out.println("id not found,please try again.");
                        } else {
                            Task.deleteTask(taskData,Integer.parseInt(command.substring(7)) - 1);
                            System.out.printf("task \"%s\" deleted with success.%n", taskData.getLast().getDescription());
                        }
                    }
                    break;
                }

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
                                System.out.println(" please type \"list done\", \"list todo\"" + " or \"list in-progress\" to see specific tasks status.");
                            }
                        }
                    } else {
                        if (taskData.isEmpty()) {
                            System.out.println("No tasks include. please type a new task to see more.");
                        } else {
                            System.out.println("All tasks:");
                            taskData.forEach(System.out::println);
                        }
                    }
                    break;
                }

                case "exit": {

                    try {
                        saveAlterations(taskData);
                    } catch (IOException e) {
                        throw new IOException(e);
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

    public static void verifyPreviousDataExistence(Path path) throws IOException {
        if (Files.exists(path)) {
            int fileLength = Files.readString(path).length();
            if (fileLength <= 11) {
                System.out.println("not suficient info found.");
            } else {
                serializeJsonStringToTasks(path);
            }
        } else {
            Files.createFile(path);
        }
    }


    public static void serializeJsonStringToTasks(Path path) {
        try {
            String firstData = Files.readString(path);

            counter = Integer.parseInt(firstData.split(":")[firstData.split(":").length - 1].replace("}", ""));
            System.out.println(counter);

            firstData = firstData.substring(10, firstData.length() - 2);

            List<String> previousTaskData = Arrays.stream(firstData.split("},")).toList();

            previousTaskData.forEach(str -> taskData.add(Task.getTaskFromString(str)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveAlterations(List<Task> tasks) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"tasks\":[");
        tasks.forEach(t -> sb.append(t.toString()).append(",\n"));
        sb.deleteCharAt(sb.length() - 2);
        sb.append("],\"counter\":");
        sb.append(counter);
        sb.append("}");

        Files.writeString(FILE_LOCATION, sb);
    }


}
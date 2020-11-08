package homeworks.hw411;


import java.util.*;

public class TaskKeeper {
    private List<Task> tasks = new ArrayList<>(100);

    private static int parse(int input) {
        if ((input > 0) && (input < 4))
            return input;
        throw new InputMismatchException();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int input;

        while (true) {
            System.out.println("\nВведите номер операции: ");
            try {
                input = scanner.nextInt();
                if (input == 0) {
                    break;
                }

                int variant = parse(input);
                operation(variant, scanner);


            } catch (IllegalArgumentException | InputMismatchException
                    | IndexOutOfBoundsException e) {
                System.out.println("Ошибка ввода.");
                scanner.nextLine();
                continue;
            }
        }
        scanner.close();
    }

    private void operation(int variant, Scanner in) {
        switch (variant) {
            case 1:
                addNewTask(in);
                break;
            case 2:
                displayAllTasks();
                break;
            case 3:
                removeTask(in);
                break;
        }
    }

    private void displayAllTasks() {
        System.out.println("Вывод:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
    }

    private void removeTask(Scanner in) {
        in.nextLine();
        System.out.println("Введите номер задачи которую" +
                           " нужно удалить или Finish :");
        while (true) {
            System.out.println("номер:");
            String index = in.nextLine();
            if ("finish".equals(index.toLowerCase().trim())) {
                break;
            }
            tasks.remove(Integer.parseInt(index));
        }

    }

    private void addNewTask(Scanner in) {
        System.out.println("Введите таск:");
        in.nextLine(); //для того чтобы строка ниже заработала
        tasks.add(new Task(in.nextLine()));
    }

}

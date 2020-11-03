package homeworks.hw411;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskKeeper {
    private ArrayList<Task> tasks = new ArrayList<>(100);

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
                listAllTasks();
                break;
            case 3:
                removeTask(in);
                break;
        }
    }

    private void listAllTasks() {
        System.out.println("Вывод:");
        AtomicInteger runCount = new AtomicInteger(0);
        tasks.forEach(x ->
                System.out.println(" #" + runCount.getAndIncrement() + "  " + x));
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
